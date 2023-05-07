package com.tyza66.greenbelt.mapper;

import com.tyza66.greenbelt.entity.GBArea;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/05/06 7:35
 * Github: https://github.com/tyza66
 **/
public interface GBAreaMapper {
    @Select("select * from g_b_area")
    public List<GBArea> getGBAreas();

    @Select("select * from g_b_area where address=#{add}")
    public List<GBArea> getGBAByAdd(String add);

    @Update("INSERT INTO `GreenBelt`.`g_b_area` (`address`, `min`, `max`) VALUES (#{address}, #{min}, #{max})")
    public int addArea(String address,String min,String max);
}
