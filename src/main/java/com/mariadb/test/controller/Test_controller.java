// Test_controller.java

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

    @PostMapping("/TestInsert")
    @ResponseBody
    public void TestInsert(@RequestBody Test_model param) {
        this.Itest_service.TestInsert(param);
    }

    @GetMapping("/TestSelect/{pid}")
    @ResponseBody
    public List<Test_model> TestSelect(@PathVariable("pid") String pid) {
        Test_model param = null;
        param.setPid(pid);
        return this.Itest_service.TestSelectSearch(param);
    }

    @PostMapping("/TestUpdate")
    @ResponseBody
    public void TestUpdate(@RequestBody Test_model param) {
        this.Itest_service.TestUpdate(param);
    }

    @PostMapping("/TestDelete")
    @ResponseBody
    public void deleteTest(@RequestBody Test_model param) {
        this.Itest_service.TestDelete(param.getPid());
    }

    @PostMapping("/TestSelectSearch")
    @ResponseBody
    public List<Test_model> TestSelectSearch(@RequestBody Test_model param) {
        return this.Itest_service.TestSelectSearch(param);
    }

    ////아래는 DB 확인용
    @GetMapping("/Time")
    @ResponseBody
    public String Time() {

        return this.Itest_service.Time();
    }

}
