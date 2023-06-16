package com.demo.htanswer.controller.UserHome;

import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.RespBean;
import com.demo.htanswer.bean.Tag;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.dao.User.NavDao;
import com.demo.htanswer.dao.User.QuestionDao;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Map;

@RestController
public class NavController {
    @Autowired
    NavDao navDao;
    @Autowired
    QuestionDao questionDao;


    @CrossOrigin
    @RequestMapping("/postQuestion")
    public RespBean postQuestion(@RequestBody question Question){
        RespBean res=new RespBean();
        //处理问题摘要
        if (Question.getQ_summary() == null || "".equals(Question.getQ_summary())) {
            //直接截取
            String stripHtml = stripHtml(Question.getQ_content_html());
           Question.setQ_summary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));
        }
        String html= Question.getQ_content_html();
        String html_in=HtmlUtils.htmlEscapeHex(html);
//        System.out.println(html_in);
        Question.setQ_content_html(html_in);
//        System.out.println("摘要");
//        System.out.println(Question.getQ_summary());
        int state= navDao.postQuestion(Question);
//        System.out.println(state);
        int QID=Question.getQID();
        int [] Tidlist=Question.getDynamicTags();
//        System.out.println(Tidlist.length);
        //插入标签
        for(int i = 0; i<Tidlist.length; i++)
        {
            navDao.insertQ_T(QID,Tidlist[i]);
        }

        if(state==0)
        {
            res.setStatus("0");
            res.setMsg("Post the Question Error!");
        }
        else
        {
            res.setStatus("1");
            int xh=Question.getQ_xh();
            List<Tag> tag_list=questionDao.getQtag(QID);
            for(int i=0;i<tag_list.size();i++)
            {
                int TID=tag_list.get(i).getTID();
                questionDao.browseTags(TID,xh);
            }
            questionDao.followQuestion(QID,xh);
            res.setMsg("Post Successfully!");
        }
        return res;
    }

    public String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }


    @RequestMapping("/getAllTag")
    public String getAllTag(){
        List<Tag> tag=navDao.getAllTag();
//        System.out.println(tag);
        String Tag_json = JSON.toJSONString(tag);
        return Tag_json;
    }
    @RequestMapping("/getTagname")
    public String getTagname(@RequestParam("TID") int TID){
        String tag_name=navDao.getTagname(TID);
//        System.out.println(tag_name);
        return tag_name;
    }
    @RequestMapping("/getPartofTag")
    public String getPartofTag(@RequestParam("tag_name") String tag_name){
        List<Tag> tag=navDao.getPartofTag(tag_name);
        String Tag_json = JSON.toJSONString(tag);
//        System.out.println(Tag_json);
        return Tag_json;
    }
    @RequestMapping("/coresReduce")
    public int coresReduce(@RequestParam("xh") int xh,@RequestParam("num") int num){
        int state=0;
        navDao.coresReduce(xh,num);
        return state;
    }


}
