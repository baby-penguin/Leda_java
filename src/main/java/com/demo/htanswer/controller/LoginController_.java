package com.demo.htanswer.controller;


import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.User;
import com.demo.htanswer.dao.AdminDao;
import com.demo.htanswer.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController_ {
    @Autowired
    UserDao userDao;
    @Autowired
    AdminDao dao;

    @CrossOrigin
    @RequestMapping("/login")//改了登录返回
    public String login(@RequestBody User user){
//        return "ok";
        System.out.println("User : " + user);
        String str = "error";
        User usered = userDao.getUserByMassage(user.getXh(),user.getPassword());
        Map<String,Object> result=new HashMap<>();
        if (usered!=null) {//学生登录
            result.put("flag","ok");
            //            判断是否为今天第一次登录
            //
            if(userDao.isTodayFirstLogin(user.getXh())>0){
                result.put("first","yes");
                int j=userDao.coresAdd(user.getXh(), 1);
                System.out.println(j);
            }else {
                result.put("first","no");
            }
            String nowtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            userDao.recordLoginTime(user.getXh(),nowtime);//插入登录的时间
        }else if(dao.adminLogin(user.getXh(),user.getPassword())>0){
            result.put("flag","admin");
        }
        else{
            result.put("flag","error");
        }
        result.put("user",usered);
        String res= JSON.toJSONString(result);
        return res;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println("addUser:"+user);
        int i = userDao.addUser(user);
        String str="error";
        if(i>0){
            str="success";
        }
        return str;
    }

    @RequestMapping("/judgeUser")
    public String JugeUser(@RequestBody User user){
        System.out.println("user.xh:"+user.getXh());
        int i=userDao.judgeUser(user);
        String str="success";
        System.out.println("i:"+i);
        //System.out.print(i);
        if(i>=1){
            str="error";
        }
        return str;
    }


}
