package darian.controller;

import darian.entity.Sign;
import darian.entity.User;
import darian.service.QianDaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class QianDaoController {

	@Resource
	private QianDaoService qianDaoService;

	@RequestMapping()
	@ResponseBody
	public String qianDao(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//判断签到表是否存在用户
		Sign sign = qianDaoService.getSignByUserId(user.getId());
		if(sign != null){
			//存在，更新

			sign.setEnable(true);		//已签到
			int day = sign.getContin();	//连续签到天数
			int rank = 0;				//根据连续签到天数来确定增加积分数 Rank 10,30,50/day 3,5,7
			if(day<3){ rank = 10; }else if(day>3&&day<7){ rank = 30; }else { rank = 50; }

			sign.setContin(sign.getContin()+1);			//连续签到数+1
			sign.setRank(user.getAmount() + rank);		//将用户表的积分存在签到表+今日签到的积分
			user.setAmount(sign.getRank());				//用户表的积分和签到表积分保持统一
			sign.setSignTime(new Timestamp(new Date().getTime())); //签到时间
		}else {
			//不存在，插入
		}


		return "";
	}

}
