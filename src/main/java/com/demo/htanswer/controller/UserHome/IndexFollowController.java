package com.demo.htanswer.controller.UserHome;

import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.User;
import com.demo.htanswer.bean.follow;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.dao.User.QuestionDao;
import com.demo.htanswer.dao.User.indexFollowDao;
import com.demo.htanswer.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexFollowController {
    @Autowired
    indexFollowDao followDao;
    @Autowired
    UserDao userDao;

    @Autowired
    QuestionDao questionDao;

    @CrossOrigin
    @RequestMapping("/getAllFollow")
    public String getAllFollow(@RequestParam("xh") int xh)
    {
        List<follow> data = followDao.getAllFollow(xh);
        String data_json = JSON.toJSONString(data);
//        System.out.println(data_json);
//        System.out.println("getAllFollow");
        return data_json;
    }

    @RequestMapping("/getAllFollowQuestion")
    public String getAllFollowQuestion(@RequestParam("xh") int xh){
            List<question> data=followDao.getFollowQuestion(xh);
        for(int i = 0; i<data.size(); i++)
        {

//            System.out.println(data);
            int QID=data.get(i).getQID();

            int follow_num=questionDao.getFollowNum(QID);
            int comment_num=questionDao.getCommentNum(QID);
            int follow_state=questionDao.getFollowState(QID,xh);
            String name=userDao.getNickname(xh);
            String photo=userDao.getProfilePhoto(xh);
            data.get(i).setQ_nickname(name);
            data.get(i).setQ_profile_photo(photo);
            data.get(i).setFollow_state(follow_state);
            data.get(i).setFollow_num(follow_num);
            data.get(i).setComment_num(comment_num);
        }
        String data_json = JSON.toJSONString(data);
        System.out.println(data_json);
        return data_json;

    }

}
