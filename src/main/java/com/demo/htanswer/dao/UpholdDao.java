package com.demo.htanswer.dao;


import com.demo.htanswer.bean.File;
import com.demo.htanswer.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

@Repository
public interface UpholdDao {

     int editUserProfile_photo(@Param("xh")int xh,@Param("profile_photo")String profile_photo);

     User requestUser(@Param("xh")int xh);

     int editUserInfo(@Param("xh")int xh,@Param("nickname")String nickname,@Param("password")String password);

     int upholdFiles(@Param("xh")int xh,@Param("file_src")String file_src,@Param("file_name")String name,@Param("time")String time);

     //    获取文件列表
     List<File> getFileList(@Param("xh")int xh);

     //     增加文件的下载量
     int addLoadNum(@Param("id")int id);

     //     获取下载榜前10
     List<File> getTop10File();


}
