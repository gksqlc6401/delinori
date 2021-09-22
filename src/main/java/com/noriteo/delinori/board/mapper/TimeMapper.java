package com.noriteo.delinori.board.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

//    @Select("select now()")
    String getTime();
}
