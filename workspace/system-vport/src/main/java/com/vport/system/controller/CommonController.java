package com.vport.system.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
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
import com.vport.system.pojo.person.Reward;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.person.UserWithReward;
import com.vport.system.service.EvaluateService;
import com.vport.system.service.UserService;
import com.vport.system.utils.UUIDUtils;
/**
 * This controller handles the requests from both players and instructors,
 * and provides functions such as update the profile info, showing the performance data.
 * To request this controller the url has to start with "/rest/common/"
 * @author Siyu Wang, Chaoyi Zhou
 */
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
    @Autowired
    private EvaluateService evaluateService;
    
    // the valid extension of file upload from front end
    private static final String[] IMAGE_TYPE = new String[] { "bmp", "jpg", "jpeg", "gif", "png" };
    
    /**
     * This method is to handle the profile update.
     * After receiving the user info and the picture if the request has,
     * this method will use the method "checkTheFile" to check the validation of the picture
     * and complete the upload process and return the filePath.
     * Then, using userService to update the user information in the database
     * and also the user object in the session domain. 
     * @param user
     * @param pictureFile
     * @return
     * @throws Exception
     */
    @RequestMapping(value="updateUser",method=RequestMethod.POST)
    public String updateUser(User user, MultipartFile pictureFile) throws Exception{
        String fileName = null;
        if (pictureFile.getSize() != 0) {
            fileName = checkTheFile(pictureFile);
            if (fileName != null) {
                user.setIcon(fileName);
            }
        }
        userService.updateUserSelective(user);
        User existUser = userService.findUserById(user.getId());
        session.setAttribute("existUser", existUser);
        return "redirect:/rest/common/showProfile?id="+user.getId();
    }
    /**
     * This method is to use the service to find the user information
     * according to user id and response the profile back to front end
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="showProfile",method=RequestMethod.GET)
    public String showProfile(Long id,Model model){
        UserWithReward user = userService.findUserWithRewardById(id);
        model.addAttribute("user", user);
        return "profile";
    }
    /**
     * This method is to use service to find a player information
     * including the training data and response to front end
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="showStu",method=RequestMethod.GET)
    public String showStu(Long id, Model model){
        User user = userService.findUserById(id);
        user.setPassword(null);
        model.addAttribute("student", user);
        String comment = evaluateService.getRecentCommet(id);
        model.addAttribute("comment", comment);
        return "dataCenter";
    }
    
    /**
     * This method is also using service find a player information
     * including the training data but it is for the request from the trainer
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="showData",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, List<?>> showData(Long id,Model model){
        Map<String, List<?>> data = new HashMap<>();
        evaluateService.getAvgPerformanceDataByPlayer(id, data);
        evaluateService.getLastPerformanceDataByPlayer(id, data);
        evaluateService.getAvgPerformanceDataWithTimeOrder(id,data);
        evaluateService.getPerformanceScoreByTimeOrder(id,data);
        return data;
    }
    
    
    /**
     * This method is to get the uploaded reward info from the user,
     * and complete the relevant operation such as update, delete, or add
     * according to the option the user has choosen
     * @param reward
     * @param operation
     * @param model
     * @return
     */
    @RequestMapping(value="editReward",method=RequestMethod.POST)
    public String editReward(Reward reward,String operation,Model model){
        switch (operation) {
        case "Edit":
            userService.updateReward(reward);
            break;
        case "Delete":
            userService.deleteReward(reward);
            break;
        case "Add":
            userService.addReward(reward);
            break;
        }
        User exsitUser = userService.findUserById(reward.getUserId());
        session.setAttribute("exsitUser", exsitUser);
        return "redirect:/rest/common/showProfile?id="+exsitUser.getId();
    }
    
    /**
     * the private method support the file upload
     * @param pictureFile
     * @return
     * @throws Exception
     */
    private String checkTheFile(MultipartFile pictureFile) throws Exception{
        //generate the unique filename
        String fileName = UUIDUtils.getUUID();
        //get the extension
        String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        
        //validate the file
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
                   
                }else{
                    isLegal = false;
                }
            }catch(IOException e){
                System.out.println("not pic");
                isLegal = false;
            }
            if(!isLegal){
                // invalidation and delete it
                newFile.delete();
                return null;
            }
            return fileName;
        }else{
            return null;
        }
    }
}
