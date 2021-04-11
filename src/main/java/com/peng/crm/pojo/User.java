package com.peng.crm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

/**
 * @author qingfan
 * @creat 2021-03-26-22:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "User")
@Table(name="user")
public class User {
//    需要配置@Id 通用mapper和xml方式才能一起用，不然selectByPrimaryKey(id)等通用mapper方法返回为空
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String Name;
    private String password;
//    引用类型数据需要指定表中对应列，不然selectByPrimaryKey(id)等返回此属性为空
    @Column(name = "permission")
    private Permission permission;
}
