package com.practicaSpringBoot.demo.controller;

import com.practicaSpringBoot.demo.CaseUse.CreateUser;
import com.practicaSpringBoot.demo.CaseUse.DeleteUser;
import com.practicaSpringBoot.demo.CaseUse.GetUser;
import com.practicaSpringBoot.demo.CaseUse.UpdateUser;
import com.practicaSpringBoot.demo.entity.User;
import com.practicaSpringBoot.demo.service.UseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //CREAR
    //OBTENER
    //DELETE
    //UPDATE
    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser){
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }
    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }
    @GetMapping("/lista")
    public Page<User> getAlls(@PageableDefault(size = 10, page = 0) Pageable pageable){
        Page<User> list = getUser.findAll();
        return list;
    }


    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.OK);

    }

}
