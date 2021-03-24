package com.example.quartz.jobs;

import com.alibaba.fastjson.JSON;
import com.example.quartz.QuartzService;
import com.example.quartz.entity.Task;
import com.example.quartz.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Slf4j
@Component
public class FirstJob extends QuartzJobBean {

    @Resource
    QuartzService quartzService;

    @Resource
    DemoService demoService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String body = jobDataMap.get("body").toString();
        Task task = JSON.parseObject(body, Task.class);
        demoService.baba();
//        try {
//            Thread.sleep(5000);
//            System.out.println(123);
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        quartzService.deleteJob("abcd", "test");
        log.info(jobDataMap.get("name").toString()+"///"+task.toString());
    }
}
