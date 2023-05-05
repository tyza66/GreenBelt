package com.tyza66.greenbelt.mapper;

import com.tyza66.greenbelt.entity.GBBars;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GBBarMapper {

    @Select("select * from g_b_bars")
    public List<GBBars> getAllBars();


}
