package com.chooseking.reed.mapper;

import com.chooseking.reed.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface userMapper {
    @Insert("insert into user " +
            "values(null, #{username}, #{password}, #{salt})")
    int insert(User user);

    @Select("select id, username, password, salt " +
            "from user " +
            "where username = #{username}")
    @ResultType(User.class)
    User selectInfoByUsername(String username);

    @Delete("delete from user where id = #{id}")
    int delete(int id);

    @Update("update user password = #{password} where id = #{id}")
    int updateInfo(User user);

    @Update("update user " +
            "set password = #{password}, " +
            "salt = #{salt} " +
            "where user_id = #{userId}")
    int updatePassword(int userId, String password, String salt);


    @Select("select id, username, password" +
            "from user " +
            "where id = #{id}")
    @ResultType(User.class)
    User select(int id);


    @Select("select id, username, password, salt " +
            "from user " +
            "where id = #{id}")
    @ResultType(User.class)
    User selectInfoByUserId(int id);

    @Select("select id, username, password " +
            "from user")
    @ResultType(User.class)
    List<User> selectAll();

    @Select("select count(*) " +
            "from user " +
            "where username = #{username}")
    int isExist(String username);
}
