package com.example.controllers;
import com.example.Dog;
import com.example.Form;
import com.example.Role;
import com.example.User;
import com.example.dao.DogService;
import com.example.dao.EmailService;
import com.example.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
//@PreAuthorize("hasAuthority('USER')")
public class MyController {
    @Autowired
    private DogService dogService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/home")
    public String goHome() {
        return "home";
    }

    /*
    @GetMapping("/myaccount")
    public String currentUserName(Principal principal, Map<String, Object> model) {
        User user = userService.get(principal.getName());
        model.put("message", principal.getName());
        return "account";
    }
     */

    @GetMapping("/myaccount")
    public String userPageWithDog(Principal principal,Model model) {

        User user = userService.get(principal.getName());
        if (user.getRoles().contains(Role.ADMIN))
            return "redirect:/admin";
        model.addAttribute("user", user);
        return "account";
    }

    @PostMapping("/myaccount")
    public String withDog(@ModelAttribute("dog") Dog dog, Principal principal) {
        User user = userService.get(principal.getName());
        System.out.println(dog.toString());
        dogService.update(dog.getName(),user);
//        emailService.sendEmail("*какие-то данные*", user.getEmail());
        return "redirect:/myaccount";
    }


}