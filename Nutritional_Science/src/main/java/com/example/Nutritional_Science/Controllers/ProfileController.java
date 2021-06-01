package com.example.Nutritional_Science.Controllers;

import com.example.Nutritional_Science.Entity.UserParameters;
import com.example.Nutritional_Science.Service.FoodMenuService;
import com.example.Nutritional_Science.Service.UserParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    UserParametersService userParametersService;

    @Autowired
    FoodMenuService foodMenuService;

    @GetMapping("/profile")
    public String profile(Model model){
        List<String> parametersList = userParametersService.getParameters(SecurityContextHolder.getContext().getAuthentication().getName());
        if(parametersList!=null) {
            model.addAttribute("weight", parametersList.get(0));
            model.addAttribute("height", parametersList.get(1));
            model.addAttribute("age", parametersList.get(2));
            if(foodMenuService.getCalories() >= 0) {
                model.addAttribute("calories", foodMenuService.getCalories());
            }


            if(parametersList.get(3).equals("false"))
                model.addAttribute("isMan", "Женский");
            else
                model.addAttribute("isMan", "Мужской");
            switch (parametersList.get(4)){
                case "1.2":
                    model.addAttribute("activity","Сидячий образ жизни");
                    break;
                case "1.375":
                    model.addAttribute("activity","Умеренная активность (легкие физические нагрузки либо занятия 1-3 раз в неделю)");
                    break;
                case "1.55":
                    model.addAttribute("activity","Средняя активность (занятия 3-5 раз в неделю)");
                    break;
                case "1.725":
                    model.addAttribute("activity","Активный человек (интенсивные нагрузки, занятия 6-7 раз в неделю)");
                    break;
                case "1.9":
                    model.addAttribute("activity","Спортсмен или человек, выполняющий сходные нагрузки (6-7 раз в неделю)");
                    break;
            }

            return "profile";
        }else {
            return "settingProfile";
        }
    }

    @GetMapping("/settingProfile")
    public String settingProfile(Model model){
        List<String> parametersList = userParametersService.getParameters(SecurityContextHolder.getContext().getAuthentication().getName());

        if(parametersList!=null) {
            model.addAttribute("weight", parametersList.get(0));
            model.addAttribute("height", parametersList.get(1));
            model.addAttribute("age", parametersList.get(2));
            if(parametersList.get(3).equals("false"))
                model.addAttribute("chW", "checked");
            else
                model.addAttribute("chM", "checked");
            switch (parametersList.get(4)){
                case "1.2":
                    model.addAttribute("ac1",true);
                    break;
                case "1.375":
                    model.addAttribute("ac2",true);
                    break;
                case "1.55":
                    model.addAttribute("ac3",true);
                    break;
                case "1.725":
                    model.addAttribute("ac4", true);
                    break;
                case "1.9":
                    model.addAttribute("ac5",true);
                    break;
            }

        }

        return "settingProfile";
    }

    @PostMapping("/updateDataAboutUser")
    public String updateDataAboutUser(@ModelAttribute UserParameters userParameters,
                                      @PathParam("isMan") String isMan){
        if(isMan.equals("true"))
            userParameters.setMan(true);
        userParametersService.updateDataAboutUser(userParameters,SecurityContextHolder.getContext().getAuthentication().getName());
        return "redirect:/profile";
    }

}
