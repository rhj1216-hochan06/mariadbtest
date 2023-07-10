package com.mariadb.test.service.impl;

import com.mariadb.test.mapper.Test_mapper;
import com.mariadb.test.model.Test_model;
import com.mariadb.test.service.ITest_service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class Test_service implements ITest_service {
    @Autowired
    Test_mapper test_mapper;
    @Override
    public List<Test_model> TestSelectTest(Test_model param){
        return test_mapper.TestSelectTest(param);
    }
    @Override
    public List<Test_model> TestSelectTestAll(Test_model param){
        return test_mapper.TestSelectTestAll(param);
    }

    @Override
    public List<Test_model> TestSelect(){
        System.out.println("\n 여기까지 오는지 확인2 \n");
        return test_mapper.TestSelect();
    }
    @Override
    public String Time(){
        System.out.println("\n 여기까지 오는지 확인2 \n");
        return test_mapper.Time();
    }

}
