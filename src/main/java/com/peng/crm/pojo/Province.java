package com.peng.crm.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author qingfan
 * @creat 2021-03-26-22:39
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "province")
public class Province implements Serializable {
    private static final long serialVersionUID = -1248760043425937464L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
}
