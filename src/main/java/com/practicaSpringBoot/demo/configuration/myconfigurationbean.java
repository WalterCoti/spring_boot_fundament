package com.practicaSpringBoot.demo.configuration;

import com.practicaSpringBoot.demo.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myconfigurationbean {
    @Bean
    public newbean beanOperation(){
        return new mybeanimplement2();
    }

    @Bean
    public MyOperation My_op_Operation(){
        return new MyOperationImplement();
    }

    @Bean
    public MybeanDependency beanOpWhithDependency(MyOperation myOperation_)
    {
        return new MybeanDependencyImplement(myOperation_);
    }

}
