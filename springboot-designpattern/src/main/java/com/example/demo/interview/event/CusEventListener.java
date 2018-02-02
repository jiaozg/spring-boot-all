package com.example.demo.interview.event;

import java.util.EventListener;

/**
 * Created by jiaozhiguang on 2018/1/23.
 *
 事件监听器，实现java.util.EventListener接口。定义回调方法，将你想要做的事 
 放到这个方法下,因为事件源发生相应的事件时会调用这个方法。
 */
public class CusEventListener implements EventListener {

    public void fireCusEvent(CusEvent event) {
        EventSourceObject eObject = (EventSourceObject)event.getSource();
        System.out.println("My name has been changed");
        System.out.println("I got a new name \"" + eObject.getName()+ "\"");
    }

}
