package com.peng.crm.service;

import com.peng.crm.mapper.ErrorOrderMapper;
import com.peng.crm.pojo.ErrorOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:40
 */
@Service
public class ErrorOrderServiceImpl implements ErrorOrderService {

    final
    ErrorOrderMapper errorOrderMapper;

    public ErrorOrderServiceImpl(ErrorOrderMapper errorOrderMapper) {
        this.errorOrderMapper = errorOrderMapper;
    }

    @Override
    public void add(ErrorOrder errorOrder) {
        errorOrderMapper.insert(errorOrder);
    }

    @Override
    public void remove(Integer id) {
        errorOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ErrorOrder find(Integer id) {
        return errorOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(ErrorOrder errorOrder) {
        errorOrderMapper.updateByPrimaryKey(errorOrder);
    }

    @Override
    public List<ErrorOrder> listByTime(String begin, String end) {
        return errorOrderMapper.listByETime(begin, end);
    }
}
