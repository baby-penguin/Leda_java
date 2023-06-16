package com.demo.htanswer.controller;

import com.demo.htanswer.dao.LetterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class LetterController {
    @Autowired
    LetterDao dao;

    @RequestMapping("/getLetters")//获取消息列表
    public List<Map> getLetters(@RequestParam("xh")String xh){
//        System.out.println(dao.getLetters(xh));
        return dao.getLetters(xh);
    }
    @RequestMapping("/getRelatives")//获取联系人列表
    public List<Map> getRelatives(@RequestParam("xh")String xh){
//        System.out.println(dao.getRelatives(xh));
        return dao.getRelatives(xh);
    }
    @RequestMapping("/getInforms")//获取通知列表
    public List<Map> getInforms(@RequestParam("xh")String xh){
//        System.out.println(dao.getInforms(xh));
        return dao.getInforms(xh);
    }
    @RequestMapping("/getMessages")//获取聊天记录
    public List<Map> getMessages(@RequestParam("xh1")String xh1,@RequestParam("xh2")String xh2){
//        System.out.println(dao.getMessages(xh1,xh2));
        return dao.getMessages(xh1,xh2);
    }
    @RequestMapping("/addLetter")//添加消息
    public String addLetter(@RequestParam("fromxh")String fromxh,@RequestParam("toxh")String toxh,@RequestParam("content")String content){
        dao.addLetter(fromxh,toxh,content);
        return "success";
    }
    @RequestMapping("/readMessages")//读消息
    public String readMessages(@RequestParam("xh1")String xh1,@RequestParam("xh2")String xh2){
        dao.readMessages(xh1,xh2);
        return "success";
    }

}
