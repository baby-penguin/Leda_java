package com.demo.htanswer.dao.User;

import com.demo.htanswer.bean.question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface indexMainDao {

    public List<question> getAllQuestion();
}
