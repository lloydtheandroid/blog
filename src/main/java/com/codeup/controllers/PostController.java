package com.codeup.controllers;

import com.codeup.dao.DaoFactory;
import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/blog")
public class PostController {

    @GetMapping("/index")
    public String index(Model model) {
        List<Post> post = DaoFactory.getPostsDao().all();
        model.addAttribute("posts", post);
        return "/blog/index";
    }

    @GetMapping("/post")
    public String postForm(Model model) {
        model.addAttribute("post", new Post());
        return "/blog/post";
    }

    @PostMapping("/post")
    public String postSubmit(@ModelAttribute Post post) {
        DaoFactory.getPostsDao().insert(post);
        return "redirect:/blog/index";
    }
//    @GetMapping("/post/{id}")
//
//    return "blog/post/{id}"

}
