package darian.serviceImpl;

import darian.dao.UserDao;
import darian.entity.User;
import darian.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    //验证登录
    public User loginVerify(String username, String password) {
        return userDao.selectByNameAndPwd(username,password);
    }

    //注册
    public boolean registerVerify(User user) {
        return userDao.insert(user) > 0;
    }
}
