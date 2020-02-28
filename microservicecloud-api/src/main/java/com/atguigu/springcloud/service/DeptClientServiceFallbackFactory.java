package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2020-02-28 下午1:11
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Integer id) {
                return new Dept().setDeptno(Long.valueOf(id))
                        .setDname("该id:" + id + "没有对应信息，null--Consumer客户单提供降级信息，此刻服务提供者已经关闭")
                        .setDb_source("no this " +
                                "database in Mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
