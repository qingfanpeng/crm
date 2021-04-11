package com.peng.crm.service;

import com.peng.crm.mapper.UserMapper;
import com.peng.crm.pojo.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * @author qingfan
 * @creat 2021-03-27-11:51
 */

public interface UserService extends CommonService<User> {
//    void add(User user);
//    void remove(Integer id);
//    User find(Integer id);
//    void update(User user);
    User findOne(Integer id);
    Integer findUserId(String username);
    User findByName(String name);
}
