package darian.dao;

import darian.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    //注册用，接受用户对象
    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    //验证登录用，给定邮箱账户和密码
    User selectByNameAndPwd(@Param("username") String username, @Param("password") String password);

}