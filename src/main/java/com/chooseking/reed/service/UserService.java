package com.chooseking.reed.service;

import com.chooseking.reed.entity.User;

import java.util.List;

public interface UserService {



    public User selectUserForLogin(String username);

    public boolean insertUser(User user);

    public boolean deleteUser(int id);

    public boolean updateUserInfo(User user);

    public boolean updateUserPassword(int id, String password, String salt);

    public boolean isExist(String username);

    public User selectUser(int id);

    public User selectUserForPassword(int id);

    public List<User> selectAllUser();
}
