package com.practicaSpringBoot.demo.CaseUse;

import com.practicaSpringBoot.demo.entity.User;
import com.practicaSpringBoot.demo.service.UseService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UseService useService;

    public CreateUser(UseService useService) {
        this.useService = useService;
    }

    public User save(User newUser) {
        return useService.save(newUser);
    }
}
