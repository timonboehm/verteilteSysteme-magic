package com.rabbit;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class Msgreceiver {
	private String m = "Nicht Leo";
	    private CountDownLatch latch = new CountDownLatch(1);
	    public void receiveMessage(String message) {
	    	System.out.println("###############################################################");
	        System.out.println("Received <" + message + ">");
	    	System.out.println("###############################################################");

	        m = message;
	       // latch.countDown();
	    }

	    public CountDownLatch getLatch() {
	        return latch;
	    }
	    
	    @RequestMapping("/magic")
	    String magicroute() throws Exception {
	    	return m;
	    }

	}

