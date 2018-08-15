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
}
