package com.practicaSpringBoot.demo.CaseUse;

import com.practicaSpringBoot.demo.entity.User;
import com.practicaSpringBoot.demo.service.UseService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UseService useService;
    public UpdateUser(UseService useService) {
        this.useService = useService;
    }

    public User update(User newUser, Long id) {
        return useService.update(newUser, id);
    }
}
