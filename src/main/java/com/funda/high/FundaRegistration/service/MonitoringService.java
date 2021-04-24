package com.funda.high.FundaRegistration.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import javax.jms.ConnectionFactory;
import java.util.Collections;

@Service
@Slf4j
public class MonitoringService {


    JmsTemplate jmsTemplate;
    int counter = 0;
    public MonitoringService(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }
    /*get pending jobs from user_registration*/
    public int numberOfPendingJobs(String registrationQueue){
        return jmsTemplate.browse(registrationQueue,((session, browser) ->
                Collections.list (browser.getEnumeration()).size ()));
    }

    /*get pending jobs from user_registration*/
    public int numberOfProcessedMessages(){
        return counter;
    }

    /*check activeMQ connection status*/
    public boolean isUp(){
        ConnectionFactory connectionFactory = jmsTemplate.getConnectionFactory();
        try{
            connectionFactory.createConnection();
            log.debug(connectionFactory.toString ());
            return  true;
        }catch (Exception exception){
            exception.printStackTrace ();
        }
        return  false;
    }
}
