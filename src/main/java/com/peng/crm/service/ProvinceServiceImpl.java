package com.peng.crm.service;

import com.peng.crm.mapper.ProvinceMapper;
import com.peng.crm.pojo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:16
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceMapper provinceMapper;

    public ProvinceServiceImpl(ProvinceMapper provinceMapper) {
        this.provinceMapper = provinceMapper;
    }

    @Override
    public void add(Province province) {
        provinceMapper.insert(province);
    }

    @Override
    public void remove(Integer id) {
        provinceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Province find(Integer id) {
        return provinceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Province province) {
        provinceMapper.updateByPrimaryKey(province);
    }

    @Override
    public List<Province> findAll() {
        return provinceMapper.selectAll();
    }
}
