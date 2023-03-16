package com.practicaSpringBoot.demo.bean;

public class MybeanDependencyImplement implements MybeanDependency{

    private MyOperation myOp;

    public MybeanDependencyImplement(MyOperation myOP_){
        this.myOp = myOP_;
    }

    @Override
    public void printmyDependency() {
        int numero = 4;
        System.out.println(myOp.sum(numero));
        System.out.println("Hi, desde la implemencacion de un un bean conn dependencia");
    }
}
