package cc.ccoder.springclouddocker.user.service.impl;

import cc.ccoder.springclouddocker.user.pojo.User;
import cc.ccoder.springclouddocker.user.repository.UserRepository;
import cc.ccoder.springclouddocker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 聪聪 www.ccoder.cc
 * @date 2018/12/8 18:23
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
}
