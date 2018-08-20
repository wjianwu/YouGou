package darian.controller;

import darian.entity.User;
import darian.extra.Email;
import darian.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/show")
    @ResponseBody
    public User testSSM(HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
		System.out.println(user);
        return userService.getUserById(user.getId());
    }

    //修改基本资料
    @RequestMapping("/updateUser")
    @ResponseBody
    public Map updateUser(HttpServletRequest request, @ModelAttribute User user) {

        Map<String, Object> result = new HashMap<String, Object>();

        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");

        user1.setEmail(user.getEmail());
        user1.setSex(user.getSex());
        user1.setUsername(user.getUsername());
        user1.setSignature(user.getSignature());

        if(userService.updateUser(user1)){
            result.put("status",0);
            result.put("msg","修改成功");
        }else {
            result.put("status",1);
            result.put("msg","修改失败");
        }
        return result;
    }

    //修改密码
    @RequestMapping("/updatePwd")
    @ResponseBody
    public Map updatePwd(HttpServletRequest request){

        Map<String,Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        //输入的密码
        String nowpass = request.getParameter("nowpass");
        //判断密码是否正确
        if(user.getPassword().equals(nowpass)){
            //正确则进行密码修改
            String pwd = request.getParameter("pass");
            if(userService.updatePwd(user.getId(),pwd)){
                map.put("status","ok");
                user.setPassword(pwd);
                session.setAttribute("user",user);
            }else {
                map.put("status","error1");
            }
        }else {
            map.put("status","error2");
        }
        return map;
    }

    @RequestMapping("/findpass")
    @ResponseBody
    public Map findPass(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        String email = request.getParameter("email");
        String pass = userService.getUserByEmail(email);

        if(pass == null){
            map.put("status","error");
            return map;
        }else{
            String textarea = "您通过邮箱来获取到您的密码，如非本人操作，请尽快修改密码，以免引起密码泄露。您的账户密码时：";
            Email.send_mail(email,textarea+pass);
            map.put("status","ok");
            return map;
        }

    }
}
