package ru.dorogov.web.controllers.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dorogov.web.exceptions.UserDoesNotExistException;
import ru.dorogov.web.repo.UserRepo;

import ru.dorogov.web.tables.User;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @GetMapping("/user/add")
    public String userAdd () {
        return "userAdd";
    }

    @PostMapping("/user/addRoot")
    public String gameChangeRoot (@RequestParam("name") String name,
                                     @RequestParam("surname") String surname,
                                        @RequestParam("mail") String mail) {
        return userService.addUser(name, surname, mail);
    }

    @GetMapping("/allUsers")
    public String allUsers (Model model) {
        return userService.allUsers(model);
    }

    @GetMapping("/changeUser/{id}")
    public String userChange (@PathVariable(value = "id") Long id, Model model) {
        if (!userRepo.existsById(id)) {
            return "home";
        }
        return userService.userChange(id, model);
    }

    @GetMapping("/user/{id}/edit")
    public String userEdit (@PathVariable(value = "id") Long id, Model model) {
        if (!userRepo.existsById(id)) {
            return "home";
        }
        return userService.userEdit(id, model);
    }

    @Transactional
    @PostMapping("/user/{id}/edit")
    public String userUpdate (@RequestParam("name") String name,
                                     @RequestParam("surname") String surname,
                                        @RequestParam("mail") String mail,
                                            @PathVariable(value = "id") Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserDoesNotExistException(id));
        return userService.userUpdate(user, name, surname, mail);
    }

    @Transactional
    @PostMapping("/user/{id}/remove")
    public String userDelete (@PathVariable(value = "id") Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserDoesNotExistException(id));
        return userService.userDelete(user);
    }

}
