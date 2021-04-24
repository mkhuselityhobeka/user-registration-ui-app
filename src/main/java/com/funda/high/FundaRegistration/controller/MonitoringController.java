package com.funda.high.FundaRegistration.controller;

import com.funda.high.FundaRegistration.config.JmsConfig;
import com.funda.high.FundaRegistration.service.MonitoringService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MonitoringController {

    MonitoringService monitoringService;

    public MonitoringController(MonitoringService monitoringService){
        this.monitoringService = monitoringService;
    }

    @RequestMapping(value = "/health")
    public ResponseEntity<HttpStatus> health(){
        HttpStatus httpStatus;
        if (monitoringService.isUp()){
            httpStatus = HttpStatus.OK;
        }else{
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(httpStatus);
    }

    @ResponseBody
    @RequestMapping(value = "/metrics",  produces="text/plain")
    public String matrics(){
        int numberOfMessagesInUserReqQueue = monitoringService.numberOfPendingJobs(JmsConfig.userRegQName);

        return  "# HELP messages Number of messages in the userRegQName\n"
                + "# TYPE messages gauge\n"
                + "messages " + numberOfMessagesInUserReqQueue;
    }

}
