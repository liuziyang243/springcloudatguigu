package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2020-02-21 下午2:47
 */
public interface DeptService {
    boolean add(Dept dept);

    Dept get(Integer id);

    List<Dept> list();
}
