package com.example.backendmovie11.service;

import com.example.backendmovie11.entity.Comment;
import com.example.backendmovie11.repository.CommentRepository;
import com.example.backendmovie11.repository.UserRepository;
import com.example.backendmovie11.request.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    public Comment addComment(CommentRequest commentRequest){
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setMovieId(commentRequest.getMovieId());
        comment.setMovieCategory(commentRequest.getCategory());
        long currentTimeMillis = System.currentTimeMillis();

        // Tạo Timestamp từ thời gian hiện tại
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a dd/M/yyyy");
        comment.setDateCreated(sdf.format(timestamp));
        comment.setUserByUserId(userRepository.findById(1).get());
        commentRepository.save(comment);
        return comment;
    }

    public List<Comment> getComment(Integer id, String category){
        return commentRepository.findCommentsByMovieIdAndMovieCategory(id, category);
    }
}
