package com.practicaSpringBoot.demo.configuration;

import com.practicaSpringBoot.demo.bean.MyBeanwithProperties;
import com.practicaSpringBoot.demo.bean.MybeanPropertiesImplement;
import com.practicaSpringBoot.demo.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:conection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class Generalconfiguaration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String Driver;

    @Value("${username}")
    private String Username;

    @Value("${password}")
    private String Password;

    @Bean
    public MyBeanwithProperties function(){
        return  new MybeanPropertiesImplement(name, apellido);

    }
//configuracion datasource a nivel de clase
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(Driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(Username);
        dataSourceBuilder.password(Password);

        return dataSourceBuilder.build();
    }

}
