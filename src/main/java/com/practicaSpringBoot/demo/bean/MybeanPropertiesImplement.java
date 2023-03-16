package com.practicaSpringBoot.demo.bean;

public class MybeanPropertiesImplement implements MyBeanwithProperties{
    private String nombre;
    private String apellido;

    public MybeanPropertiesImplement(String nombre_, String apellido_){
        this.nombre = nombre_;
        this.apellido = apellido_;
    }
    @Override
    public String function(){
        return nombre + " - " + apellido;
    }
}
