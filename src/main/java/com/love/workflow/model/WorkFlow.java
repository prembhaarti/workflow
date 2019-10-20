package com.love.workflow.model;

import com.love.core.job.model.Job;
import lombok.Data;

import java.util.List;

@Data
public class WorkFlow {
    private String name;
    private List<String> dependencies;
    private Job job;
    private Status status;

}
