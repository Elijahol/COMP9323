package com.vport.system.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vport.system.bean.ResponseData;
import com.vport.system.exception.MessageException;
import com.vport.system.pojo.person.User;
import com.vport.system.service.UserService;
import com.vport.system.utils.UUIDUtils;

@Controller
@RequestMapping(value="common")
public class CommonController {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
   
   
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
    
    @Autowired
    private UserService userService;
    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[] { "bmp", "jpg", "jpeg", "gif", "png" };
    
    @RequestMapping(value="updateUser",method=RequestMethod.POST)
    @ResponseBody
    public ResponseData updateUser(@RequestBody User user) throws Exception{
        ResponseData responseData = null;        
        userService.updateUserSelective(user);
        responseData = new ResponseData(0, "", null);
        return responseData;
    }
    
    @RequestMapping(value="updateIcon",method=RequestMethod.POST,consumes = {"multipart/form-data"})
    @ResponseBody
    public ResponseData updateIcon(@RequestPart("icon") MultipartFile pictureFile){
        ResponseData responseData = null;
        String fileName = null;
        User existUser = (User) session.getAttribute("existUser");
        if (pictureFile.getSize() != 0) {
            try {
                fileName = checkTheFile(pictureFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fileName == null) {
                responseData = new ResponseData(1, "上传文件不合法", null);
                return responseData;
            }else{
                existUser.setIcon(fileName);
                userService.updateUserSelective(existUser);
                responseData = new ResponseData(0, "", null);
                return responseData;
            }
        }
        responseData = new ResponseData(0, "上传文件为空", null);
        return responseData;
    }
    @RequestMapping(value="showProfile",method=RequestMethod.GET)
    public String showProfile(Long id,Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }
    
    private String checkTheFile(MultipartFile pictureFile) throws Exception{
      //保存图片
        String fileName = UUIDUtils.getUUID();
        
        String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        
        //校验图片
        boolean isLegal = false;
        for(String type: IMAGE_TYPE){
            if (extension.equalsIgnoreCase(type)) {
                isLegal = true;
                break;
            }
        }
        if (isLegal) {
            fileName = fileName+"."+extension;
            File newFile = new File("E:\\comp9323_pro\\file-upload\\"+fileName);
            pictureFile.transferTo(newFile);
            try{
                BufferedImage image = ImageIO.read(newFile);
                if (image != null) {
                   int height = image.getHeight();
                   int width = image.getWidth();
                   System.out.println(height + "------------" + width);
                }else{
                    isLegal = false;
                }
            }catch(IOException e){
                System.out.println("不是图片");
                isLegal = false;
            }
            if(!isLegal){
                // 不合法，将磁盘上的文件删除
                newFile.delete();
                return null;
            }
            return fileName;
        }else{
            return null;
        }
    }
}
