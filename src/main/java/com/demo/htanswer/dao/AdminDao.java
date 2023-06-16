package com.demo.htanswer.dao;

import com.demo.htanswer.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    //管理员的操作
    //管理员登录
    int adminLogin(int id,String password);
    //查询用户信息
    List<User> findUser(String info);
    //新举报数
    int accuseNum();
    //待审核文件数
    int fileNum();
    //举报列表
    List<Accuse> findAccuse();
    //待审核文件列表
    List<File> findFile();
    //所有文件（已通过审核）
    List<File> allFile();
    //冻结用户
    int iceUser(String xh);
    //查询积分值
    int findBit(String xh);
    //增加或扣除积分值
    int addBit(String xh,int bit);
    //发送通知
    int addInform(String xh,String meg);
    //处理举报
    int delAccuse(String accusexh,String time);
    //文件审核通过
    int admitFile(String file_name);
    //文件审核失败
    int rejectFile(String file_name);



}
