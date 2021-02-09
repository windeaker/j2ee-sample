package com.example.demo.multidatasource.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Select("select * from test_table")
    List<Long> selectAllIds();
}
