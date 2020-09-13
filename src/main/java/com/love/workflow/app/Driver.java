package com.love.workflow.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.love.converter.json.JsonUtil;
import com.love.http.handler.HttpRequestHandler;
import com.love.http.model.HttpJob;
import com.love.http.module.HttpModule;
import com.love.workflow.manager.WorkFlowManager;
import com.love.workflow.model.WorkFlowResponse;
import com.love.workflow.module.WorkFlowModule;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException {
        Injector injector = getInjector();
        WorkFlowManager workFlowManager = injector.getInstance(WorkFlowManager.class);
        String workFlowReq = "{\"workFlows\":[{\"name\":\"cartReq\",\"dependencies\":[],\"job\":{\"jobId\":\"1\",\"type\":\"HTTP\",\"request\":{\"url\":\"http://10.34.98.127:16000/de/cart/v1/calculate\",\"requestType\":\"POST\",\"contentType\":\"JSON\",\"headers\":{\"Content-Type\":\"application/json\",\"X-PERF-TEST\":\"false\",\"DE-CLIENT-CONTEXT\":\"CART\",\"X-CLIENT-ID\":\"cart\"},\"payload\":{\"id\":\"158388943863643-285-1034199121:P:C-0012\",\"pincode\":\"625009\",\"items\":[{\"id\":\"LSTMOBFAJB4DZJRGMGVFJO88N\",\"quantity\":1,\"vertical\":\"mobile\",\"freebie\":null,\"fsn_id\":\"MOBFAJB4DZJRGMGV\",\"seller_id\":\"bd91df39671142ca\",\"listing_id\":\"LSTMOBFAJB4DZJRGMGVFJO88N\",\"category_id\":\"20144\",\"flipkart_selling_price\":15999,\"market_place_id\":\"FLIPKART\",\"analytics_path\":[[{\"nodeId\":\"5000001\",\"nodeName\":\"FLIPKART_TREE\"},{\"nodeId\":\"5003003\",\"nodeName\":\"Mobile\"},{\"nodeId\":\"5003004\",\"nodeName\":\"Mobile\"},{\"nodeId\":\"5003005\",\"nodeName\":\"Mobile\"},{\"nodeId\":\"5003006\",\"nodeName\":\"Handset\"},{\"nodeId\":\"5003007\",\"nodeName\":\"Handset\"}]]}],\"client_reference_id\":\"T-158388943863643-285-1034199121\",\"account_id\":\"ACC14003333629875859\",\"terminal_id\":null,\"shipping_address_id\":null,\"flipkart_first\":null,\"sales_channel\":\"AndroidApp\",\"txn_time\":1556086011767}}}}]}";
        WorkFlowResponse response = workFlowManager.execute(workFlowReq);
        System.out.println(response.getResponse());
//        HttpJob httpJob = new HttpJob();
//        httpJob.setRequest("{\"url\":\"http://10.34.98.127:16000/de/cart/v1/calculate\",\"requestType\":\"POST\",\"contentType\":\"JSON\",\"headers\":{\"Content-Type\":\"application/json\",\"X-PERF-TEST\":\"false\",\"DE-CLIENT-CONTEXT\":\"CART\",\"X-CLIENT-ID\":\"cart\"},\"payload\":{\"id\":\"158388943863643-285-1034199121:P:C-0012\",\"pincode\":\"625009\",\"items\":[{\"id\":\"LSTMOBFAJB4DZJRGMGVFJO88N\",\"quantity\":1,\"vertical\":\"mobile\",\"freebie\":null,\"fsn_id\":\"MOBFAJB4DZJRGMGV\",\"seller_id\":\"bd91df39671142ca\",\"listing_id\":\"LSTMOBFAJB4DZJRGMGVFJO88N\",\"category_id\":\"20144\",\"flipkart_selling_price\":15999,\"market_place_id\":\"FLIPKART\",\"analytics_path\":[[{\"nodeId\":\"5000001\",\"nodeName\":\"FLIPKART_TREE\"},{\"nodeId\":\"5003003\",\"nodeName\":\"Mobile\"},{\"nodeId\":\"5003004\",\"nodeName\":\"Mobile\"},{\"nodeId\":\"5003005\",\"nodeName\":\"Mobile\"},{\"nodeId\":\"5003006\",\"nodeName\":\"Handset\"},{\"nodeId\":\"5003007\",\"nodeName\":\"Handset\"}]]}],\"client_reference_id\":\"T-158388943863643-285-1034199121\",\"account_id\":\"ACC14003333629875859\",\"terminal_id\":null,\"shipping_address_id\":null,\"flipkart_first\":null,\"sales_channel\":\"AndroidApp\",\"txn_time\":1556086011767}}");
//        System.out.println(httpRequestHandler.processHttpJob(httpJob).getResponse());
    }

    private static Injector getInjector() {
        return Guice.createInjector(new WorkFlowModule(), new HttpModule());
    }

}
