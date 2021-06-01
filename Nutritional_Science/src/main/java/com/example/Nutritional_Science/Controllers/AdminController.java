package com.example.Nutritional_Science.Controllers;

import com.example.Nutritional_Science.Service.AdminFoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    AdminFoodMenuService adminFoodMenuService;


    @GetMapping("/you/admin")
    public String home() {
        adminFoodMenuService.start();
        return "home";
    }

}
