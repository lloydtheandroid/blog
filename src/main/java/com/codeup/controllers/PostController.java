package com.codeup.controllers;

import com.codeup.dao.DaoFactory;
import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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

    @GetMapping("/create")
    public String postForm(Model model) {
        model.addAttribute("post", new Post());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String postSubmit(@Valid Post post, Errors errors, Model model) {

        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            model.addAttribute("post", post);
            return "blog/create";
        }
        DaoFactory.getPostsDao().insert(post);
        return "redirect:/blog";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post = DaoFactory.getPostsDao().find(id);
        model.addAttribute("post", post);
        return "blog/show";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id) {
        Post post = DaoFactory.getPostsDao().find(id);
        model.addAttribute("post", post);
        return "blog/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@Valid Post editedPost, Errors errors, Model model) {

        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            model.addAttribute("post", editedPost);
            return "blog/edit";
        }

        Post existingPost = DaoFactory.getPostsDao().find(editedPost.getId());
        String newTitle = editedPost.getTitle();
        String newBody = editedPost.getBody();
        existingPost.setTitle(newTitle);
        existingPost.setBody(newBody);
        DaoFactory.getPostsDao().update(existingPost);

        return "redirect:/blog";
    }
}
