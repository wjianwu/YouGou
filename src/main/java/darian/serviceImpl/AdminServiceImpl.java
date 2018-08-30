package darian.serviceImpl;

import darian.dao.AdminDao;
import darian.entity.Admin;
import darian.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao;

	@Override
	public boolean verifyNameAndPwd(String name, String pwd) {

		Admin admin = adminDao.selectByNameAndPwd(name,pwd);
		return admin != null;
	}
}
