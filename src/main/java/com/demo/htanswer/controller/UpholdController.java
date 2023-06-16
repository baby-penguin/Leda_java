package com.demo.htanswer.controller;


import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.User;
import com.demo.htanswer.dao.UpholdDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.FileHandler;

@RestController
public class UpholdController {

    //    头像路径
//    private String Path="F:\\vue_demo\\htanswer_vue\\src\\assets\\img_self";
    private String Path="F:\\vue_demo\\Leda_vue\\src\\assets\\img_self";
    //  文件路径
//    private String filePath="F:\\vue_demo\\htanswer_vue\\public\\files";
    private String filePath="F:\\vue_demo\\Leda_vue\\public\\files";

    @Autowired
    UpholdDao upholdDao;

    //SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @CrossOrigin
    @RequestMapping("/upload")
    public String fileupload(@RequestParam(value="xh",required=false) int xh,MultipartFile file, HttpServletRequest req){
        //System.out.println(xh);
        Map<String,Object> result=new HashMap<>();
        //String format=sdf.format(new Date());
        String newName= UUID.randomUUID().toString()+".jpg";
        try {
            file.transferTo(new File(Path,newName));
            //String url=req.getScheme()+"://"+req.getServerName()+":"+req.getServerName()+format+newName;
            String url=newName;
            System.out.println(url);
            int i=upholdDao.editUserProfile_photo(xh,url);
            System.out.println(i);
            if(i>0){
                result.put("status","success");
                result.put("url",url);
            }
            else{
                result.put("status","error");
            }
        }catch (IOException e){
            System.out.println("error");
            result.put("status","error");
            result.put("mse",e.getMessage());
        }
        String res_string= JSON.toJSONString(result);
        return res_string;
    }


    @RequestMapping("/uploadFiles")
    public String uploadFiles(@RequestParam("xh")int xh,MultipartFile file){
        //System.out.println(xh);
        Map<String,Object> result=new HashMap<>();
        String fileName=file.getOriginalFilename();
        System.out.println("文件名："+fileName);
        String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        System.out.println(fileTyle);
        String newName= UUID.randomUUID().toString()+fileTyle;
        try{
            file.transferTo(new File(filePath,newName));
            String nowtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            int i=upholdDao.upholdFiles(xh,newName,fileName,nowtime);
            if(i>0){
                result.put("status","success");
                result.put("url",newName);//newName返回用来查找文件位置
            }
            else{
                result.put("status","error");
            }
        }catch (IOException e){
            result.put("status","error");
        }
        String res_string= JSON.toJSONString(result);
        return res_string;
    }



    @RequestMapping("requestUser")
    public String requestUser(@RequestParam("xh")int xh){
        User user=upholdDao.requestUser(xh);
        System.out.println("返回用户信息");
        Map<String,Object> result=new HashMap<>();
        result.put("data",user);
        return JSON.toJSONString(result);
    }

    @RequestMapping("editUserInfo")
    public String editUserInfo(@RequestParam("xh")int xh,@RequestParam("nickname")String nickname,@RequestParam("password")String password){
        int i=upholdDao.editUserInfo(xh,nickname,password);
        return i>0?"success":"error";
    }

    @RequestMapping("getFileList")
    public String getFileList(@Param("xh")int xh){
        List<com.demo.htanswer.bean.File> files=upholdDao.getFileList(xh);
        Map<String,Object> result=new HashMap<>();
        result.put("data",files);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/addLoadNum")
    public void addLoadNum(@RequestParam("id")int id){
        upholdDao.addLoadNum(id);
    }

    @RequestMapping("/getTop10File")
    public String getTop10File(){
        List<com.demo.htanswer.bean.File> files=upholdDao.getTop10File();
        Map<String,Object> result=new HashMap<>();
        result.put("data",files);
        return JSON.toJSONString(result);
    }


}


