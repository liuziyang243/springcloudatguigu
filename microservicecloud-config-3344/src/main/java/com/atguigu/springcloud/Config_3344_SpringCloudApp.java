package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuziyang
 * @create 2020-03-01 21:18
 */
@EnableConfigServer
@SpringBootApplication
public class Config_3344_SpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Config_3344_SpringCloudApp.class, args);
    }
}
