package com.example.demo.task;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.VideoCatoryService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Description: TODO
 * @Author: yy
 * @Date: Created in 2020/2/20 22:50
 * @Modified By：
 */

// @Component
// @Configuration      //1.主要用于标记配置类，兼备Component的效果。
// @EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Reference
    private VideoCatoryService videoCatoryService;

    @Async
    @Scheduled(fixedDelay = 30000)  //间隔30秒
    public void first() throws InterruptedException {
        System.out.println("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());

        videoCatoryService.updates(1);
    }

    @Async
    @Scheduled(fixedDelay = 30000)
    public void second() {
        System.out.println("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        videoCatoryService.updates(2);

    }


    @Async
    @Scheduled(fixedDelay = 30000)
    public void three() {
        System.out.println("第三个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        videoCatoryService.updates(3);
    }

}
