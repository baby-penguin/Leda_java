package com.demo.htanswer.controller.UserHome.Question;

import com.alibaba.fastjson.JSON;
import com.demo.htanswer.bean.RespBean;
import com.demo.htanswer.bean.Tag;
import com.demo.htanswer.bean.comment;
import com.demo.htanswer.bean.question;
import com.demo.htanswer.dao.User.QuestionDao;
import com.demo.htanswer.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class detailsController {
    @Autowired
    QuestionDao questionDao;
    @Autowired
    UserDao userDao;

    @CrossOrigin
    @RequestMapping("/getQtag")
    public String getQtag(@RequestParam int QID){
        List<Tag> data=questionDao.getQtag(QID);
        String Tag_json = JSON.toJSONString(data);
        System.out.println(Tag_json);
        return Tag_json;
    }
    @RequestMapping("/getAllComment")
    public String getAllComment(@RequestParam("QID") int QID,@RequestParam("xh")int xh){
        List<comment> data = questionDao.getAllComment(QID);
        for(int i=0;i<data.size();i++){
            int CID=data.get(i).getCID();
            int state=questionDao.getLikeCommentState(CID,xh);
            int c_xh=data.get(i).getXh();
            int num=questionDao.likeCommentNum(CID);
            String nickname=userDao.getNickname(c_xh);
            String profile_photo=userDao.getProfilePhoto(c_xh);
            data.get(i).setLike_Comment_state(state);
            data.get(i).setC_nickname(nickname);
            data.get(i).setC_profile_photo(profile_photo);
            data.get(i).setLike_comment_num(num);
        }

        String data_json= JSON.toJSONString(data);
        System.out.println(data_json);

        return  data_json;
    }
    @RequestMapping("/Comment")
    public RespBean Comment(@RequestBody comment Comment){

        //处理评论摘要
        if (Comment.getComment_summary() == null || "".equals(Comment.getComment_summary() )) {
            //直接截取
            String stripHtml = stripHtml(Comment.getComment_content_html());
           Comment.setComment_summary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));
        }
        int state=questionDao.Comment(Comment);
        RespBean res=new RespBean();
        if(state==0)
        {
            res.setStatus("0");
            res.setMsg("评论失败！");
        }
        else {
            res.setStatus("1");
            res.setMsg("评论成功~");
        }
        return res;
    }
    public String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }
    @RequestMapping("/getQuestion")
    public String getQuestion(@RequestParam int QID){
        //browe_q++
        question data=questionDao.getQuestion(QID);

        String temp=data.getQ_content_html();
        String returnHtml = HtmlUtils.htmlUnescape(temp);
        data.setQ_content_html(returnHtml);
        int xh=data.getQ_xh();
        String nickname=userDao.getNickname(xh);
        data.setQ_nickname(nickname);
        String Q_profile_photo=userDao.getProfilePhoto(xh);
        data.setQ_profile_photo(Q_profile_photo);
        String Question_json = JSON.toJSONString(data);
//        System.out.println(Question_json);
        return Question_json;
    }
    @RequestMapping("/browseQuestion")
    public int browseQuestion(@RequestParam("QID") int QID,@RequestParam("xh") int xh)
    {
        int state;
        state =questionDao.browseQuestion(QID,xh);
        //在浏览问题的时候通过QID找到对应问题的tid，
        // 在browsetags中插入对应的记录
        browseTags(QID,xh);
        return  state;
    }
    @RequestMapping("/getBrowseNum")
    public int getBrowseNum(@RequestParam("QID") int QID)
    {
        int num=0;
        num=questionDao.getBrowseNum(QID);
        return num;
    }
    @RequestMapping("/followQuestion")
    public int followQuestion(@RequestParam("QID") int QID, @RequestParam("xh") int xh){
        int state;
        state=questionDao.followQuestion(QID,xh);
        browseTags(QID,xh);
//        System.out.println(state);
        return  state;
    }
    @RequestMapping("/getFollowState")
    public int getFollowState(@RequestParam("QID") int QID, @RequestParam("xh") int xh){
        int state;
        state=questionDao.getFollowState(QID,xh);
        System.out.println("followstate");
//        System.out.println(state);
        return  state;
    }
    @RequestMapping("/cancelFollow")
    public int cancelFollow(@RequestParam("QID") int QID, @RequestParam("xh") int xh){
        int state;
        state=questionDao.cancelFollow(QID,xh);
//        System.out.println(state);
        return  state;
    }
    @RequestMapping("/getCommentNum")
    public int getCommentNum(@RequestParam("QID") int QID){
        int Commentnum;
        Commentnum=questionDao.getCommentNum(QID);
//        System.out.println(Commentnum);
        return  Commentnum;
    }
    @RequestMapping("/getFollowNum")
    public int getFollowNum(@RequestParam("QID") int QID){
        int num;
        num=questionDao.getFollowNum(QID);
//        System.out.println(num);
        return  num;

    }
    @RequestMapping("likeComment")
    public int likeComment(@RequestParam("CID") int CID,@RequestParam("xh") int xh){
        int state=0;
        state=questionDao.likeComment(CID,xh);
        int QID=questionDao.getQuestionByCID(CID);
        browseTags(QID,xh);
        return state;
    }
    @RequestMapping("cancelLikeComment")
    public int cancelLikeComment(@RequestParam("CID") int CID,@RequestParam("xh") int xh){
        int state=0;
        state=questionDao.cancelLikeComment(CID,xh);
        return state;
    }
    @RequestMapping("likeCommentNum")
    public int likeCommentNum(@RequestParam("CID") int CID){
        int num=0;
        num=questionDao.likeCommentNum(CID);
        return num;
    }
    @RequestMapping("getLikeCommentState")
    public int getLikeCommentState(@RequestParam("CID")int CID,@RequestParam("xh")int xh){
        int state=0;
        state=questionDao.getLikeCommentState(CID,xh);
        return  state;
    }

    @RequestMapping("/browseTags")
    public int browseTags(@RequestParam("QID") int QID,@RequestParam("xh") int xh)
    {
        int state=0;
        List<Tag> tag_list=questionDao.getQtag(QID);
        for(int i=0;i<tag_list.size();i++)
        {
            int tid=tag_list.get(i).getTID();
            //在browse_tags插入一条记录
            questionDao.browseTags(tid,xh);
        }
        return state;
    }
    @RequestMapping("/cancelBrowseTags")
    public int cancelBrowseTags(@RequestParam("QID") int QID,@RequestParam("xh")int xh)
    {
        int state=0;
        List<Tag>Tag_list=questionDao.getQtag(QID);
        for(int i=0;i<Tag_list.size();i++)
        {
            int tid=Tag_list.get(i).getTID();
            questionDao.cancelbrowseTags(tid,xh);
        }
        return state;
    }
    @RequestMapping("/getBestComment")
    public String getBestComment(@RequestParam("QID") int QID)
    {
        comment data=questionDao.getBestComment(QID);
//        int CID=data.getCID();
        if(data!=null){
            int c_xh=data.getXh();
            String nickname=userDao.getNickname(c_xh);
            String profile_photo=userDao.getProfilePhoto(c_xh);
            String gender=userDao.getUserGender(c_xh);
            String profession=userDao.getUserProfession(c_xh);
            int bit=userDao.getUserBit(c_xh);
            data.setC_nickname(nickname);
            data.setC_profile_photo(profile_photo);
            data.setC_bit(bit);
            data.setC_gender(gender);
            data.setC_profession(profession);
        }
        String data_json = JSON.toJSONString(data);
        return  data_json;

    }
    @RequestMapping("/Q_likeComment")
    public int Q_likeComment(@RequestParam("CID") int CID)
    {
        int state=0;
        state=questionDao.Q_likeComment(CID);
        return state;
    }
    @RequestMapping("/UpdateBit")
    public int UpdateBit(@RequestParam("xh") int xh,@RequestParam("bitAdd") int bitAdd)
    {
        int state=0;
        state=questionDao.UpdateBit(xh,bitAdd);
        return  state;
    }

}
