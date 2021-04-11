package com.peng.crm.service;

import com.peng.crm.pojo.Production;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-29-21:24
 */
public interface ProductionService extends CommonService<Production> {
    List<Production> findAll();
}
