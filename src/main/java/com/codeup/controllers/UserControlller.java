package com.codeup.controllers;

import com.codeup.dao.DaoFactory;
import com.codeup.models.Post;
import com.codeup.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserControlller {

    @GetMapping
    public String viewProfile(Model model, @PathVariable long id) {
        User user = DaoFactory.getUsersDao().find(id);
        model.addAttribute("user", user);
        return "/user/index";
    }


    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("create", new User());
        return "/user/create";
    }

    @GetMapping("/edit")
    public String editProfile() {
        return "/user/edit";
    }

    @PostMapping("/post")
    public String postSubmit(@ModelAttribute Post post) {
        DaoFactory.getPostsDao().insert(post);
        return "redirect:/blog";
    }
}
