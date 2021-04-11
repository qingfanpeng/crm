package com.peng.crm.controller;

import com.peng.crm.pojo.Customer;
import com.peng.crm.pojo.Industry;
import com.peng.crm.pojo.Province;
import com.peng.crm.service.CustomerService;
import com.peng.crm.service.IndustryService;
import com.peng.crm.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;

/**
 * @author qingfan
 * @creat 2021-03-28-13:26
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    IndustryService industryService;

    @GetMapping("/list/{keyword}")
    public String listByName(@PathVariable("keyword") String keyword, Model model) {
        List<Customer> customers = customerService.listByNameLike(keyword);
        model.addAttribute("customers", customers);
        return "clist";
    }

    @GetMapping("/province/{id}")
    public String listByProvince(@PathVariable("id") Integer id,Model model) {
        List<Customer> customers = customerService.listByProvinceId(id);
        model.addAttribute("customers", customers);
        return "clist";
    }

    @GetMapping("/industry/{id}")
    public String listByIndustry(@PathVariable("id") Integer id, Model model) {
        List<Customer> customers = customerService.listByIndustryId(id);
        model.addAttribute("customers", customers);
        return "clist";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(Customer customer) {
        if (customer.getId() == null) {
            customerService.add(customer);
        }
        customerService.update(customer);
        return "addc";
    }

    @GetMapping("/addc")
    public String addCustomer(Integer id, Model model) {
        if (id != null){
            Customer customer = customerService.find(id);
            Province province = provinceService.find(customer.getProvinceId());
            Industry industry = industryService.find(customer.getIndustryId());
            HashMap<String, Object> map = new HashMap<>();
            map.put("customer",customer);
            map.put("province",province);
            map.put("industry",industry);
            model.addAllAttributes(map);
        }
        return "addc";
    }

    @PutMapping("/updateCustomer")
    public void updateCustomer(Customer customer) {
        customerService.update(customer);
    }
}
