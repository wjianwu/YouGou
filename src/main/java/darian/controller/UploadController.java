package darian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {


    @RequestMapping("/uploadImg")
    @ResponseBody
    public Map uploadImg(@RequestParam("file")MultipartFile file){
        HashMap<String,Object> result = new HashMap<String, Object>();
        if(file.isEmpty()){
            result.put("code",1);
            result.put("msg","文件为空");
        }
        String filename = file.getOriginalFilename();
        int size = (int)file.getSize();

        String path = "D:/test";
        File dest = new File(path+"/"+filename);
        try {
            file.transferTo(dest);
            result.put("code",0);
            result.put("msg","上传成功");
            result.put("url",dest.getPath());
        } catch (IOException e) {
            e.printStackTrace();
            result.put("code",1);
            result.put("msg","上传失败");
        }
        return result;
    }
}
