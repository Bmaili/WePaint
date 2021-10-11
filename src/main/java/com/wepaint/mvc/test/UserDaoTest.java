package com.wepaint.mvc.test;

import com.wepaint.mvc.bean.User;
import com.wepaint.mvc.dao.UserDao;
import com.wepaint.mvc.dao.impl.UserDaoImpl;
import com.wepaint.mvc.service.UserService;
import com.wepaint.mvc.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    private UserService userService = new UserServiceImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin") == null ){
            System.out.println("数据库查询测试成功，用户名不存在");
        } else {
            System.out.println("数据库查询测试成功，用户名存在");
        }
    }

    @Test
    public void saveUser() {
        userService.registUser(new User(null,"ces667", "123456", "ces666@qq.com"));
    }
}
