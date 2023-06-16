package com.demo.htanswer.dao.User;

import com.demo.htanswer.bean.follow;
import com.demo.htanswer.bean.question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface indexFollowDao {
    public List<follow> getAllFollow(int xh);
    public List<question> getFollowQuestion(int xh);
}
