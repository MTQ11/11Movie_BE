package com.example.backendmovie11.controller;

import com.example.backendmovie11.entity.Comment;
import com.example.backendmovie11.request.CommentRequest;
import com.example.backendmovie11.service.CommentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @PostMapping("/add")
    public Comment addComment(@RequestBody CommentRequest commentRequest){
        return commentService.addComment(commentRequest);
    }
    @GetMapping("/{category}")
    public List<Comment> getByIdAndCatergory(@PathVariable String category, @RequestParam Integer id){
        return commentService.getComment(id, category);
    }

}
