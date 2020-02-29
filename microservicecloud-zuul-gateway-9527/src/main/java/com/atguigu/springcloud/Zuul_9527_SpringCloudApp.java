package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuziyang
 * @create 2020-02-29 20:40
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_SpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_SpringCloudApp.class, args);
    }
}
