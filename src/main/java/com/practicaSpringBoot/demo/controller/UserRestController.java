package com.practicaSpringBoot.demo.controller;

import com.practicaSpringBoot.demo.CaseUse.GetUser;
import com.practicaSpringBoot.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //CREAR
    //OBTENER
    //DELETE
    //UPDATE
    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }
    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }
}
