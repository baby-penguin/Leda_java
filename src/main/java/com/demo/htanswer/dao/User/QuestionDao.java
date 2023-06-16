package com.demo.htanswer.dao.User;

import com.demo.htanswer.bean.Tag;
import com.demo.htanswer.bean.comment;
import com.demo.htanswer.bean.question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao {
    public List<Tag> getQtag(int QID);
    public question getQuestion(int QID);
    public int followQuestion(int QID,int xh);
    public int getFollowState(int QID,int xh);
    public int cancelFollow(int QID,int xh);
    public int getCommentNum(int QID);
    public int getFollowNum(int QID);
    public int browseQuestion(int QID,int xh);
    public int getBrowseNum(int QID);
    public int Comment(comment comment);
    public List<comment> getAllComment(int QID);
    public int dislikeQuestion(int QID,int xh);
    public int likeComment(int CID,int xh);
    public int cancelLikeComment(int CID,int xh);
    public int likeCommentNum(int CID);
    public int getLikeCommentState(int CID,int xh);

    public List<question> getMyquestions(@Param("xh") int xh);
    public question getQuestion_t_time(@Param("QID")int QID);
    public List<comment> getMyAnswer(@Param("xh") int xh);
    public String getQuestionTitle(@Param("QID") int QID);
    public List<question> getQuestionToday();
    public List<question> getQuestionSevenDay();
    public List<question> getMyFollow(@Param("xh") int xh);
    public int browseTags(@Param("TID") int tid,@Param("xh") int xh);
    public int cancelbrowseTags(@Param("TID") int tid,@Param("xh") int xh);
    public int getQuestionByCID(@Param("CID") int cid);
    //找一个人最近最近最常访问的tag
    public List<Tag> getRecentlyTags(@Param("xh") int xh);
    //找某人对某tid的访问次数
    public int getBrowseTagCount(@Param("xh") int xh,@Param("tid") int tid);
    public List<question> getNewQuestions();
    public comment getBestComment(@Param("QID") int QID);
    public int Q_likeComment(@Param("CID") int CID);
    public int UpdateBit(@Param("xh") int xh,@Param("bitAdd") int bitAdd);
}
