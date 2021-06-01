package com.example.Nutritional_Science.Controllers;

import com.example.Nutritional_Science.Entity.User;
import com.example.Nutritional_Science.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registrationAction")
    public String addUser(@ModelAttribute User user){
        return userService.addUser(user);
    }

    @GetMapping("/errorRegistration")
    public String errorUser(Model model){
        model.addAttribute("UserAlreadyExist","Пользователь с таким логином уже существует");
        return "registration";
    }

    @GetMapping("/wrongData")
    public String errorData( Model model){
        model.addAttribute("UserAlreadyExist", "Введены некорректные данные");
        return "registration";
    }

    @GetMapping("/login")
    public String ThrowErrorMessageByLogin(@RequestParam(value = "error",required = false) String error,Model model){
        if(error!=null)
        model.addAttribute("LoginOrPasswordUncorrected","Неверный логин или пароль");
        return "login";
    }

    @GetMapping("/userHome")
    public String userHome(){
        return "userHome";
    }

}
