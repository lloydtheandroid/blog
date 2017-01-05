package com.codeup.controllers;

import com.codeup.dao.DaoFactory;
import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    @GetMapping("/postIndex")
    public String index(Model model) {
        List<Post> post = DaoFactory.getPostsDao().all;
        model.addAttribute("posts", post);
        return "postindex";
    }

    @GetMapping("/post")
    public String postForm(Model model) {
        model.addAttribute("post", new Post());
        return "post";
    }

    @PostMapping("/post")
    public String postSubmit(@ModelAttribute Post post) {
        DaoFactory.getPostsDao().save(post);
        return "redirect:/postindex";
    }
}
