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
        System.out.println("insert: " + param.getPid() + " : " + param.getPt_nm());
        test_mapper.TestInsert(param);
    }

    @Override
    public Test_model TestSelect(String pid) {
        Test_model result = test_mapper.TestSelect(pid);
        System.out.println("insert: " + result.getPid() + " : " + result.getPt_nm());
        return result;
    }

    @Override
    public void TestUpdate(Test_model param) {
        System.out.println("update: " + param.getPid() + " : " + param.getPt_nm());
        test_mapper.TestUpdate(param);
    }

    @Override
    public void TestDelete(String pid) {
        Test_model result = test_mapper.TestSelect(pid);
        System.out.println("delete: " + result.getPid() + " : " + result.getPt_nm());
        test_mapper.TestDelete(pid);
    }

    @Override
    public List<Test_model> TestSelectSearch(Test_model param) {
        List<Test_model> result = test_mapper.TestSelectSearch(param);
        System.out.println(result);
        return result;
    }

    @Override
    public String Time() {
        String result = test_mapper.Time();
        System.out.println(result);
        return result;
    }
}
