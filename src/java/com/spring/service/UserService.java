package com.spring.service;

/**
 * Created by Gerry on 2017/1/4.
 */
import com.spring.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   @Autowired
   private UserMapper userMapper;
    public void getService(){
        System.out.print("这是service层,调用Repository方法 : ");

    }

}
