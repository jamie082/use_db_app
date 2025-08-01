package com.example.text_app.controller;

import com.example.text_app.model.TextMessage;
import com.example.text_app.repository.TextMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired // Automatically injects an instance of the repository
    private TextMessageRepository repository;

    // Handles GET requests to the root URL ("/")
    @GetMapping("/")
    public String index(Model model) {
        // Add a new TextMessage object to the model to bind to the form
        model.addAttribute("newMessage", new TextMessage());
        // Add all existing messages from the DB to the model
        model.addAttribute("messages", repository.findAll());
        return "index"; // Returns the "index.html" template
    }

    // Handles POST requests to the "/save" URL
    @PostMapping("/save")
    public String saveMessage(TextMessage message) {
        repository.save(message); // Saves the new message to the H2 database
        return "redirect:/"; // Redirects back to the home page
    }
}