package darian.service;

import darian.entity.Admin;

public interface AdminService {

	Admin verifyNameAndPwd(String name, String pwd);
}
