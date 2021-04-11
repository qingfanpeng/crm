package com.peng.crm.service;

import com.peng.crm.mapper.CustomerMapper;
import com.peng.crm.pojo.Customer;
import com.peng.crm.pojo.UpdateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.ExampleMapper;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:33
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    final
    CustomerMapper customerMapper;

    @Autowired
    UpdateOrderService updateOrderService;

    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public void add(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public void remove(Integer id) {
        customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Customer find(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public List<Customer> listAll() {
        return customerMapper.selectAll();
    }

    @Override
    public List<Customer> listByProvinceId(Integer id) {
        return customerMapper.listByProvinceId(id);
    }

    @Override
    public List<Customer> listByIndustryId(Integer id) {
        return customerMapper.listByIndustryId(id);
    }

    @Override
    public List<Customer> listByNameLike(String word) {
        return customerMapper.listByNameLike(word);
    }

    @Override
    public Customer listByOrderId(Integer oid) {
        UpdateOrder updateOrder = updateOrderService.find(oid);
        Customer customer = customerMapper.selectByPrimaryKey(updateOrder.getCustomerId());
        return customer;
    }


}
