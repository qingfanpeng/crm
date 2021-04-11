package com.peng.crm.service;

import com.peng.crm.pojo.UpdateOrder;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-20:34
 */
public interface UpdateOrderService extends CommonService<UpdateOrder> {
    List<UpdateOrder> listByCId(Integer id);
    List<UpdateOrder> listAll();
    List<UpdateOrder> listByUTime(String begin, String end);
    List<UpdateOrder> listByTimeAndUser(String begin, String end, Integer uid);
}
