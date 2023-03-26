package com.practicaSpringBoot.demo.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MybeanDependencyImplement implements MybeanDependency{

    Log LOGGER  = LogFactory.getLog(MybeanDependencyImplement.class);
    private MyOperation myOp;

    public MybeanDependencyImplement(MyOperation myOP_){
        this.myOp = myOP_;
    }

    @Override
    public void printmyDependency() {
        LOGGER.info("Hemos ingresado al metodo printmyDependency");

        int numero = 4;
        LOGGER.debug("el numero enviado como parametro a la dependencia operation es : " + numero);
        System.out.println(myOp.sum(numero));
        System.out.println("Hi, desde la implemencacion de un un bean conn dependencia");

    }
}
