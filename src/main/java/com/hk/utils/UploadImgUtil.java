package com.hk.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @Classname UploadImgUtil
 * @Description 封装的一个上传头像的工具类
 * @Date 2019/7/9 21:07
 * @Created by HK
 */
public class UploadImgUtil {
    public String uploadImg(MultipartFile img, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        String mypath = session.getServletContext().getRealPath("/userimages");
        File path = new File(mypath);
        if (!path.exists()){
            path.mkdirs();
        }

        String imagePath = "";
        if (!img.isEmpty()){
            String filename = img.getOriginalFilename();
            File file = new File(path, filename);
            img.transferTo(file);
            imagePath = req.getContextPath()+"/userimages/"+filename;
        }
        return imagePath;
    }
}
