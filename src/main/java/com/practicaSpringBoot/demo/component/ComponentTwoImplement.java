package com.practicaSpringBoot.demo.component;

public class ComponentTwoImplement implements  ComponentDependency{

    @Override
    public void saludar() {
        System.out.printf("a ver si llega");
    }
}
