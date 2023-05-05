package com.tyza66.greenbelt.mapper;

import com.tyza66.greenbelt.entity.GBArea;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/05/06 7:35
 * Github: https://github.com/tyza66
 **/
public interface GBAreaMapper {
    @Select("select * from g_b_area")
    public List<GBArea> getGBAreas();
}
