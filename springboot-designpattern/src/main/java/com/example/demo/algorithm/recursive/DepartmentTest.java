package com.example.demo.algorithm.recursive;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/13.
 */
public class DepartmentTest {

    public static void main(String[] args) {

        List<Department> plist = new ArrayList<>();
        Department root1 = new Department(1, "ceshi");
        Department root1child1 = new Department(11, "ceshi11");
        Department root1child2 = new Department(12, "ceshi12");
        Department root1child3 = new Department(13, "ceshi13");
        root1.getChild().add(root1child1);
        root1.getChild().add(root1child2);
        root1.getChild().add(root1child3);

        Department root2 = new Department(2, "kaifa");
        Department root2child1 = new Department(21, "kaifa21");
        Department root2child2 = new Department(32, "kaifa22");
        Department root2child3 = new Department(43, "kaifa23");
        root2.getChild().add(root2child1);
        root2.getChild().add(root2child2);
        root2.getChild().add(root2child3);

        Department root2child1child1 = new Department(211, "kaifa211");
        root2child1.getChild().add(root2child1child1);

        List<Department> roots = new ArrayList<>();
        roots.add(root1);
        roots.add(root2);

        for (Department department : roots) {
            show(department, 0);
        }


    }

    public static void show(Department department, int i) {
        for (int j = 0; j < i*4; j++) {
            System.out.print(" ");
        }
        System.out.println(department.getName() +"[" + department.getId() +"]");
        i++;
        List<Department> list = department.getChild();
        for (Department dept : list) {
            show(dept, i);
        }


    }

}
