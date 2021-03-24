package com.example.quartz.jobs;

import com.alibaba.fastjson.JSON;
import com.example.quartz.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class FirstJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String body = jobDataMap.get("body").toString();
        Task task = JSON.parseObject(body, Task.class);
        log.info(jobDataMap.get("name").toString()+"///"+task.toString());
    }
}
