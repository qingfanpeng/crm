package com.peng.crm.pojo;

import com.sun.xml.internal.stream.events.NamedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author qingfan
 * @creat 2021-03-26-22:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "updateorder")
public class UpdateOrder implements Serializable {
    private static final long serialVersionUID = -5002624321468309591L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "handler_method")
    private HandlerMethod handlerMethod;
    private Integer customerId;
    private String periodical;
    private String thesis;
    private String conference;
    private String patent;
    private String law;
    private String standard;
    private String book;
    private String video;
    private String other;
    private String fulltextStatus;
    private String notes;
    @Column(name = "status")
    private Status status;
    @Column(name = "add_time")
    private Date addTime;
    private String workContent;

    private String errorDesc;
}
