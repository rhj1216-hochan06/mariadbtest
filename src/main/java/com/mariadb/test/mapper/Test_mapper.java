// Test_mapper.java

package com.mariadb.test.mapper;

import com.mariadb.test.model.Test_model;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Test_mapper {
    void TestInsert(Test_model param);
    Test_model TestSelect(String pid);
    void TestUpdate(Test_model param);
    void TestDelete(String pid);
    List<Test_model> TestSelectSearch(Test_model param);
    List<Test_model> TestSelect();
    String Time();
}
