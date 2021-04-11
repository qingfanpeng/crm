package com.peng.crm.service;

import com.peng.crm.mapper.IndustryMapper;
import com.peng.crm.pojo.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:44
 */
@Service
public class IndustryServiceImpl implements IndustryService {

    final
    IndustryMapper industryMapper;

    public IndustryServiceImpl(IndustryMapper industryMapper) {
        this.industryMapper = industryMapper;
    }

    @Override
    public void add(Industry industry) {
        industryMapper.insert(industry);
    }

    @Override
    public void remove(Integer id) {
        industryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Industry find(Integer id) {
        return industryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Industry industry) {
        industryMapper.updateByPrimaryKey(industry);
    }

    @Override
    public List<Industry> findAll() {
        return industryMapper.selectAll();
    }
}
