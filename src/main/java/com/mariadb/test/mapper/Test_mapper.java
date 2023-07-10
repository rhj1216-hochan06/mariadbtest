package com.mariadb.test.mapper;

import com.mariadb.test.model.Test_model;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface Test_mapper {
    List<Test_model> TestSelectTest(Test_model param);
    List<Test_model> TestSelectTestAll(Test_model param);
    List<Test_model> TestSelect();
    String Time();
}
