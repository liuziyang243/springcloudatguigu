package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2020-02-21 下午3:05
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    @Qualifier("discoveryClient")
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept add(@PathVariable("id") Integer id) {
        final Dept dept = deptService.get(id);
        if (null == dept) {
            throw new RuntimeException("该id" + id + "没有对应的信息");
        }

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Integer id) {
        return new Dept().setDeptno(Long.valueOf(id))
                .setDname("该id:" + id + "没有对应信息，null--@HystrixCommand")
                .setDb_source("no this " +
                        "database in Mysql");
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> add() {
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("************" + list);
        List<ServiceInstance> serviceInstanceList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance : serviceInstanceList) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getUri());
        }

        return this.client;
    }
}
