package cc.ccoder.springclouddocker.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author 聪聪 www.ccoder.cc
 * @date 2018/12/8 18:14
 */
@Entity
@Data
public class User {
    /**
     * 主键，自增
     */
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;

}
