package com.example.demo.interview.event;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiaozhiguang on 2018/1/23.
 *
 * 事件源。事件发生的地方，由于事件源的某项属性或状态发生了改变(比如BUTTON被单击、
 * TEXTBOX的值发生改变等等)导致某项事件发生。换句话说就是生成了相应的事件对象。
 * 因为事件监听器要注册在事件源上,所以事件源类中应该要有盛装监听器的容器(List,Set等等)。
 */
public class EventSourceObject {

    private String name;

    private Set<CusEventListener> listeners;

    public EventSourceObject() {
        this.listeners = new HashSet<>();
        this.name = "defaultName";
    }

    public void addLisners(CusEventListener listener) {
        this.listeners.add(listener);
    }

    public void notifies() {
        for (CusEventListener cel : this.listeners) {
            cel.fireCusEvent(new CusEvent(this));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!this.name.equals(name)) {
            this.name = name;
            notifies();
        }
    }

}
