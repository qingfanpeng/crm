package com.peng.crm.mapper;

import com.peng.crm.pojo.Customer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:35
 */
@Repository
public interface CustomerMapper extends Mapper<Customer> {
    List<Customer> listByProvinceId(Integer id);
    List<Customer> listByIndustryId(Integer id);
    List<Customer> listByNameLike(String word);
}
