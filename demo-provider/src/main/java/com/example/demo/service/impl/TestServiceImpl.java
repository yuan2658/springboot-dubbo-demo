package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.service.TestService;

/**
 * @author yy
 */
@Service   //属于Dubbo的@Service注解，非Spring  作用：暴露服务
public class TestServiceImpl implements TestService {

    @Override
    public String test1() {
        return "这是test1方法";
    }

    @Override
    public String test2() {
        return "这是test2方法";
    }

    @Override
    public String test3() {
        return "这是test3方法";
    }
}
