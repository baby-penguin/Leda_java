package com.demo.htanswer.controller.UserHome;


import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.User;
import com.demo.htanswer.bean.comment;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.dao.User.QuestionDao;
import com.demo.htanswer.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    QuestionDao questionDao;

    @CrossOrigin
    @RequestMapping("/getUserByXh")
    public String getUserByXh(@RequestParam("xh") int xh){
        //通过学号获得别人的页面信息
        String json="error";
        User user=userDao.getUserByXh(xh);
        System.out.println(user);
        json= JSON.toJSONString(user);
        return  json;
    }

    @RequestMapping("/getMyQuestions")
    public String getMyQuestions(@RequestParam("xh") int xh){
//        String res="error";
        List<question> data=questionDao.getMyquestions(xh);
        for(int i=0;i<data.size();i++)
        {
            int QID=data.get(i).getQID();
            int comment_num=questionDao.getCommentNum(QID);
            int follow_num=questionDao.getFollowNum(QID);

            data.get(i).setComment_num(comment_num);
            data.get(i).setFollow_num(follow_num);
        }
        String data_json = JSON.toJSONString(data);
//        System.out.println("myquestion");
//        System.out.println(data_json);
        return  data_json;
    }
    @RequestMapping("/getMyAnswer")
    public String getMyAnswer(@RequestParam("xh") int xh){
        List<comment> data=questionDao.getMyAnswer(xh);
        for(int i=0;i< data.size();i++)
        {
            int QID=data.get(i).getQID();
            int CID=data.get(i).getCID();
            String title=questionDao.getQuestionTitle(QID);
            int like_num=questionDao.likeCommentNum(CID);
            data.get(i).setLike_comment_num(like_num);
            data.get(i).setQ_title(title);
        }
        String data_json=JSON.toJSONString(data);
        return  data_json;
    }

}
