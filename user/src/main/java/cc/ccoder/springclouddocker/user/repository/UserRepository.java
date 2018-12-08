package cc.ccoder.springclouddocker.user.repository;

import cc.ccoder.springclouddocker.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 聪聪 www.ccoder.cc
 * @date 2018/12/8 18:20
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
