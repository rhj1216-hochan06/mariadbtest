package com.mariadb.test.controller;

import com.mariadb.test.model.Test_model;
import com.mariadb.test.service.ITest_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class Test_controller {

    @Autowired
    private ITest_service Itest_service;

    @PostMapping("/TestSelectTest")
    @ResponseBody
    public Object TestSelectTest(@RequestBody Test_model param) {
        return this.Itest_service.TestSelectTest(param);
    }

    @PostMapping("/TestSelectTestAll")
    @ResponseBody
    public Object TestSelectTestAll(@RequestBody Test_model param) {
        System.out.println("\n"+param+"\n");
        return this.Itest_service.TestSelectTestAll(param);
    }    
    @GetMapping ("/TestSelect")
    @ResponseBody
    public Object TestSelect() {
//        System.out.println("\n 여기까지 오는지 확인1 \n");
        return this.Itest_service.TestSelect();
    }

    @GetMapping("/Time")
    @ResponseBody
    public String Time() {
        return this.Itest_service.Time();
    }
    @GetMapping("/Test")
    @ResponseBody
    public List<String> test(Test_model param) {
        List<String> list = Arrays.asList(param.getPid(), param.getPt_nm());
        System.out.println(list);
        return list;
    }
}
