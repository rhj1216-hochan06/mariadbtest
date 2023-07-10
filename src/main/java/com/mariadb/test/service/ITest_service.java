package com.mariadb.test.service;
import com.mariadb.test.model.Test_model;
import java.util.List;

public interface ITest_service {
    List<Test_model> TestSelectTest(Test_model param);
    List<Test_model> TestSelectTestAll(Test_model param);
    List<Test_model> TestSelect();

    String Time();
}
