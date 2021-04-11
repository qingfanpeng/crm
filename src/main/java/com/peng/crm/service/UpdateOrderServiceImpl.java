package com.peng.crm.service;

import com.peng.crm.mapper.UpdateOrderMapper;
import com.peng.crm.pojo.UpdateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-20:35
 */
@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {

    @Autowired
   UpdateOrderMapper updateOrderMapper;


    @Override
    public void add(UpdateOrder t) {
        updateOrderMapper.insert(t);
    }

    @Override
    public void remove(Integer id) {
        updateOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UpdateOrder find(Integer id) {
        return updateOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(UpdateOrder t) {
        updateOrderMapper.updateByPrimaryKey(t);
    }

    @Override
    public List<UpdateOrder> listByCId(Integer id) {
        return updateOrderMapper.listByCId(id);
    }

    @Override
    public List<UpdateOrder> listAll() {
        return updateOrderMapper.selectAll();
    }

    @Override
    public List<UpdateOrder> listByUTime(String begin, String end) {
        return updateOrderMapper.listByUTime(begin, end);
    }

    @Override
    public List<UpdateOrder> listByTimeAndUser(String begin, String end, Integer uid) {
        List<UpdateOrder> updateOrders = updateOrderMapper.listByTimeAndUser(begin, end, uid);
        return updateOrders;
    }
}
