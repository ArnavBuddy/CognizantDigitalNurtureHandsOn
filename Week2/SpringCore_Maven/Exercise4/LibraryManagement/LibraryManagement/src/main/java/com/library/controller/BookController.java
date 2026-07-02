package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Simple Spring WebMVC controller confirming that the WebMVC
 * dependency is correctly resolved on the classpath.
 */
@Controller
public class BookController {

    @GetMapping("/books")
    @ResponseBody
    public String listBooks() {
        return "Library Management - Book listing endpoint is active.";
    }
}
