package darian.controller;

import darian.entity.Sign;
import darian.entity.User;
import darian.service.QianDaoService;
import darian.service.UserService;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class QianDaoController {

	@Resource
	private QianDaoService qianDaoService;
	@Resource
	private UserService userService;

	@RequestMapping("/qianDao")
	@ResponseBody
	public Map<String,Object> qianDao(HttpServletRequest request){

		Map<String,Object> map = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		//判断签到表是否存在用户
		Sign sign = qianDaoService.getSignByUserId(user.getId());

		if(sign != null){

			if(!sign.getEnable()){
				//存在，更新
				sign.setEnable(true);		//已签到
				int day = sign.getContin();	//连续签到天数
				sign.setUserId(user.getId());
				int rank = 0;				//根据连续签到天数来确定增加积分数 Rank 10,30,50/day 3,5,7
				if(day<3){ rank = 10; }else if(day>3&&day<7){ rank = 30; }else { rank = 50; }

				sign.setContin(sign.getContin()+1);			//连续签到数+1
				sign.setRank(user.getAmount() + rank);		//将用户表的积分存在签到表+今日签到的积分
				user.setAmount(sign.getRank());				//用户表的积分和签到表积分保持统一
				sign.setSignTime(new Timestamp(new Date().getTime())); //签到时间

				//更新签到表
				// 更新用户表积分
				if(qianDaoService.updateQianDao(sign)&&userService.updateUser(user)){
					map.put("status","ok");
				}else {
					map.put("status","error");
				}
			}else {
				map.put("status","yiQian");
			}

		}else {
			//不存在，插入
			Sign sign1 = new Sign();	//插入对象
			sign1.setEnable(true);		//已签到
			sign1.setContin(1);			//签到天数
			sign1.setUserId(user.getId());

			sign1.setRank(10);			//首次签到10积分
			user.setAmount(user.getAmount()+10);	//用户表积分增加
			sign1.setSignTime(new Timestamp(new Date().getTime())); //签到时间

			//更新用户表积分
			// 插入签到表
			if(userService.updateUser(user) && qianDaoService.addSign(sign1)){
				map.put("status","ok");
			}else {
				map.put("status","error");
			}
		}
		return map;
	}

	@RequestMapping("/showSign")
	@ResponseBody
	public Sign showSign(HttpSession session){
		User user = (User) session.getAttribute("user");
		return qianDaoService.getSignByUserId(user.getId());
	}

	@RequestMapping("/jianCeTime")
	@ResponseBody
	public Map jianCeTime(HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();

		User user = (User) session.getAttribute("user");
		Sign sign = qianDaoService.getSignByUserId(user.getId());

		Date date = sign.getSignTime();
		Date dateNow = new Date();
		if(dateNow.getTime()>date.getTime()+6000000){
			//一分钟后可签到
			sign.setEnable(false);//状态改成可签到
			sign.setSignTime(new Timestamp(new Date().getTime()));//存进当前签到的时间
			qianDaoService.updateQianDao(sign);
			map.put("status","ok");
		}else {
			map.put("status","error");
		}
		return map;
	}
}
