package com.peng.crm.service;

import com.peng.crm.pojo.ErrorOrder;
import com.peng.crm.pojo.Industry;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:43
 */
public interface IndustryService extends CommonService<Industry> {
//    void add(Industry industry);
//    void remove(Integer id);
//    Industry find(Integer id);
//    void update(Industry industry);
    List<Industry> findAll();
}
