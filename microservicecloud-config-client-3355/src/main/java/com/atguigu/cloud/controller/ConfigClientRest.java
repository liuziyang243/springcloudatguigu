package com.atguigu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuziyang
 * @create 2020-03-01 22:17
 */
@RestController
public class ConfigClientRest {
    @Value("${spring.application.name}")
    private String applicaionName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        String str = "applicationName:" + applicaionName + "\t eruekaServers:" + eurekaServers + "\t port:" + port;
        System.out.println(str);
        return str;
    }
}
