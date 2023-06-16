package com.demo.htanswer.controller.UserHome;


import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.dao.User.QuestionDao;
import com.demo.htanswer.dao.User.indexMainDao;
import com.demo.htanswer.dao.UserDao;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexMainController {

    @Autowired
    UserDao userDao;

    @Autowired
    indexMainDao index_main;

    @Autowired
    QuestionDao questionDao;

    @CrossOrigin
    @RequestMapping("/getAllQuestion")
    public String getAllQuestion(){
//        HashMap<String, Object> data = new HashMap<>();
        List<question> data = index_main.getAllQuestion();
//        String user_nickname=userDao.getNickname(xh);
//        data.put("data",questions);
//        data.put("nickname",user_nickname);
        //
        for(int i=0;i<data.size();i++)
        {
            int QID=data.get(i).getQID();
            int xh=data.get(i).getQ_xh();
            String nickname=userDao.getNickname(xh);
            String profile_photo=userDao.getProfilePhoto(xh);
            int follow_num=questionDao.getFollowNum(QID);
            int comment_num=questionDao.getCommentNum(QID);
            int follow_state=questionDao.getFollowState(QID,xh);
            data.get(i).setFollow_num(follow_num);
            data.get(i).setComment_num(comment_num);
            data.get(i).setQ_nickname(nickname);
            data.get(i).setQ_profile_photo(profile_photo);
            data.get(i).setFollow_state(follow_state);

            String temp=data.get(i).getQ_content_html();
            String returnHtml = HtmlUtils.htmlUnescape(temp);
            data.get(i).setQ_content_html(returnHtml);

        }

        String data_json = JSON.toJSONString(data);
//        System.out.println(data_json);
//        System.out.println("成功访问！！！");
        return data_json;
    }
    @RequestMapping("/dislikeQuestion")
    public int dislikeQuestion(@RequestParam("QID")int QID,@RequestParam("xh") int xh){
        int state=0;
        state=questionDao.dislikeQuestion(QID,xh);
//        System.out.println("dislike");
//        System.out.println(state);
        return state;
    }

}
