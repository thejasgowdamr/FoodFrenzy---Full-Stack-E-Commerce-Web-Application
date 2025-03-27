package com.food_frenzy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.food_frenzy.entity.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.food_frenzy.serviceimpl.UserServices;

@Controller
public class RegisterController {
    @Autowired
    private UserServices userServices;

    // Serve the registration page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("userRegistration", new User());
        return "register"; // Thymeleaf template named Register.html
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userServices.userExists(user.getUemail())) {
            model.addAttribute("error", "Email already exists!");
            return "register"; // Go back to registration page if email exists
        }

        userServices.addUser(user); // Save the user
        return "redirect:/login"; // Redirect to login page after successful registration
    }
}