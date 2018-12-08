package cc.ccoder.springclouddocker.user.service;

import cc.ccoder.springclouddocker.user.pojo.User;

/**
 * @author 聪聪 www.ccoder.cc
 * @date 2018/12/8 18:23
 */
public interface UserService {

    User findById(Long id);

}
