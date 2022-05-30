package com.example.controllers;


import com.example.Form;
import com.example.dao.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/allDogs")
public class DogController {
    @Autowired
    private DogService dogService;

    //@Autowired
    //private EmailService emailService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("dog", dogService.index());
        return "allDogs";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        System.out.println("controller " + id);
        model.addAttribute("dog", dogService.show(id));
        System.out.println("controller " + id);
        return "yourDog";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute(value="foo") Form foo, Model model) {
        String gender = foo.getGenderF()!=null ? "female" : (foo.getGenderM()!=null ? "male" : null);
        String age = foo.getYoung()!=null ? "young" : (foo.getOld()!=null ? "old" : null);
        String size = foo.getLarge()!=null ? "large" : (foo.getMiddle()!=null ? "middle" : null);

        if (foo.getGenderF()==foo.getGenderM() && foo.getLarge()==foo.getMiddle() &&
                foo.getOld()==foo.getYoung()) {
            model.addAttribute("dog", dogService.index());
        }
        else {
            if (gender == size)
                model.addAttribute("dog", dogService.getDogFilteredByAge(age));
            else if (age == size)
                model.addAttribute("dog", dogService.getDogFilteredByGender(gender));
            else if (age == gender)
                model.addAttribute("dog", dogService.getDogFilteredBySize(size));
            else if (age == null && gender!=null && size != null)
                model.addAttribute("dog", dogService.getDogFilteredBySizeAndGender(size,gender));
            else if (size == null && age!=null && gender != null)
                model.addAttribute("dog", dogService.getDogFilteredByAgeAndGender(age,gender));
            else if (gender == null && size!=null && age != null)
                model.addAttribute("dog", dogService.getDogFilteredByAgeAndSize(age,size));
            else
                model.addAttribute("dog", dogService.getDogFilteredByAgeAndSizeAndGender(age,size,gender));
        }
        return "allDogs";
        }

    }


