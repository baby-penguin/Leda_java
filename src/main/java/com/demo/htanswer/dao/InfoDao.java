package com.demo.htanswer.dao;

import com.demo.htanswer.bean.File;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.bean.search;
import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface InfoDao {

    //    查看某人关注的问题，返回前5条
    List<question> getFellowQuestion5(@Param("xh")int xh);

    List<question> getQuestionsByXh(@Param("xh")int xh);

    //    查看某人回答的问题->修改成了最近被采纳回答的问题
    List<question> getQuestionAndCommentByXh(@Param("xh")int xh);

    //    返回联想词
    List<search> getSearchImage(@RequestParam("search")String search);

    //    最热搜索
    List<search> getHotestSearch();

    //    查看是否有该条搜索
    List<search> ifHasSearch(@RequestParam("search")String search);

    //    搜索次数+1
    int SearchNumPlus(@RequestParam("id")int id);

    //    插入一条新的搜索
    int InserSearchContent(@RequestParam("search")String search);

    //    根据搜索内容返回搜索问题___%search%
    List<question> getQuestionBySearch(@RequestParam("search")String search);

    //    返回搜索回答的问题
    List<question> getQueationBySearchComment(@RequestParam("search")String search);

    //    返回搜索文件(按名称返回,按描述返回)
    List<File> getFileBySearch(@RequestParam("search")String search);


    //    获取昨日阅读数
    int getYesterdayRead(@RequestParam("xh")int xh);

    //    获取昨日回答量
    int getYesterdayAnswer(@RequestParam("xh")int xh);

    //    获取关注总数
    int getFollowNum(@RequestParam("xh")int xh);

    //    插入投诉信息
    int insertAccuseInfo(@RequestParam("accusexh")int accusexh, @RequestParam("accusedxh")int accusedxh, @RequestParam("meg")String meg, @RequestParam("newName")String newName);




}
