package darian.controller;

import darian.entity.User;
import darian.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/show")
    public String testSSM(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/show2")
    @ResponseBody
    public User getUserAjax(){
        return userService.getUserById(1);
    }
}
