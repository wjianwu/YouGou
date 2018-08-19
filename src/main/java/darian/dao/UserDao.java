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
    User selectByNameAndPwd(@Param("nickname") String nickname, @Param("password") String password);

    //上传头像
    int uploadImg(@Param("id")int id, @Param("headUrl") String filename);

    //修改密码
    int updatePwd(@Param("id")int id,@Param("nowpass") String nowpass);

    //找回密码
    String selectByEmail(@Param("email") String email);
}