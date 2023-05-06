package com.tyza66.greenbelt.mapper;

import com.tyza66.greenbelt.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where account = #{account}")
    List<User> getUserByAccount(String account);

    @Update("INSERT INTO `GreenBelt`.`user` ( `account`, `password`, `username`, `nickname`, `statu`) VALUES (#{account}, #{password}, #{username}, #{nickname}, #{statu})")
    @Transactional
    int newUserCount(User user);

}
