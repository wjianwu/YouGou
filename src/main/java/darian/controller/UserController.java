package darian.controller;

import darian.entity.User;
import darian.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    //传用户对象到前端（ajax显示）
    @RequestMapping("/show")
    @ResponseBody
    public User testSSM(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (User) session.getAttribute("user");
    }

    //修改基本资料
    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request, @ModelAttribute User user, Model model) {

        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        user1.setEmail(user.getEmail());
        user1.setSex(user.getSex());
        user1.setUsername(user.getUsername());
        user1.setSignature(user.getSignature());

        if(userService.updateUser(user1)){
            return "redirect:/html/user/set.html";
        }else {
            return "redirect:/html/other/404.html";
        }
    }
}
