package com.skoti.learning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@RequestMapping("/userLogin")
    public String userValidation() {
        return "User: Successfully logged in!";

    }

    @RequestMapping("/adminLogin")
    public String adminValidation() {
        return "Admin: Successfully logged in!";

    }
}
