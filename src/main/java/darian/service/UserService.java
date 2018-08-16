package darian.service;

import darian.entity.User;

public interface UserService {

    User getUserById(int id);

    //验证登录
    User loginVerify(String username,String password);

    //注册
    boolean registerVerify(User user);
}
