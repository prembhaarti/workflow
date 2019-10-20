package com.love.workflow.module;

import com.google.inject.AbstractModule;
import com.love.workflow.manager.WorkFlowManager;

public class WorkFlowModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(WorkFlowManager.class);
    }
}
