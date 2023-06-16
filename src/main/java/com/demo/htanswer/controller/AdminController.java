package com.demo.htanswer.controller;


import com.demo.htanswer.bean.*;
import com.demo.htanswer.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminDao dao;

    //    @CrossOrigin
    @RequestMapping("/finduser")//查询用户信息
    public List<User> findUser(@RequestParam("user")String info){
        return dao.findUser("%"+info+"%");
    }
    @RequestMapping("/accusenum")
    public int accuseNum(){
        return dao.accuseNum();
    }
    @RequestMapping("/filenum")
    public int fileNum(){
        return dao.fileNum();
    }
    @RequestMapping("/findaccuse")
    public List<Accuse> findAccuse(){
        return dao.findAccuse();
    }
    @RequestMapping("/findfile")
    public List<File> findFile(){
        return dao.findFile();
    }
    @RequestMapping("/allfile")
    public List<File> allFile(){
        return dao.allFile();
    }
    @RequestMapping("/iceuser")
    public String iceUser(@RequestParam("xh")String xh){
        dao.iceUser(xh);
        return "success";
    }
    @RequestMapping("/findbit")
    public int findBit(@RequestParam("xh")String xh){
        return dao.findBit(xh);
    }
    @RequestMapping("/addbit")
    public String addBit(@RequestParam("xh")String xh,@RequestParam("bit")int bit){
        dao.addBit(xh,bit);
        return "success";
    }
    @RequestMapping("/delaccuse")
    public String delAccuse(@RequestParam("accusexh")String accusexh,@RequestParam("accusedxh")String accusedxh,@RequestParam("time")String time,@RequestParam("meg1")String meg1,@RequestParam("meg2")String meg2){
        dao.delAccuse(accusexh,time);
        String nowtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        dao.addInform(accusexh,meg1);
        if(meg2!="")
            dao.addInform(accusedxh,meg2);
        return "success";
    }
    @RequestMapping("/admitfile")
    public String admitFile(@RequestParam("file_name")String file_name){
        dao.admitFile(file_name);
        return "success";
    }
    @RequestMapping("/rejectfile")
    public String rejectFile(@RequestParam("file_name")String file_name,@RequestParam("xh")String xh,@RequestParam("meg")String meg){
        dao.rejectFile(file_name);
        String nowtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        dao.addInform(xh,meg);
        return "success";
    }

}
