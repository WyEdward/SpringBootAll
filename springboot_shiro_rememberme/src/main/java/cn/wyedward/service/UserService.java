package cn.wyedward.service;

import cn.wyedward.domain.User;

public interface UserService {
    User findUserByName(String username);
}
