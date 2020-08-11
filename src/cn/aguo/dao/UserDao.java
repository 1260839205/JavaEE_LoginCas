package cn.aguo.dao;


import cn.aguo.user.User;
import cn.aguo.util.JDBCUtils;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author 石成果
 * @Date 2020/8/4 11:44
 * @Email 1260839205@qq.com
 */
public class UserDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User Login(User login){
        try{

            String sql = "select * from user where username = ? and password = ?";

            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    login.getUsername(), login.getPassword()
            );

            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
