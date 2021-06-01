package com.example.Nutritional_Science.Service;

import com.example.Nutritional_Science.Entity.FoodMenu;
import com.example.Nutritional_Science.Entity.User;
import com.example.Nutritional_Science.Repository.FoodMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodMenuService {

    @Autowired
    FoodMenuRepository foodMenuRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserParametersService userParametersService;


    public ArrayList getDay(int numberDayWeek){
        double coefficient = getCoefficient();
        ArrayList list = new ArrayList();
        for(FoodMenu foodMenu : foodMenuRepository.findAll()){
            if(foodMenu.getNumberDayWeek() == numberDayWeek){
                foodMenu.setQuantity((int)(foodMenu.getQuantity()*coefficient));
                foodMenu.setCalories((int)(foodMenu.getCalories()*coefficient));
                list.add(foodMenu);
            }
        }
        return list;
    }

    public double getCoefficient(){
        try {
            User currentUser = userService.findUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
            return userParametersService.findParameterByUserId(currentUser.getUserParameters().getId()).get().getCoefficient();
        }
        catch (NullPointerException npe){
            return -1.0;
        }
    }

    public int getCalories() {
        if(getCoefficient() > 0.0){
            return (int)(2500 * getCoefficient());
        }
        return -1;
    }
}
