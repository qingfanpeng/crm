package com.peng.crm.service;

import com.peng.crm.mapper.ProductionMapper;
import com.peng.crm.pojo.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-29-21:26
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    ProductionMapper productionMapper;

    @Override
    public void add(Production t) {
        productionMapper.insert(t);
    }

    @Override
    public void remove(Integer id) {
        productionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Production find(Integer id) {
        return productionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Production t) {
        productionMapper.updateByPrimaryKey(t);
    }

    @Override
    public List<Production> findAll() {
        return productionMapper.selectAll();
    }
}
