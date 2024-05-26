package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String all (Model model) {
        model.addAttribute("test", "All users");
        List<User> allUs = userService.getAll();
        model.addAttribute("users",  allUs);
        return "index";
    }

    @GetMapping("/addNew")
    public String addUser (Model model) {
        User user = new User();
        model.addAttribute("userAdd",  user);
        return "index-info";
    }

    @PostMapping("/saveNew")
    public String saveUser (@ModelAttribute("userAdd") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("userAdd", user);
        return "index-info";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id, Model model) {
        User user = userService.deleteUser(id);
        return "redirect:/";
    }
}
