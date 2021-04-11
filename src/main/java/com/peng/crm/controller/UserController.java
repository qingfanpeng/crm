package com.peng.crm.controller;

import com.peng.crm.pojo.Customer;
import com.peng.crm.pojo.Province;
import com.peng.crm.pojo.User;
//import com.peng.crm.service.CommonService;
import com.peng.crm.service.CommonService;
import com.peng.crm.service.CustomerService;
import com.peng.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tk.mybatis.mapper.common.Mapper;

import javax.sound.midi.Soundbank;

/**
 * @author qingfan
 * @creat 2021-03-27-14:26
 */
@Controller
public class UserController {

    UserService userService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CommonService<Customer> commonService;

    @Autowired
    CommonService<Province> commonService_p;

    public UserController(CommonService<Customer> commonService, UserService userService) {
        this.userService = userService;
        this.commonService = commonService;
    }


    @GetMapping("/test")
    public String test() {

//        System.out.println(customerService.listByProvinceId(2));

        System.out.println(userService.find(1));
//        User user = new User();
//        user.setName("王五");
//        user.setPassword("123456");
//        User user = userService.find(1);
//        Province province = commonService_p.find(1);
//        Customer lili = new Customer(2,"lili", province, "110", "110", user, null);
//        commonService.add(lili);
//        System.out.println(commonService.find(3));
        return "login";
    }

    @PostMapping("/user")
    public String updateUser(User user) {
        userService.add(user);
        return "updateuser";
    }

}



