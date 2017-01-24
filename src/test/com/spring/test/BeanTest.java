package com.spring.test;

/**
 * Created by Gerry on 2017/1/5.
 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
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
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

    @Test
    public void saveUser() {
        String sql = "insert into user (name,password) values(?,?)";
        jdbcTemplate.update(sql, "ITDragon", "123456789");
    }

    @Test
    public void updateUser() {
        String sql = "update user set name = ? , password = ? where id = ?";
        jdbcTemplate.update(sql, "ITDragon", "987654321", 2);
    }

    @Test
    public void deleteUser() {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, 2);
    }

    @Test
    public void saveUsers() {
        String sql = "insert into user (name,password) values(?,?)";
        List<Object[]> users = new ArrayList<Object[]>();
        users.add(new Object[]{"ITDragon", "123456789"});
        users.add(new Object[]{"ITDragon1", "1234567891"});
        users.add(new Object[]{"ITDragon2", "1234567892"});
        jdbcTemplate.batchUpdate(sql, users);
    }

    @Test
    public void updateUsers() {
        String sql = "update user set name = ? , password = ? where id = ?";
        List<Object[]> users = new ArrayList<Object[]>();
        users.add(new Object[]{"ITDragon0", "123456789", 3});
        users.add(new Object[]{"ITDragon01", "1234567891", 4});
        users.add(new Object[]{"ITDragon02", "1234567892", 5});
        jdbcTemplate.batchUpdate(sql, users);
    }

    @Test
    public void poitest() throws Exception {
        //输入输出流
        InputStream is = new FileInputStream("/Users/mac/Desktop/text.xlsx");
        //创建工作空间
        Workbook wb = WorkbookFactory.create(is);
        //获取工作表
        Sheet sheet = wb.getSheetAt(0);//获取第一个工作表
        //工作行
        Row row;
        //工作单元格
        Cell cell;
        //System.out.println("1:"+cell);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            //获取第i行的工作行,第0行是列头，所以从第1行开始
            row = sheet.getRow(i);
            //获取第i行的工作行的第6个单元格的值
            cell = row.getCell(5);
            String str = cell.toString();
            //打印出所有的产品编号
            System.out.println(str);
        }
    }
}