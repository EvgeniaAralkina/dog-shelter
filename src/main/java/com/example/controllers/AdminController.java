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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private DogService dogService;
    //@Value("${upload.path}")
    //private String uploadPath;


    @GetMapping("/admin")
    public String adminPage(Principal principal, Model model) {

        User user = userService.get(principal.getName());
        model.addAttribute("user", user);
        return "admin";
    }

    @PostMapping("/newAdmin")
    public String addAdmin(@ModelAttribute(value = "foo") Form foo) {
        System.out.println(foo.getUsername());
        userService.updateRole(foo.getUsername(), Role.ADMIN);
        return "ok";
    }

    @PostMapping("/delAdmin")
    public String delAdmin(@ModelAttribute("form") Form form) {
        userService.updateRole(form.getUsername(), Role.USER);
        return "redirect:/ok";
    }

    @PostMapping("/addDog")
    public String newDog(@ModelAttribute("foo") Form foo,
                         @RequestParam("file") MultipartFile file) throws IOException {
        String gender = foo.getGenderF()!=null ? "female" : (foo.getGenderM()!=null ? "male" : null);
        String size = foo.getLarge()!=null ? "large" : (foo.getMiddle()!=null ? "middle" : null);

        Dog dog = new Dog();
        dog.setAge(foo.getAge());
        dog.setDescription(foo.getDescription());
        dog.setGender(gender);
        dog.setName(foo.getUsername());
        dog.setSize(size);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File("resources/static/images");
            System.out.println(1);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + file.getOriginalFilename();
            System.out.println(resultFilename);
            file.transferTo(new File("C:/Users/Евгения/IdeaProjects/pr15 — копия/src/main/resources/static/images/" + resultFilename));

            dog.setPhoto(resultFilename);
        }

        dogService.save(dog);
        return "redirect:/ok";
    }

}
