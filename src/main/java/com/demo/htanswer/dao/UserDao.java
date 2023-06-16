package com.demo.htanswer.dao;

import com.demo.htanswer.bean.User;
import com.demo.htanswer.bean.question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public  User getUserByMassage(@Param("xh") int xh, @Param("password") String password);
    public String getNickname(@Param("xh") int xh);
    public String getProfilePhoto(@Param("xh") int xh);
    public User getUserByXh(@Param("xh") int xh);//进入别人主页

    public int addUser(User user);
    public int judgeUser(User user);

    int recordLoginTime(@Param("xh")int xh,@Param("lastime")String lastime);

    Integer isTodayFirstLogin(@Param("xh")int xh);

    int coresAdd(@Param("xh")int xh,@Param("cores")int cores);

    public String getUserGender(@Param("xh") int xh);
    public String getUserProfession(@Param("xh") int xh);
    public int getUserBit(@Param("xh") int xh);

    //


}
