package com.love.workflow.manager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.love.converter.json.JsonUtil;
import com.love.core.job.model.Job;
import com.love.workflow.model.WorkFlow;
import com.love.workflow.model.WorkFlowRequest;
import com.love.workflow.model.WorkFlowResponse;
import com.love.workflow.validator.WorkFlowValidator;

import java.io.IOException;
import java.util.List;

@Singleton
public class WorkFlowManager {

    @Inject
    private WorkFlowValidator workFlowValidator;

    @Inject
    private WorkFlowOrderManager workFlowOrderManager;

    @Inject
    private JobExecutor jobExecutor;

    public WorkFlowResponse execute(String workFlowReq) throws IOException {
        WorkFlowRequest workFlowRequest = getWorkFlowRequest(workFlowReq);
        workFlowValidator.validate(workFlowRequest);
        List<WorkFlow> workFlowList = workFlowRequest.getWorkFlows();
        List<WorkFlow> ordereredWorkFlows = workFlowOrderManager.getOrderedWorkFlow(workFlowList);
        for(WorkFlow workFlow: ordereredWorkFlows){
            Job job = workFlow.getJob();
            jobExecutor.execute(job);
        }

        return null;
    }

    private WorkFlowRequest getWorkFlowRequest(String workFlowRequest){
        return JsonUtil.deser(workFlowRequest, WorkFlowRequest.class);
    }

}
