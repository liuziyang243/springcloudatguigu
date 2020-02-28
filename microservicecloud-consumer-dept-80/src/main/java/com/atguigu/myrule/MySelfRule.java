package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2020-02-27 上午8:43
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 默认是轮询，自定义为随机
        return new RandomRule_ZY();
    }
}
