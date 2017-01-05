package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rolldice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String diceroll(@PathVariable int n, Model model) {
        model.addAttribute("n", n);
        return "number";
    }
}
