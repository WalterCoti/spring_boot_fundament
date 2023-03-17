package com.practicaSpringBoot.demo.configuration;

import com.practicaSpringBoot.demo.bean.MyBeanwithProperties;
import com.practicaSpringBoot.demo.bean.MybeanPropertiesImplement;
import com.practicaSpringBoot.demo.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class Generalconfiguaration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanwithProperties function(){
        return  new MybeanPropertiesImplement(name, apellido);

    }

}
