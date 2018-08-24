package darian.service;

import darian.entity.Sign;

public interface QianDaoService {

	//查签到表
	Sign getSignByUserId(int userId);

	//更新签到表
	boolean updateQianDao(Sign sign);

	//插入到签到表
	boolean addSign(Sign sign);
}
