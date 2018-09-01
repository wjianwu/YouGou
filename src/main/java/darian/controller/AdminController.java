package darian.controller;

import darian.entity.Admin;
import darian.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminController {

	@Resource
	private AdminService adminService;

	@RequestMapping("/verifyAdmin")
	@ResponseBody
	public Map verifyAdmin(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Admin admin = adminService.verifyNameAndPwd(name,pwd);
		if(admin!=null){
			HttpSession session = request.getSession();
			session.setAttribute("admin",admin);
			map.put("status","ok");
		}else {
			map.put("status","error");
		}
		return map;
	}
}
