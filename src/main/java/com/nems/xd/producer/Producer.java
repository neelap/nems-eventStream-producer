package com.nems.xd.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Producer {

    @Autowired
    private MessageChannel output;

    @RequestMapping(method = RequestMethod.POST, value = "/producer")
    public String send(@RequestBody String evt){
        output.send(MessageBuilder.withPayload(evt.toString()).build());
        return evt;
    }

}