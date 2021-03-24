package com.example.quartz.entity;

import lombok.Data;

@Data
public class Task {

    public String TaskId;

    public String taskName;

    public String ImageName;

    public Task(String TaskId,String taskName,String ImageName){
        this.TaskId = TaskId;
        this.taskName = taskName;
        this.ImageName = ImageName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskId='" + TaskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", ImageName='" + ImageName + '\'' +
                '}';
    }
}
