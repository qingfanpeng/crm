package com.peng.crm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author qingfan
 * @creat 2021-03-26-22:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = -5187541568755033061L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private Integer provinceId;
    private String contact;
    private String phone;
    private Integer userId;
    private Integer industryId;
    private Integer productionId;
}
