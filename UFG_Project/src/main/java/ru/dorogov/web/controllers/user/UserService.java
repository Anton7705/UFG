package ru.dorogov.web.controllers.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.dorogov.web.repo.UserRepo;
import ru.dorogov.web.tables.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    List<User> toList(Long id) {
        Optional<User> user = userRepo.findById(id);
        ArrayList<User> list = new ArrayList<>();
        user.ifPresent(list::add);
        return list;
    }

    public String userChange(Long id, Model model) {
        model.addAttribute("userInf", toList(id));
        return "userChange";
    }

    public String userEdit(Long id, Model model) {
        model.addAttribute("userInf", toList(id));
        return "userEdit";
    }

    @Transactional
    public String userUpdate(User user, String name, String surname, String mail) {
        user.setName(name);
        user.setSurname(surname);
        user.setMail(mail);
        return "redirect:/root";
    }

    public String addUser(String name, String surname, String mail) {
        User user = new User(name, surname, mail);
        userRepo.save(user);
        return "redirect:/root";
    }

    public String allUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "usersInfo";
    }

    @Transactional
    public String userDelete(User user) {
        userRepo.delete(user);
        return "redirect:/root";
    }

}
