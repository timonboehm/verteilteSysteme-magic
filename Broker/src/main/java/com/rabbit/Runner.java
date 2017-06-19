package com.rabbit;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class Runner implements CommandLineRunner {

	private String requestmsg= "default";
    private final RabbitTemplate rabbitTemplate;
    private final Msgreceiver receiver;
    private final ConfigurableApplicationContext context; 

    public Runner(Msgreceiver receiver, RabbitTemplate rabbitTemplate,
            ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
    	
    }
    
    @RequestMapping("/send")
    void magicroute(@RequestParam("msg")String requestmsg) throws Exception {
    	this.requestmsg = requestmsg;
  
    	System.out.println("####################################################################");
        System.out.println("Sending message...");
        System.out.println("####################################################################");
        rabbitTemplate.convertAndSend(BrokerApplication.queueName, requestmsg);
        //receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        //context.close();
    	
    }

}