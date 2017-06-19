package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
class ConfigServerRestController{
    @Value("${config.property: Default}")
    private String configProperty;

    @RequestMapping("/valueFromServer")
    String valueFromServer() {
	    return this.configProperty;
	}
    @RequestMapping("/magic")
    String magicroute() {
	    return "No Message";
	}

}

