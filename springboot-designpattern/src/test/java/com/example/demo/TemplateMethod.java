package com.example.demo;

/**
 * Created by jiaozhiguang on 2017/9/21.
 */
public class TemplateMethod {

    public static void main(String[] args) {
        HouseAbstract house = new SeaHouse();
        house.construct();
    }

}

abstract class HouseAbstract {
    protected abstract void constructFoundations();
    protected abstract void constructWall();

    // template method
    public final void construct() {
        constructFoundations();
        constructWall();
    }
}

class EcologicalHouse extends HouseAbstract {

    @Override
    protected void constructFoundations() {
        System.out.println("Making foundations with wood");
    }

    @Override
    protected void constructWall() {
        System.out.println("Making wall with wood");
    }

}

class SeaHouse extends HouseAbstract {

    @Override
    protected void constructFoundations() {
        System.out.println("Constructing very strong foundations");
    }

    @Override
    protected void constructWall() {
        System.out.println("Constructing very strong wall");
    }


}
