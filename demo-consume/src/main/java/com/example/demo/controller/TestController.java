package com.example.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Reference
    TestService testService;

    @RequestMapping("test1")
    public String test1() {
        return testService.test1();
    }

    @RequestMapping("test2")
    public String test2() {
        return testService.test2();
    }

    @RequestMapping("test3")
    public String test3() {
        return testService.test3();
    }

}
