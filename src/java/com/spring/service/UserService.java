package com.spring.service;

/**
 * Created by Gerry on 2017/1/4.
 */

import com.spring.controller.UserController;
import com.spring.dao.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    private final Logger log = Logger.getLogger(UserService.class);
    public void getService() {
        //System.out.print("这是service层,调用Repository方法 : ");
    }

    public String isexsits(String name) throws Exception {
        List ulist=userMapper.userexsits(name);
        log.info(ulist);
        if(ulist.isEmpty()){
            return "0";
        }else{
            return "1";
        }
    }
}
