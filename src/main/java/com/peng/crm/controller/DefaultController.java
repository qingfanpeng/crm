package com.peng.crm.controller;

import com.peng.crm.service.IndustryService;
import com.peng.crm.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qingfan
 * @creat 2021-04-02-19:52
 */
@Controller
public class DefaultController {

    @Autowired
    ProvinceService provinceService;
    @Autowired
    IndustryService industryService;

    @GetMapping({"/","/list"})
    public String listAllByProvince(Model model) {
        model.addAttribute("provinces",provinceService.findAll());
        model.addAttribute("industries",industryService.findAll());
        return "default";
    }


}
