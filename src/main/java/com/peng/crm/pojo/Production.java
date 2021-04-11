package com.peng.crm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author qingfan
 * @creat 2021-03-26-23:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "production")
public class Production {
//    STANDARD_3_7, CMA_3_7, MEDICAL_3_7, STANDARD_3_8, STANDARD_4, VIDEO_4, CHINA_STANDARD, INDUSTRY_STANDARD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
