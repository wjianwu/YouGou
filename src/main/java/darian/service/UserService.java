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
	//更新头像的同时更新帖子表里面对应的头像
    boolean uploadImg(int id, String filename);
    boolean updateTopicImg(int id,String filename);
    boolean updateCommentImg(int id,String filename);

    //修改密码
    boolean updatePwd(int id, String nowpass);

    //邮箱找回密码
    String getUserByEmail(String email);
}
