package darian.service;

import darian.entity.Sign;

public interface QianDaoService {

	//查签到表
	Sign getSignByUserId(int userId);
}
