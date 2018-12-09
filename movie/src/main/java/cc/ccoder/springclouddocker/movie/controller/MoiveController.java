package cc.ccoder.springclouddocker.movie.controller;

import cc.ccoder.springclouddocker.movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 聪聪 www.ccoder.cc
 * @date 2018/12/9 17:18
 */
@RestController
public class MoiveController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8080/"+id,User.class);
    }

}
