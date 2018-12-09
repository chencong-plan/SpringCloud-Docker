package cc.ccoder.springclouddocker.movie.pojo;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author 聪聪 www.ccoder.cc
 * @date 2018/12/9 17:16
 */
@Data
public class User {

    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

}
