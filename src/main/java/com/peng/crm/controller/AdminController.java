package com.peng.crm.controller;

import com.peng.crm.pojo.Customer;
import com.peng.crm.pojo.UpdateOrder;
import com.peng.crm.service.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author qingfan
 * @creat 2021-03-28-14:30
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    final
    CustomerService customerService;
    final
    ProductionService productionService;
    final
    UserService userService;
    final
    ProvinceService provinceService;
    final
    IndustryService industryService;
    final
    UpdateOrderService updateOrderService;

    public AdminController(CustomerService customerService, ProductionService productionService, UserService userService, ProvinceService provinceService, IndustryService industryService, UpdateOrderService updateOrderService) {
        this.customerService = customerService;
        this.productionService = productionService;
        this.userService = userService;
        this.provinceService = provinceService;
        this.industryService = industryService;
        this.updateOrderService = updateOrderService;
    }

//    @GetMapping("/")
//    public String index(@RequestParam(value = "username") String username, @RequestParam(value = "begin") String begin, @RequestParam(value = "end") String end, Model model) {
//        Integer userId = userService.findUserId(username);
//        List<UpdateOrder> updateOrders = updateOrderService.listByTimeAndUser(begin, end, userId);
//        System.out.println(updateOrderService.listByTimeAndUser("2021-03-25", "2021-04-08", 1));
//        model.addAttribute("updateOrders", updateOrders);
//        return "admin";
//    }

    @PostMapping("/updateu")
    public String updateUser() {
        return "updateuser";
    }

    @PostMapping("updatec")
    public String updateCustomer() {
        return "updatec";
    }



    @GetMapping
//    @ResponseBody
    public String a_index(@RequestParam(value = "username",defaultValue = "") String username, @RequestParam(value = "begin",defaultValue = "") String begin, @RequestParam(value = "end",defaultValue = "") String end, Model model) {
//        System.out.println(updateOrderService.listByCId(1));
//        System.out.println(updateOrderService.listByUTime("2021-04-03", "2021-04-08"));
        HashMap<Integer, String> map = new HashMap<>();
        List<UpdateOrder> updateOrders = null;
        Integer userId = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("username=" + username);
        if (!username.isEmpty() && username != null) {
            System.out.println("123");
            userId = userService.findUserId(username);
        }
        if ( begin.isEmpty() || end.isEmpty()) {
            Date date = new Date(System.currentTimeMillis());
            String formatdate = simpleDateFormat.format(date);
            begin = formatdate;
            end = formatdate;
        }
        System.out.println(begin);
        updateOrders = updateOrderService.listByTimeAndUser(begin, end, userId);

        for (UpdateOrder updateOrder:
                updateOrders) {
            Integer oid = updateOrder.getId();
            map.put(oid,customerService.listByOrderId(oid).getName());
        }

        model.addAttribute("updateOrders", updateOrders);
        model.addAttribute("map", map);
        return "admin";
    }


    @GetMapping("/test")
    @ResponseBody
    public void test() {
        System.out.println(updateOrderService.listByTimeAndUser("2021-04-03", "2021-04-08",3));
        System.out.println(updateOrderService.listByTimeAndUser("2021-04-03", "2021-04-08",null));
    }
}
