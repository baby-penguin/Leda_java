package com.demo.htanswer.controller.UserHome;

import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.Tag;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.dao.User.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    QuestionDao questionDao;

    @CrossOrigin
    @RequestMapping("/getRecentlyTags")
    public String getRecentlyTags(@RequestParam("xh") int xh){
        //获得最常访问的标签列表
        List<Tag> data=questionDao.getRecentlyTags(xh);
        String data_json = JSON.toJSONString(data);
        System.out.println(data_json);
        return data_json;
    }
    @RequestMapping("/getRecommendQuestions")
    public String getRecommendQuestions(@RequestParam("xh") int xh){
        //推荐，按照用户浏览tid的次数
        //按照最近七天问题的tid的浏览次数之和排序
        List<question> q_list=questionDao.getQuestionSevenDay();
        for(int i=0;i<q_list.size();i++)
        {
            int QID=q_list.get(i).getQID();
            List<Tag>tag_list=questionDao.getQtag(QID);
            int count_browse_tags=0;
            for(int j=0;j<tag_list.size();j++)
            {
                int tid=tag_list.get(j).getTID();
                count_browse_tags+=questionDao.getBrowseTagCount(xh,tid);
            }
            q_list.get(i).setHot_level(count_browse_tags);
        }
        Collections.sort(q_list,new question());
        String data_json= JSON.toJSONString(q_list);
        System.out.println(data_json);
        return data_json;
    }
    @CrossOrigin
    @RequestMapping("/getMostPopularQuestions")
    public String getHotQuestions(){
        //根据最近七天问题的关注量，评论量，浏览量
        //最后排序按照 关注量+浏览量给出权重排序
        List<question> data=questionDao.getQuestionSevenDay();
        for(int i=0;i<data.size();i++)
        {
            int QID=data.get(i).getQID();
            int follow_num=questionDao.getFollowNum(QID);
            int browse_num=questionDao.getBrowseNum(QID);

            int hot_level=(follow_num*3+browse_num*2);
            data.get(i).setHot_level(hot_level);
        }
        Collections.sort(data,new question());
        String data_json= JSON.toJSONString(data);
//        System.out.println("popular");
//        System.out.println(data_json);
        return data_json;
    }
    @RequestMapping("/getNewQuestions")
    public String getNewQuestions() {
        List<question> data=questionDao.getNewQuestions();
        String data_json= JSON.toJSONString(data);
//        System.out.println("popular");
//        System.out.println(data_json);
        return data_json;

    }
}
