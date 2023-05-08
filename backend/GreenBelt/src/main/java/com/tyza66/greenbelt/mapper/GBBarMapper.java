package com.tyza66.greenbelt.mapper;

import com.tyza66.greenbelt.entity.GBBars;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GBBarMapper {

    @Select("select * from g_b_bars")
    List<GBBars> getAllBars();

    @Update("INSERT INTO `GreenBelt`.`g_b_bars` (`address`, `name`, `group`) VALUES (#{address}, #{name}, 1)")
    @Transactional
    int addGbBars(String address, String name);

    @Update("DELETE FROM `GreenBelt`.`g_b_bars` WHERE `id` = #{id}")
    @Transactional
    int deleteGbBars(int id);
}
