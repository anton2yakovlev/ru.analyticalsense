package ru.analyticalsense.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.analyticalsense.domain.Role;
import ru.analyticalsense.domain.User;
import ru.analyticalsense.repos.UserRepo;

import java.util.Collections;
import java.util.Map;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/registration")
    public String createUser(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            Map<String, Object> model) {



        User user = new User(username, password);
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("status", "warning");
            model.put("message", "User <b>" + user.getUsername() + "</b> exists! <a href='#'>You can restore password</a>");
            model.put("icon", "icon-warning-sign");
            return new Gson().toJson(model);
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        model.put("status", "success");
        model.put("message", "User <b>" + user.getUsername() + "</b> has been created! ");
        model.put("icon", "icon-thumbs-up");
        model.put("user", user);

        return new Gson().toJson(model);
    }
}
