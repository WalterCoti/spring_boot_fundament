package com.practicaSpringBoot.demo.configuration;

import com.practicaSpringBoot.demo.CaseUse.GetUser;
import com.practicaSpringBoot.demo.CaseUse.GetUserImplement;
import com.practicaSpringBoot.demo.service.UseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UseService useService){
        return new GetUserImplement(useService);
    }
}
