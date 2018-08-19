package darian.controller;

import darian.entity.User;
import darian.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController {

    @Resource
    private UserService userService;

    //上传图片
    @RequestMapping("/uploadImg")
    @ResponseBody
    public Map uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        HashMap<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //文件为空
        if (file.isEmpty()) {
            result.put("status", 1);
            result.put("msg", "文件为空");
        }

        //生成uuid作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件类型
        String contentType = file.getContentType();
        //获取文件后缀名
        String suffixName = contentType.substring(contentType.indexOf("/") + 1);
        //拼接成新的文件名
        String filename = uuid + "." + suffixName;


        //实际本地目录
        String path = "E:\\IDEA\\Projects\\SSM\\web\\upload\\";
        File dest = new File(path + filename);

        //上传文件名到数据库
        if (userService.uploadImg(user.getId(), "/images/" + filename)) {
            //顺便把session里的值修改一下
            user.setHeadUrl("/images/"+filename);
            try {
                file.transferTo(dest);
                result.put("status", 0);
                result.put("msg", "上传成功");
                result.put("url", dest.getPath());
            } catch (IOException e) {
                e.printStackTrace();
                result.put("status", 1);
                result.put("msg", "上传失败");
            }
        }
        return result;
    }
}
