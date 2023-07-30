package com.example.backendmovie11.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Entity
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic
    @JsonIgnore
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @JsonIgnore
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;
    @Basic
    @Column(name = "avatar", nullable = true, length = 100)
    private String avatar;

    @JsonIgnore
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Comment> commentsById;

    @OneToMany(mappedBy = "userByEmojiUserId")
    private Collection<Emoji> emojisById;


}
