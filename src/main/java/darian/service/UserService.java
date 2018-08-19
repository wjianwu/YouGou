package darian.service;

import darian.entity.User;

public interface UserService {

    User getUserById(int id);

    //验证登录
    User loginVerify(String nickname, String password);

    //注册
    boolean registerVerify(User user);

    //更新资料
    boolean updateUser(User user);

    //上传头像
    boolean uploadImg(int id, String filename);

    //修改密码
    boolean updatePwd(int id, String nowpass);

    String getUserByEmail(String email);
}
