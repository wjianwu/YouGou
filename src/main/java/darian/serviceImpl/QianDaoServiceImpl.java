package darian.serviceImpl;

import darian.dao.SignDao;
import darian.dao.UserDao;
import darian.entity.Sign;
import darian.service.QianDaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QianDaoServiceImpl implements QianDaoService {

	@Resource
	private SignDao signDao;

	@Override
	public Sign getSignByUserId(int userId) {
		return signDao.selectByUserId(userId);
	}

	@Override
	public boolean updateQianDao(Sign sign) {
		return signDao.updateByPrimaryKey(sign)>0;
	}

	@Override
	public boolean addSign(Sign sign) {
		return signDao.insert(sign) > 0;
	}
}
