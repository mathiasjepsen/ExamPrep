/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c1.examprep_rest_api;

import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public class JSONEvent {
    
    private String event;
    private String remark;
    private Date date;

    public JSONEvent(Event e) {
        this.event = e.getEvent();
        this.remark = e.getRemark();
        this.date = e.getDate();
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
