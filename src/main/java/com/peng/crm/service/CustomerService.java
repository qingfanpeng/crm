package com.peng.crm.service;

import com.peng.crm.pojo.Customer;
import com.peng.crm.pojo.Province;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:26
 */
public interface CustomerService extends CommonService<Customer> {
//    void add(Customer customer);
//    void remove(Integer id);
//    Customer find(Integer id);
//    void update(Customer customer);
    List<Customer> listAll();
    List<Customer> listByProvinceId(Integer id);
    List<Customer> listByIndustryId(Integer id);
    List<Customer> listByNameLike(String word);
    Customer listByOrderId(Integer oid);
}
