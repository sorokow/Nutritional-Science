package com.example.Nutritional_Science.Service;

import com.example.Nutritional_Science.Entity.User;
import com.example.Nutritional_Science.Entity.UserParameters;
import com.example.Nutritional_Science.Repository.UserParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserParametersService {

    @Autowired
    UserParametersRepository userParametersRepository;

    @Autowired
    UserService userService;

    public List<String> getParameters(String login){
        UserParameters userParameters =  userService.findUserParametersByLogin(login);
        List<String> parametersList = new ArrayList<>();

        if(userParameters!=null) {
            parametersList.add(String.valueOf(userParameters.getWeight()));
            parametersList.add(String.valueOf(userParameters.getHeight()));
            parametersList.add(String.valueOf(userParameters.getAge()));
            parametersList.add(String.valueOf(userParameters.isMan()));
            parametersList.add(String.valueOf(userParameters.getActivity()));

            return parametersList;
        }else
            return null;
    }

    public void updateDataAboutUser(UserParameters userParameters, String login){
        User user = userService.findUserByLogin(login);
        double coefficient =((double)(needCallories(userParameters)) / 2500.0);
        if(user.getUserParameters()==null){
            userParameters.setCoefficient(coefficient);
            userParametersRepository.save(userParameters);
            user.setUserParameters(userParameters);
            userService.saveOneUser(user);
        }else{
            UserParameters currentUP = userService.findUserParametersByLogin(login);
            userParameters.setId(currentUP.getId());
            userParameters.setCoefficient(coefficient);
            userParametersRepository.save(userParameters);
        }
    }

    public int needCallories(UserParameters userParameters){
        try {
            if (userParameters.getWeight() == 0 && userParameters.getWeight() == 0 && userParameters.getAge() == 0) {

                return -2;
            }

            if (userParameters.getWeight() < 1 || userParameters.getWeight() > 500
                    || userParameters.getHeight() < 30 || userParameters.getHeight() > 300
                    || userParameters.getAge() < 5 || userParameters.getAge() > 150) {
                return -1;
            }

            if (userParameters.isMan()) {
                double result = (88.362 + (13.397 * userParameters.getWeight()) +
                        (4.799 * userParameters.getHeight()) - (5.677 * userParameters.getAge()))
                        * userParameters.getActivity();
                return (int) result;
            } else {
                double result = (447.593 + (9.247 * userParameters.getWeight()) + (3.098 * userParameters.getHeight()) - (4.33 * userParameters.getAge())) * userParameters.getActivity();
                return (int) result;
            }
        }
        catch (Exception ex){
            return -2;
        }
    }

    public Optional<UserParameters> findParameterByUserId(Long id){
        return userParametersRepository.findById(id);
    }

}
