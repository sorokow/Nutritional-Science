package com.example.Nutritional_Science.Service;


import com.example.Nutritional_Science.Entity.User;
import com.example.Nutritional_Science.Entity.UserParameters;
import com.example.Nutritional_Science.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public boolean findOneUserByLogin(String login){
        if(userRepository.findByLogin(login)!=null)
        return true;
        else return false;
    }

    public String addUser(User user) {
        try{

            if(findOneUserByLogin(user.getLogin())){
                return "redirect:/errorRegistration";
            }else {
                createUser(user);
                return "redirect:/login";
            }
        }
        catch (Exception e){
            return "redirect:/wrongData";
        }
    }
    public UserParameters findUserParametersByLogin(String login) {
//        List<User> list = (List<User>) userRepository.findAll();
//        User user = null;
//        for(User u:list){
//            if(u.getLogin().equals(login)){
//                user = u;
//                return u.getUserParameters();
//            }
//        }

        User user = userRepository.findByLogin(login);
        return user.getUserParameters();

       // return null;
    }

    public User findUserByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public void saveOneUser(User user){
        userRepository.save(user);
    }
}
