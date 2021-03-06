package com.wepaint.mvc.service.impl;

import com.wepaint.mvc.bean.User;
import com.wepaint.mvc.dao.UserDao;
import com.wepaint.mvc.dao.impl.UserDaoImpl;
import com.wepaint.mvc.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }
}
