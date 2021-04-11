package com.peng.crm.mapper;

import com.peng.crm.pojo.User;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;


/**
 * @author qingfan
 * @creat 2021-03-27-11:47
 */
@Repository
public interface UserMapper extends Mapper<User> {
//    void addUser(User user);
//    void removeUser(Integer id);
//    User findUser(Integer id);
//    void update(User user);
      User findOne(Integer id);
}
