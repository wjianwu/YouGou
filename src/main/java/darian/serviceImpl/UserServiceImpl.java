package darian.serviceImpl;

import darian.dao.UserDao;
import darian.entity.User;
import darian.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

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
}
