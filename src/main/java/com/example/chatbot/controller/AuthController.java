package com.example.chatbot.controller;

import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // ✅ Show index page at root
    @GetMapping("/")
    public String index() {
        return "index"; // thymeleaf template: src/main/resources/templates/index.html
    }



    // ✅ Show register page
    @GetMapping("/register")
    public String registerPage() {
        return "register"; // thymeleaf template register.html
    }

   


@GetMapping("/login")
public String loginPage(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
    // error from Spring Security
    if (error != null) {
        model.addAttribute("error", "Invalid username or password");
    }

    if (logout != null) {
        model.addAttribute("message", "You have been logged out successfully");
    }

    // flash message from registration (automatically added to model)
    // no need to check "registered" param
    return "login"; 
}

@PostMapping("/register")
public String register(@RequestParam String username,
                       @RequestParam String password,
                       RedirectAttributes redirectAttributes) {
    boolean success = userService.register(username, password);
    if (success) {
        redirectAttributes.addFlashAttribute("message", "Successfully registered! Please login.");
        return "redirect:/login";
    } else {
        redirectAttributes.addFlashAttribute("error", "Username already taken");
        return "redirect:/register";
    }
}

}
