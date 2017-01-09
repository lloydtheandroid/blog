package com.codeup.controllers;

import com.codeup.dao.DaoFactory;
import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class PostController {

    @GetMapping
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
        return "redirect:/blog";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post = DaoFactory.getPostsDao().find(id);
        model.addAttribute("post", post);
        return "blog/show";
    }

    @GetMapping("/blog/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id) {
        Post post = DaoFactory.getPostsDao().find(id);
        model.addAttribute("post", post);
        return "blog/edit";
    }

    @PostMapping("/posts/{{id}/edit")
    public String update(@ModelAttribute Post editedPost, @PathVariable long id) {
        Post exisingPost = DaoFactory.getPostsDao().find(id);
        String newTitle = editedPost.getTitle();
        String newBody = editedPost.getBody();
        exisingPost.setTitle(newTitle);
        exisingPost.setBody(newBody);
        DaoFactory.getPostsDao().update(exisingPost);
        return "redirect:/posts" + exisingPost.getId();
    }
}
