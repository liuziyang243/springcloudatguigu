package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2020-02-21 下午2:35
 */
@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept findById(Integer id);

    List<Dept> findAll();
}
