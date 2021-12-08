package com.chooseking.reed.service.serviceImpl;

import com.chooseking.reed.entity.User;
import com.chooseking.reed.mapper.userMapper;
import com.chooseking.reed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2021/11/17 16:53
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    userMapper userMapper;
    @Override
    public User selectUserForLogin(String username) { return userMapper.selectInfoByUsername(username); }
    @Override
    public boolean insertUser(User user) {
        return userMapper.insert(user) == 1;
    }
    @Override
    public boolean deleteUser(int id) {
        return userMapper.delete(id) == 1;
    }
    @Override
    public boolean updateUserInfo(User user) {
        return userMapper.updateInfo(user) == 1;
    }
    @Override
    public boolean updateUserPassword(int id, String password, String salt) { return userMapper.updatePassword(id, password,salt) == 1; }
    @Override
    public boolean isExist(String username) {
        return userMapper.isExist(username) >= 1;
    }
    @Override
    public User selectUser(int id) {
        return userMapper.select(id);
    }
    @Override
    public User selectUserForPassword(int id) {
        return userMapper.selectInfoByUserId(id);
    }
    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }


}
