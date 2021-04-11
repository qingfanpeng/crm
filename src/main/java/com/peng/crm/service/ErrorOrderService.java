package com.peng.crm.service;

import com.peng.crm.pojo.Customer;
import com.peng.crm.pojo.ErrorOrder;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:39
 */
public interface ErrorOrderService extends CommonService<ErrorOrder> {
//    void add(ErrorOrder errorOrder);
//    void remove(Integer id);
//    ErrorOrder find(Integer id);
//    void update(ErrorOrder errorOrder);
    List<ErrorOrder> listByTime(String begin, String end);
}
