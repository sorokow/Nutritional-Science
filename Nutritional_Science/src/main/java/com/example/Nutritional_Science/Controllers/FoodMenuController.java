package com.example.Nutritional_Science.Controllers;

import com.example.Nutritional_Science.Service.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodMenuController {

    @Autowired
    FoodMenuService foodMenuService;

    @GetMapping("/week")
    public String menuWeek(Model model){
        if(foodMenuService.getCoefficient() > 0.0) {
            model.addAttribute("mondeyList", foodMenuService.getDay(0));
            model.addAttribute("tuesdayList", foodMenuService.getDay(1));
            model.addAttribute("wednesdayList", foodMenuService.getDay(2));
            model.addAttribute("thursdayList", foodMenuService.getDay(3));
            model.addAttribute("fridayList", foodMenuService.getDay(4));
            model.addAttribute("saturdayList", foodMenuService.getDay(5));
            model.addAttribute("sundayList", foodMenuService.getDay(6));
            return "weekMenu";
        }
        else{
            return "settingProfile";
        }
    }

}
