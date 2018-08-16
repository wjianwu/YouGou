package darian.controller;

import darian.entity.User;
import darian.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class InOutController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String loginVerify(HttpServletRequest request){

        //邮箱账户，密码
        String username = request.getParameter("email");
        String password = request.getParameter("pass");

        //保存当前用户名
        HttpSession session = request.getSession();

        User user = userService.loginVerify(username,password);

        if(user != null){
            session.setAttribute("user",user);
            return "redirect:/html/index-2.html";
        }else {
            return "user/login";
        }
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request){

        //邮箱账户，密码，昵称，当前时间
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("pass"));
        user.setNickname(request.getParameter("username"));
        user.setCreateOn(new Timestamp(new Date().getTime()));

        boolean flag = userService.registerVerify(user);

        if(flag){
            return "redirect:/html/index-2.html";
        }else {
            return "redirect:/views/404.html";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/html/index.html";
    }
}
