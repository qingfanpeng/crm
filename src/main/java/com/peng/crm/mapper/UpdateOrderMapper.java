package com.peng.crm.mapper;

import com.peng.crm.pojo.ErrorOrder;
import com.peng.crm.pojo.UpdateOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-27-20:36
 */
@Repository
public interface UpdateOrderMapper extends Mapper<UpdateOrder> {
    List<UpdateOrder> listByUTime(@Param("begin") String begin, @Param("end") String end);
    List<UpdateOrder> listByCId(Integer id);
    List<UpdateOrder> listByTimeAndUser(@Param("begin") String begin, @Param("end") String end, @Param("uid") Integer uid);
}
