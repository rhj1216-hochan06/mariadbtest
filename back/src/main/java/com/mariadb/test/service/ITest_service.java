package com.mariadb.test.service;
import com.mariadb.test.model.Test_model;
import java.util.List;

public interface ITest_service {
    void TestInsert(Test_model param);
    Test_model TestSelect(String pid);
    void TestUpdate(Test_model param);
    void TestDelete(String pid);
    List<Test_model> TestSelectSearch(Test_model param);
    String Time();
}
