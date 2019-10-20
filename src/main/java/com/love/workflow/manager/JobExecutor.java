package com.love.workflow.manager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.love.core.job.model.Job;
import com.love.workflow.executor.HttpJobExecutor;

import java.io.IOException;

@Singleton
public class JobExecutor {

    @Inject
    private HttpJobExecutor httpJobExecutor;

    public void execute(Job job) throws IOException {
        switch (job.getType()){
            case HTTP:
                System.out.println(httpJobExecutor.execute(job));
                break;
        }
    }
}
