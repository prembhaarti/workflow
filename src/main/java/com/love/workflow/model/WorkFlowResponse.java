package com.love.workflow.model;

import lombok.Data;

@Data
public class WorkFlowResponse {
    private String response;
    private Status status = Status.STARTED;
}
