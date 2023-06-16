package com.demo.htanswer.controller.UserHome.Question;

//import com.alibaba.fastjson.util.IOUtils;
import org.apache.commons.io.IOUtils;
import com.demo.htanswer.bean.RespBean;
import com.demo.htanswer.dao.User.NavDao;
import com.demo.htanswer.dao.User.QuestionDao;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/question")
public class QuestionPostController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    //    question_image路径
    private String Path="F://vue_demo//vue//htanswer_vue//src//assets//question_im_self//";
    @Autowired
    QuestionDao questionDao;

    @Autowired
    NavDao navDao;

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public RespBean addNewArticle(question article) {
//        int result = navDao.postQuestion(article);
//        if (result == 1) {
//            return new RespBean("success", article.getId() + "");
//        } else {
//            return new RespBean("error", article.getState() == 0 ? "文章保存失败!" : "文章发表失败!");
//        }
//    }

    /**
     * 上传图片
     *
     * @return 返回值为图片的地址
     */
    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
    public RespBean uploadImg(HttpServletRequest req, MultipartFile image) {
        StringBuffer url = new StringBuffer();
        String filePath = "/blogimg/" + sdf.format(new Date());
        String imgFolderPath = req.getServletContext().getRealPath(filePath);
        File imgFolder = new File(imgFolderPath);
        if (!imgFolder.exists()) {
            imgFolder.mkdirs();
        }
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append(req.getServerPort())
                .append(req.getContextPath())
                .append(filePath);
        String imgName = UUID.randomUUID() + "_" + image.getOriginalFilename().replaceAll(" ", "");
        try {
            IOUtils.write(image.getBytes(), new FileOutputStream(new File(imgFolder, imgName)));
            url.append("/").append(imgName);
            return new RespBean("success", url.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RespBean("error", "上传失败!");
    }

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public Map<String, Object> getArticleByState(@RequestParam(value = "state", defaultValue = "-1") Integer state, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "6") Integer count, String keywords) {
//        int totalCount = articleService.getArticleCountByState(state, Util.getCurrentUser().getId(),keywords);
//        List<question> articles = articleService.getArticleByState(state, page, count,keywords);
//        Map<String, Object> map = new HashMap<>();
//        map.put("totalCount", totalCount);
//        map.put("articles", articles);
//        return map;
//    }

//    @RequestMapping(value = "/{aid}", method = RequestMethod.GET)
//    public Article getArticleById(@PathVariable Long aid) {
//        return articleService.getArticleById(aid);
//    }

//    @RequestMapping(value = "/dustbin", method = RequestMethod.PUT)
//    public RespBean updateArticleState(Long[] aids, Integer state) {
//        if (articleService.updateArticleState(aids, state) == aids.length) {
//            return new RespBean("success", "删除成功!");
//        }
//        return new RespBean("error", "删除失败!");
//    }

//    @RequestMapping(value = "/restore", method = RequestMethod.PUT)
//    public RespBean restoreArticle(Integer articleId) {
//        if (articleService.restoreArticle(articleId) == 1) {
//            return new RespBean("success", "还原成功!");
//        }
//        return new RespBean("error", "还原失败!");
//    }

//    @RequestMapping("/dataStatistics")
//    public Map<String,Object> dataStatistics() {
//        Map<String, Object> map = new HashMap<>();
//        List<String> categories = articleService.getCategories();
//        List<Integer> dataStatistics = articleService.getDataStatistics();
//        map.put("categories", categories);
//        map.put("ds", dataStatistics);
//        return map;
//    }
}
