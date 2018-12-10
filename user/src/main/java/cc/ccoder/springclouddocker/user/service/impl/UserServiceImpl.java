package cc.ccoder.springclouddocker.user.service.impl;

import cc.ccoder.springclouddocker.user.pojo.User;
import cc.ccoder.springclouddocker.user.repository.UserRepository;
import cc.ccoder.springclouddocker.user.service.UserService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 聪聪 www.ccoder.cc
 * @date 2018/12/8 18:23
 */
@Service
@Slf4j
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

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Long deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            log.error("user delete error,id:{}", id, e);
            return null;
        }
        return id;
    }
}
