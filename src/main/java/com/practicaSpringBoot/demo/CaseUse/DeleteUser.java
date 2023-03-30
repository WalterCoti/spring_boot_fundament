package com.practicaSpringBoot.demo.CaseUse;

import com.practicaSpringBoot.demo.service.UseService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UseService useService;

    public DeleteUser(UseService useService) {
        this.useService = useService;
    }

    public void remove(Long id) {
        useService.remove(id);
    }
}
