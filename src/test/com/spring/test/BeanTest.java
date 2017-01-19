package com.spring.test;

/**
 * Created by Gerry on 2017/1/5.
 */
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//import com.spring.entity.Main;


public class BeanTest {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null;

    {
        ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
    }

    @Test
    public void saveUser(){
        String sql = "insert into user (name,password) values(?,?)";
        jdbcTemplate.update(sql, "ITDragon","123456789");
    }

    @Test
    public void updateUser(){
        String sql = "update user set name = ? , password = ? where id = ?";
        jdbcTemplate.update(sql, "ITDragon","987654321",2);
    }

    @Test
    public void deleteUser(){
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,2);
    }

    @Test
    public void saveUsers(){
        String sql = "insert into user (name,password) values(?,?)";
        List<Object[]> users = new ArrayList<Object[]>();
        users.add(new Object[]{"ITDragon","123456789"});
        users.add(new Object[]{"ITDragon1","1234567891"});
        users.add(new Object[]{"ITDragon2","1234567892"});
        jdbcTemplate.batchUpdate(sql, users);
    }

    @Test
    public void updateUsers(){
        String sql = "update user set name = ? , password = ? where id = ?";
        List<Object[]> users = new ArrayList<Object[]>();
        users.add(new Object[]{"ITDragon0","123456789",3});
        users.add(new Object[]{"ITDragon01","1234567891",4});
        users.add(new Object[]{"ITDragon02","1234567892",5});
        jdbcTemplate.batchUpdate(sql, users);
    }

}