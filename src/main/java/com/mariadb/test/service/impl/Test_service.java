// Test_service.java

package com.mariadb.test.service.impl;

import com.mariadb.test.mapper.Test_mapper;
import com.mariadb.test.model.Test_model;
import com.mariadb.test.service.ITest_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test_service implements ITest_service {

    @Autowired
    Test_mapper test_mapper;

    @Override
    public void TestInsert(Test_model param) {
        test_mapper.TestInsert(param);
    }

    @Override
    public Test_model TestSelect(String pid) {
        return test_mapper.TestSelect(pid);
    }

    @Override
    public void TestUpdate(Test_model param) {
        test_mapper.TestUpdate(param);
    }

    @Override
    public void TestDelete(String pid) {
        test_mapper.TestDelete(pid);
    }

    @Override
    public List<Test_model> TestSelectSearch(Test_model param) {
        return test_mapper.TestSelectSearch(param);
    }
    @Override
    public String Time() {
        return test_mapper.Time();
    }
}
