package com.love.workflow.executor;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.love.core.job.model.Job;
import com.love.http.handler.HttpRequestHandler;

import java.io.IOException;

@Singleton
public class HttpJobExecutor {

    @Inject
    private HttpRequestHandler httpRequestHandler;

    public Job execute(Job httpJob) throws IOException {
        return httpRequestHandler.processHttpJob(httpJob);
    }
}
