package com.example.Nutritional_Science.Controllers;


import com.example.Nutritional_Science.Entity.UserParameters;
import com.example.Nutritional_Science.Service.UserParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.websocket.server.PathParam;

@Controller
public class HomeController {

    @Autowired
    UserParametersService userParametersService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/registration")
    public String reg(){
        return "registration";
    }

    @GetMapping("/calculation")
    public String calc(@ModelAttribute UserParameters userParameters, @PathParam("isMan") String isMan, Model model){
//        System.out.println(isMan);
        if(userParameters!=null && isMan!=null){
            if(isMan.equals("true"))
                userParameters.setMan(true);
            model.addAttribute("weight",userParameters.getWeight());
            model.addAttribute("height",userParameters.getHeight());
            model.addAttribute("age",userParameters.getAge());

            if(!userParameters.isMan())
                model.addAttribute("chW", true);
            else
                model.addAttribute("chM", true);
            String a = String.valueOf(userParameters.getActivity());
            switch (a){
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
                    model.addAttribute("ac4",true);
                    break;
                case "1.9":
                    model.addAttribute("ac5",true);
                    break;
            }
        }

        if(userParametersService.needCallories(userParameters) == -2){
            model.addAttribute("result", "");
        }
        else if(userParametersService.needCallories(userParameters) == -1){
            model.addAttribute("result", "Введите корректные данные!");
        }
        else{
            model.addAttribute("result", "Необходимое количество каллорий: " + userParametersService.needCallories(userParameters));
        }
        return "calculation";
    }


}
