package com.example.backendmovie11.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "content", nullable = false, length = 200)
    private String content;
    @Basic
    @Column(name = "movie_id", nullable = false, length = 45)
    private int movieId;
    @Basic
    @Column(name = "movie_category", nullable = false, length = 45)
    private String movieCategory;
    @Basic
    @Column(name = "date_created", nullable = false)
    private String dateCreated;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;
    @OneToMany(mappedBy = "commentId")
    private Collection<Emoji> emojiId;

}
