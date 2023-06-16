package com.demo.htanswer.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LetterDao {
    List<Map> getLetters(String xh);
    List<Map> getRelatives(String xh);
    List<Map> getInforms(String xh);
    List<Map> getMessages(String xh1,String xh2);
    int addLetter(String fromxh,String toxh,String content);
    int readMessages(String xh1,String xh2);

}
