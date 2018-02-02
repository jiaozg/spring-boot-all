package com.example.demo.interview.event;

/**
 * Created by jiaozhiguang on 2018/1/23.
 */
public class EventTest {

    public static void main(String[] args) {
        EventSourceObject object = new EventSourceObject();
        object.addLisners(new CusEventListener());
        object.setName("eric");
    }

}
