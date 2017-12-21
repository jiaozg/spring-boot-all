package com.example.demo.form;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/19.
 */
public class AreaTree {

    private Long id;
    private String name;

    private boolean isParent = true;
    private List<AreaTree> children = new ArrayList<>();

    public AreaTree() {

    }

    public AreaTree(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AreaTree> getChildren() {
        return children;
    }

    public void setChildren(List<AreaTree> children) {
        this.children = children;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }
}
