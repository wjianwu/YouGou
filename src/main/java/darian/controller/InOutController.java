package darian.controller;

import darian.entity.User;
import darian.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class InOutController {

	@Resource
	private UserService userService;

	//登录控制
	@RequestMapping("/login")
	@ResponseBody
	public Map loginVerify(HttpServletRequest request) {

		Map<String,String> map = new HashMap<String, String>();
		//邮箱账户，密码
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");

		//保存当前用户名
		HttpSession session = request.getSession();

		User user = userService.loginVerify(nickname, password);

		if (user != null) {
			session.setAttribute("user", user);
			map.put("status","ok");
			return map;
		} else {
			map.put("status","error");
			return map;
		}
	}

	//注册控制
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {

		//邮箱账户，密码，昵称，当前时间
		User user = new User();
		user.setNickname(request.getParameter("nickname"));
		user.setUsername("UserName");
		user.setPassword(request.getParameter("password"));
		user.setAmount(0);
		user.setEnable(true);
		user.setCreateOn(new Timestamp(new Date().getTime()));

		boolean flag = userService.registerVerify(user);

		if (flag) {
			return "redirect:/html/user/login.html";
		} else {
			return "redirect:/views/404.html";
		}

	}

	//退出登录控制
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/html/index.html";
	}

	//
	@RequestMapping("/header")
	@ResponseBody
	public Map getHeader(HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();

		User user = (User) session.getAttribute("user");
		if(user==null){
			map.put("status","ok");
		}else {
			map.put("status","error");
		}

		return map;
	}
}
