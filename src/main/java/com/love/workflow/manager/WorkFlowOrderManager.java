package com.love.workflow.manager;

import com.google.inject.Singleton;
import com.love.workflow.model.WorkFlow;

import java.util.List;

@Singleton
public class WorkFlowOrderManager {

    public List<WorkFlow> getOrderedWorkFlow(List<WorkFlow> workFlows){
        return workFlows;
    }
}
