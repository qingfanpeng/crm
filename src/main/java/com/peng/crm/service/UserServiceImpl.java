package com.peng.crm.service;

import com.peng.crm.mapper.UserMapper;
import com.peng.crm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qingfan
 * @creat 2021-03-27-11:51
 */
@Service
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void remove(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User find(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User findOne(Integer id) {
        return userMapper.findOne(id);
    }

    @Override
    public Integer findUserId(String username) {
        User user = new User();
        user.setName(username);
        Integer uid = userMapper.selectOne(user).getId();
        System.out.println("uid" + uid);
        if (uid == null) {
            uid = 1;
        }
        return uid;
    }

    @Override
    public User findByName(String name) {
        User user = new User();
        user.setName(name);
        return userMapper.selectOne(user);
    }
}
