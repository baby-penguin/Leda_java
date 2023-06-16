package com.demo.htanswer.dao.User;

import com.demo.htanswer.bean.Tag;
import com.demo.htanswer.bean.question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavDao {
    public int postQuestion(question Question);
    public List<Tag> getAllTag();
    public String getTagname(int TID);
    public List<Tag> getPartofTag(String tag_name);
    public int insertQ_T(int QID,int TID);
    public int coresReduce(int xh,int num);

}
