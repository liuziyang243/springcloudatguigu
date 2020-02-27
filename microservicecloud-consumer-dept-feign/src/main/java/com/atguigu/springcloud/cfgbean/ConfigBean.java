package com.atguigu.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuziyang
 * @create 2020-02-22 21:53
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 显式配置轮询算法
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
