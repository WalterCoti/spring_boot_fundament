package com.practicaSpringBoot.demo.CaseUse;

import com.practicaSpringBoot.demo.entity.User;
import com.practicaSpringBoot.demo.service.UseService;

import java.util.List;

public class GetUserImplement implements GetUser {
    private UseService userService;

    public GetUserImplement(UseService userService) {
        this.userService = userService;
    }
    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
