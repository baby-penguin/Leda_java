package com.demo.htanswer.controller.UserHome;

import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.dao.User.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class IndexHotController {
    @Autowired
    QuestionDao questionDao;

    @CrossOrigin
    @RequestMapping("/getHotQuestions")
    public String getHotQuestions(){
        //根据最近七天问题的关注量，评论量，浏览量
        //最后排序按照 关注量*30%，评论量50%，浏览量20% 给出权重排序
        List<question> data=questionDao.getQuestionSevenDay();
        for(int i=0;i<data.size();i++)
        {
            int QID=data.get(i).getQID();
            int comment_num=questionDao.getCommentNum(QID);
            int follow_num=questionDao.getFollowNum(QID);
            int browse_num=questionDao.getBrowseNum(QID);

            int hot_level=(comment_num*5+follow_num*3+browse_num*2);
            data.get(i).setHot_level(hot_level);
        }
        Collections.sort(data,new question());
        String data_json= JSON.toJSONString(data);
        System.out.println("HOT");
        System.out.println(data_json);
        return data_json;
    }
}

