package com.love.workflow.model;

import lombok.Data;

import java.util.List;

@Data
public class WorkFlowRequest {
    private List<WorkFlow> workFlows;
}
