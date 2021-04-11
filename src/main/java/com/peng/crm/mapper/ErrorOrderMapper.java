package com.peng.crm.mapper;

import com.peng.crm.pojo.ErrorOrder;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-16:41
 */
@Repository
public interface ErrorOrderMapper extends Mapper<ErrorOrder> {
    List<ErrorOrder> listByETime(String begin, String end);
}
