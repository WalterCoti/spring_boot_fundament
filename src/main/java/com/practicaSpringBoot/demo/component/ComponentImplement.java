package com.practicaSpringBoot.demo.component;

public class ComponentImplement implements ComponentDependency{
    @Override
    public void saludar(){
        System.out.println("Hola mundo desde el componente");
    }

}
