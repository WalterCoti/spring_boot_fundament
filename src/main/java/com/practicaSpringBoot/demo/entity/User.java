package com.practicaSpringBoot.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User", nullable = false, unique = true)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50, unique = true)
    private String email;
    @Column(length = 50)
    private LocalDate birthday;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference   //Con JsonManageReference no funcionaba el POST ni PUT
    private List<Post> posts = new ArrayList<>();

    public User(){

    }
    public User(String name, String email, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
    public User(Long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", posts=" + posts +
                '}';
    }
}
