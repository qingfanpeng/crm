package com.peng.crm.controller;

import com.peng.crm.pojo.Customer;
import com.peng.crm.pojo.ErrorOrder;
import com.peng.crm.pojo.Production;
import com.peng.crm.pojo.UpdateOrder;
import com.peng.crm.service.CustomerService;
import com.peng.crm.service.ErrorOrderService;
import com.peng.crm.service.ProductionService;
import com.peng.crm.service.UpdateOrderService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * @author qingfan
 * @creat 2021-03-28-16:22
 */
@Controller
public class OrderController {

    @Autowired
    ErrorOrderService errorOrderService;
    @Autowired
    UpdateOrderService updateOrderService;
    @Autowired
    ProductionService productionService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/order/{cid}")
    public String historyWork(@PathVariable("cid") Integer cid, Model model) {
        List<UpdateOrder> updateOrders = updateOrderService.listByCId(cid);
        model.addAttribute("updateOrders", updateOrders);
        model.addAttribute("customer", customerService.find(cid));
        return "historywork";
    }

    @GetMapping("/order/add/{cid}")
    public String addOrder(@PathVariable("cid") Integer cid, Model model) {
        Customer customer = customerService.find(cid);
        List<Production> allproductions = productionService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("allproductions", allproductions);
        return "addorder";
    }

    @PostMapping("/order/save/{cid}")
    public String addOrder(@PathVariable("cid") Integer cid,@ModelAttribute UpdateOrder updateOrder, String contact, String phone, Integer productionId, Model model) {
        Customer customer = customerService.find(cid);
        customer.setContact(contact);
        customer.setPhone(phone);
        customer.setProductionId(productionId);
        customerService.update(customer);
        System.out.println(customer);
        updateOrder.setAddTime(new Date(System.currentTimeMillis()));
        updateOrder.setCustomerId(cid);
        updateOrderService.add(updateOrder);
        return "redirect:/order/"+cid;
    }


    @PostMapping("/order/update/{cid}")
    public String updateOrder(@PathVariable("cid") Integer cid, UpdateOrder updateOrder, String contact, String phone, Integer productionId, Model model) {
        Customer customer = customerService.find(cid);
        customer.setContact(contact);
        customer.setPhone(phone);
        customer.setProductionId(productionId);
        customerService.update(customer);
        updateOrderService.update(updateOrder);
        return "redirect:/order/"+cid;
    }

    @DeleteMapping(value = "/order/delete/{cid}/{id}",produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public void deleteOrder(@PathVariable("cid") Integer cid, @PathVariable("id") Integer id, Model model) {
        updateOrderService.remove(id);
    }
    @RequiresRoles("ADMIN")
    @GetMapping("/order/update/{id}")
    public String updateOrder(@PathVariable("id") Integer id, Model model) {
        UpdateOrder updateOrder = updateOrderService.find(id);
        Customer customer = customerService.find(updateOrder.getCustomerId());
        Production production = productionService.find(customer.getProductionId());
        model.addAttribute("customer", customer);
        model.addAttribute("production", production);
        model.addAttribute("allproductions", productionService.findAll());
        model.addAttribute("updateOrder", updateOrder);
        return "updateorder";
    }
//    public HashMap updateOrder(@PathVariable("id") Integer id, Model model) {
//        UpdateOrder updateOrder = updateOrderService.find(id);
//        System.out.println(updateOrder);
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("updateOrder",updateOrder);
//        model.addAttribute("updateOrder", updateOrder);
//        return hashMap;
//    }

}
