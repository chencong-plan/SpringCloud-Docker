package cc.ccoder.springclouddocker.user.controller;

import cc.ccoder.springclouddocker.user.pojo.User;
import cc.ccoder.springclouddocker.user.repository.UserRepository;
import cc.ccoder.springclouddocker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User user = this.userService.findById(id);
        return user;
    }
}
