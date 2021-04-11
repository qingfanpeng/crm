package com.peng.crm.pojo;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author qingfan
 * @creat 2021-03-26-22:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "errororder")
public class ErrorOrder implements Serializable {
    private static final long serialVersionUID = -1916918406462020055L;
    private Integer id;
    @Column(name = "handler_method")
    private HandlerMethod handlerMethod;
    private Integer customerId;
    private String errorDesc;
    private String notes;
    @Column(name = "status")
    private Status status;
    @Column(name = "add_time")
    private Date addTime;
    private String workContent;

    public ErrorOrder(HandlerMethod handlerMethod, Integer customerId, String errorDesc, String notes, Status status, String workContent) {
        this.handlerMethod = handlerMethod;
        this.customerId = customerId;
        this.errorDesc = errorDesc;
        this.notes = notes;
        this.status = status;
        this.workContent = workContent;
    }
}
