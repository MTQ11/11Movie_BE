package com.example.backendmovie11.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Entity
@Data
public class Emoji {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "type", nullable = false)
    private int type;

    @JsonIgnore
    @ManyToOne
    private Comment commentId;
    @ManyToOne
    @JoinColumn(name = "emoji_user_id", referencedColumnName = "id", nullable = false)
    private User userByEmojiUserId;

}
