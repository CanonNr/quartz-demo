package com.example.quartz.controller;

import com.alibaba.fastjson.JSON;
import com.example.quartz.QuartzService;
import com.example.quartz.entity.Task;
import com.example.quartz.jobs.FirstJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Slf4j
@RestController
public class TestController {

    @Resource
    QuartzService quartzService;

    @GetMapping("/test1")
    public String test1(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",1);
        quartzService.deleteJob("job", "test");
        quartzService.addJob(FirstJob.class, "job", "test", "0 * * * * ?", map);
        log.info("create job...");
        return "ok";
    }

    @GetMapping("/test2")
    public String test2(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","job-test");
        map.put("status","OK");
        Date date = new Date(System.currentTimeMillis() + 20*1000);

//        quartzService.deleteJob(, "test");
        quartzService.addJob(FirstJob.class, UUID.randomUUID().toString().replace("-",""), "test", date, map);
        log.info("create job... {}",date);
        return "ok";
    }


    @GetMapping("/test3")
    public String test3(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","job-test");
        map.put("status","OK");
        Task task = new Task("abcd","create","ubuntu");
        map.put("body", JSON.toJSON(task));
        Date date = new Date(System.currentTimeMillis() + 10*1000);
        quartzService.addJob(FirstJob.class, "abcd", "test", date, map);
        log.info("create job... {}",date);
        return "ok";
    }


    @GetMapping("/test3/d")
    public String test3d(){
        quartzService.deleteJob("abcd", "test");
        log.info("delete abcd");
        return "ok";
    }

    @GetMapping("/test3/a")
    public String test3a(){
        quartzService.runAJobNow("abcd", "test");
        quartzService.deleteJob("abcd", "test");
        log.info("run abcd");
        return "ok";
    }
}
