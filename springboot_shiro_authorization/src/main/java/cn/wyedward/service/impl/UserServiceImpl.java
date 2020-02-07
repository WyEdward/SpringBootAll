package cn.wyedward.service.impl;

import cn.wyedward.dao.UserDao;
import cn.wyedward.domain.User;
import cn.wyedward.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }
}
