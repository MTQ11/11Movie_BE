package com.example.backendmovie11.request;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CommentRequest {
    private String content;
    private int movieId;
    private String category;
}
