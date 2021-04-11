package com.peng.crm.service;

import com.peng.crm.pojo.Industry;

/**
 * @author qingfan
 * @creat 2021-03-27-16:51
 */
public interface CommonService<E> {
    void add(E t);
    void remove(Integer id);
    E find(Integer id);
    void update(E t);
}
