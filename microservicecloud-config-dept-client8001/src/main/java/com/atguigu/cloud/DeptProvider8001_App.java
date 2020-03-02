package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2020-03-02 上午11:35
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class DeptProvider8001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
