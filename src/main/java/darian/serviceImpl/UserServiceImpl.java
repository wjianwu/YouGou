package darian.serviceImpl;

import darian.dao.CommentDao;
import darian.dao.TopicDao;
import darian.dao.UserDao;
import darian.entity.User;
import darian.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private TopicDao topicDao;
    @Resource
    private CommentDao commentDao;

    public User getUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    //验证登录
    public User loginVerify(String nickname, String password) {
        return userDao.selectByNameAndPwd(nickname, password);
    }

    //注册
    public boolean registerVerify(User user) {
        return userDao.insert(user) > 0;
    }

    //更新资料
    public boolean updateUser(User user) {
        return userDao.updateByPrimaryKey(user) > 0;
    }

    @Override
    public boolean uploadImg(int id, String filename) {
        return userDao.uploadImg(id, filename) > 0;
    }

	//更新头像的同时更新帖子表里面对应的头像
    @Override
    public boolean updateTopicImg(int id, String filename) {
        return topicDao.updateTopicImg(id,filename) > 0;
    }

    @Override
    public boolean updateCommentImg(int id, String filename) {
        return commentDao.updateCommentImg(id,filename) > 0;
    }

    @Override
    public boolean updatePwd(int id, String nowpass) {
        return userDao.updatePwd(id,nowpass) > 0;
    }

    //找回密码
    @Override
    public String getUserByEmail(String email) {
        return userDao.selectByEmail(email);
    }

}
