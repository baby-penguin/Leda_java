package com.demo.htanswer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.htanswer.bean.Accuse;
import com.demo.htanswer.bean.File;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.bean.search;
import com.demo.htanswer.dao.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class InfoController {


    private String accusepath="C:\\Users\\1999J\\Documents\\Tencent Files\\2287986133\\FileRecv\\htanswer_vue\\htanswer_vue\\public\\accusefile";

    @Autowired
    InfoDao infoDao;

    @RequestMapping("/getFellowQuestion5")
    public String getFellowQuestion5(@RequestParam("xh")int xh){
        List<question> questions=infoDao.getFellowQuestion5(xh);
        Map<String,Object> result=new HashMap<>();
        result.put("data",questions);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/getQuestionsByXh")
    public String getQuestionsByXh(@RequestParam("xh")int xh){
        List<question> data = infoDao.getQuestionsByXh(xh);
        String data_json = JSON.toJSONString(data);
//        System.out.println(data_json);
        return data_json;
    }

    @RequestMapping("/getQuestionAndCommentByXh")
    public String getQuestionAndCommentByXh(@RequestParam("xh")int xh){
        List<question> data=infoDao.getQuestionAndCommentByXh(xh);
        String data_json = JSON.toJSONString(data);
//        System.out.println(data_json);
        return data_json;
    }

    //    联想搜索
    @RequestMapping("/getSearchImage")
    public String getSearchImage(@RequestParam("search")String search){
        String str=search+'%';//模糊搜索
//        System.out.println(str);
        List<com.demo.htanswer.bean.search> searchlist=infoDao.getSearchImage(str);
        Map<String,Object> result=new HashMap<>();
        result.put("data",searchlist);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/getHotestSearch")
    public String getHotestSearch(){
        List<search> hotest=infoDao.getHotestSearch();
        Map<String,Object> result=new HashMap<>();
        result.put("data",hotest);
        return JSON.toJSONString(result);
    }


    @RequestMapping("getQuestionBySearch")
    public String getQuestionBySearch(@RequestParam("search")String search){
        String str='%'+search+'%';
        List<question> questions=infoDao.getQuestionBySearch(str);
        List<search> searche=infoDao.ifHasSearch(search);
        if(searche!=null){//+1
            for (search se : searche) {
                infoDao.SearchNumPlus(se.getId());
            }
        }
        else{//插入浏览记录
            infoDao.InserSearchContent(search);
//            System.out.println("'"+search+"'");
        }
        Map<String,Object> result=new HashMap<>();
        result.put("data",questions);
//        System.out.println("返回的搜索内容\n"+questions);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/getSearchFiles")
    public String getSearchFiles(@RequestParam("search")String search){
        String str='%'+search+'%';
        List<File> files=infoDao.getFileBySearch(str);
        List<search> searche=infoDao.ifHasSearch(search);
        if(searche!=null){//+1
            for (search se : searche) {
                infoDao.SearchNumPlus(se.getId());
            }
        }
        else{//插入浏览记录
            infoDao.InserSearchContent(search);
//            System.out.println("'"+search+"'");
        }
        Map<String,Object> result=new HashMap<>();
        result.put("data",files);
        System.out.println(files);
        return JSON.toJSONString(result);
    }

    @RequestMapping("getSearchCommentResult")
    public String getSearchResult(@RequestParam("search")String search){
        String str='%'+search+'%';
        List<question> comments=infoDao.getQueationBySearchComment(str);
        List<search> searche=infoDao.ifHasSearch(search);
        if(searche!=null){//+1
            for (search se : searche) {
                infoDao.SearchNumPlus(se.getId());
            }
        }
        else{//插入浏览记录
            infoDao.InserSearchContent(search);
//            System.out.println("'"+search+"'");
        }
        Map<String,Object> result=new HashMap<>();
        result.put("comment",comments);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/getYesterdayInfo")
    public String getYesterdayInfo(@RequestParam("xh")int xh){
        int read=infoDao.getYesterdayRead(xh);
        int answer=infoDao.getYesterdayAnswer(xh);
        int follow=infoDao.getFollowNum(xh);
        Map<String,Object> result=new HashMap<>();
        result.put("read",read);
        result.put("answer",answer);
        result.put("follow",follow);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value="/accuseupload",produces = "application/json;charset=UTF-8")
    public String uploadFiles(@RequestParam("accusestring")String accusestring, MultipartFile file){
        System.out.println(accusestring);
        Map<String,Object> result = new HashMap<>();
        result =JSON.parseObject(accusestring);
        int accusexh=(int)result.get("accusexh");
        System.out.println(accusexh);
        int accusedxh=(int)result.get("accusedxh");
        String meg=(String) result.get("meg");
        String fileName=file.getOriginalFilename();
        String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());
//        System.out.println(fileTyle);
        String newName= UUID.randomUUID().toString()+fileTyle;
        try{
            file.transferTo(new java.io.File(accusepath,newName));
//            String nowtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            int i=infoDao.insertAccuseInfo(accusexh,accusedxh,meg,newName);
            if(i>0){
//                return "seccess";
                result.put("status","success");
//                result.put("url",newName);//newName返回用来查找文件位置
            }
            else{
//                return "error";
                result.put("status","error");
            }
        }catch (IOException e) {
            result.put("status", "error");
        }

        String res_string= JSON.toJSONString(result);
        return res_string;
    }

}
