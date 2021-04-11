package com.peng.crm.service;

import com.peng.crm.pojo.Province;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:06
 */
public interface ProvinceService extends CommonService<Province> {
//    void add(Province province);
//    void remove(Integer id);
//    Province find(Integer id);
//    void update(Province province);
    List<Province> findAll();
}
