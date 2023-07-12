package com.mariadb.test.controller;

import com.mariadb.test.model.Test_model;
import com.mariadb.test.service.ITest_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/test")
public class Test_controller {

    private final ITest_service Itest_service;

    @Autowired
    public Test_controller(ITest_service Itest_service) {
        this.Itest_service = Itest_service;
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> insertTest(@Valid @RequestBody Test_model param) {
        Itest_service.TestInsert(param);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/select/{pid}")
    public ResponseEntity<List<Test_model>> selectTest(@PathVariable("pid") String pid) {
        Test_model param = new Test_model();
        param.setPid(pid);
        List<Test_model> result = Itest_service.TestSelectSearch(param);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateTest(@Valid @RequestBody Test_model param) {
        Itest_service.TestUpdate(param);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteTest(@Valid @RequestBody Test_model param) {
        String pid = param.getPid();
        Itest_service.TestDelete(pid);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/selectSearch")
    public ResponseEntity<List<Test_model>> selectSearchTest(@RequestBody Test_model param) {
        List<Test_model> result = Itest_service.TestSelectSearch(param);
        return ResponseEntity.ok(result);
    }

    ////아래는 DB 확인용
    @GetMapping("/time")
    public ResponseEntity<String> getTime() {
        String result = Itest_service.Time();
        System.out.println(result);
        return ResponseEntity.ok(result);
    }
}
