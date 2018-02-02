package com.example.demo.interview.event;

import java.util.EventObject;

/**
 * Created by jiaozhiguang on 2018/1/23.
 *
 * 事件类,用于封装事件源及一些与事件相关的参数. 
 */
public class CusEvent extends EventObject {

    private Object source;

    public CusEvent(Object source) {
        super(source);
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
