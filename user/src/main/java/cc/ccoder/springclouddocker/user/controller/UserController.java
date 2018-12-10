package cc.ccoder.springclouddocker.user.controller;

import cc.ccoder.springclouddocker.user.pojo.User;
import cc.ccoder.springclouddocker.user.repository.UserRepository;
import cc.ccoder.springclouddocker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 聪聪 www.ccoder.cc
 * @date 2018/12/8 18:20
 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        User user = this.userService.findById(id);
        return user;
    }

    @PostMapping("/add")
    public User addUser(User user) {
        User result = userService.addUser(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable Long id) {
        Long result = userService.deleteUserById(id);
        return result == null ? "error" : "success";
    }
}
