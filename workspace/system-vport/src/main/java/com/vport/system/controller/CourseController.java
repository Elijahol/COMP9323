package com.vport.system.controller;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vport.system.bean.CourseTime;
import com.vport.system.bean.MakeTrainingPlan;
import com.vport.system.bean.PlanTree;
import com.vport.system.bean.ResponseData;
import com.vport.system.pojo.ClassInfoForStu;
import com.vport.system.pojo.TrainingClassToDisPlay;
import com.vport.system.pojo.person.User;
import com.vport.system.pojo.training.TrainingClass;
import com.vport.system.pojo.training.TrainingClassInfo;
import com.vport.system.pojo.training.TrainingPlan;
import com.vport.system.pojo.training.TrainingPlanInfo;
import com.vport.system.service.CourseService;
import com.vport.system.service.PlanService;
import com.vport.system.service.UserService;
import com.vport.system.utils.UUIDUtils;

@Controller
@RequestMapping("course")
public class CourseController {
    
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
    private PlanService planService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private UserService userService;
    
    
    
    @RequestMapping(value="toEachPlan",method=RequestMethod.GET)
    public String returnEachPlanPage(Long id, Model model){
        model.addAttribute("schemaId", id);
        return "planDetail";
    }
    
    /**
     * 根据schemaId得到训练计划详细
     * @param id
     * @return
     */
    @RequestMapping(value="eachPlan",method = RequestMethod.GET)
    @ResponseBody
    public TrainingPlanInfo getEachPlan(Long id){
        TrainingPlanInfo trainingPlanInfo = planService.getTrainingPlanInfo(id);
        
        return trainingPlanInfo;
    }
    
    
    /**
     * 返回制定训练计划页面
     * @param classId
     * @param model
     * @return
     */
    @RequestMapping(value = "returnPlan",method = RequestMethod.GET)
    public String returnPlan(Long classId,Model model){
        User trainer = (User) session.getAttribute("existUser");
        model.addAttribute("classId", classId);
        model.addAttribute("chiefTrainer", trainer.getId());
        return "makePlan";
    }
    
    /**
     * 得到训练计划数据及班级上课时间
     * @param classId
     * @return
     */
    @RequestMapping(value="planTree",method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getPlanTree(Long classId){
        PlanTree planTree = planService.getPlanTree();
        List<CourseTime> list = courseService.getClassTimeByClassId(classId);
        List<Object> data = new ArrayList<>();
        data.add(planTree.getData());
        data.add(list);
        return data;
    }
    
    /**
     * 新增一个训练计划
     */
    @RequestMapping(value = "addNewPlan",method = RequestMethod.POST)
    @ResponseBody
    public String addNewPlan(@RequestBody MakeTrainingPlan newPlan){
        try{
            planService.makeNewPlan(newPlan);
            return "1";
        }catch (Exception e) {
            return "0";
        }
        
    }
    
    
    /**
     * 获得教练页面的班级信息
     * @return
     */
    @RequestMapping(value="classInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<TrainingClassInfo> getClassInfo(){
        User trainer = (User) session.getAttribute("existUser");
        if (trainer == null) {
            trainer = new User();
            trainer.setId(1L);
        }
        List<TrainingClassInfo> classInfo = courseService.getClassInfo(trainer);
        return classInfo;
    }
    
    @RequestMapping(value = "classInfoForStu",method = RequestMethod.GET)
    @ResponseBody
    public List<ClassInfoForStu> classInfoForStu(){
        User player = (User) session.getAttribute("existUser");
        List<ClassInfoForStu> list = courseService.getClassInfoForStu(player);
        return list;
    }
    
    /**
     * 查询所有教练
     * @return
     */
    @RequestMapping(value="getTrainerList",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getTrainerList(){
        List<User> trainers = userService.findTrainer();
        return trainers;
    }
    
    /**
     * 根据班级Id得到班级相关信息
     * @param classId
     * @return
     */
    @RequestMapping(value="classInfoByClassId",method = RequestMethod.GET)
    public String getClassInfoByClassId(Long classId,Model model){
        TrainingClassInfo classInfo = courseService.getClassInfoByClassId(classId);
        model.addAttribute("classInfo", classInfo);
        return "courseDetails";
    }
    
    @RequestMapping(value="classInfoByClassIdForStu",method = RequestMethod.GET)
    public String getClassInfoByClassIdForStu(Long classId,Model model){
        ClassInfoForStu classInfoForStu = courseService.getClassInfoByClassIdForStu(classId);
        model.addAttribute("classInfo", classInfoForStu);
        return "stuCourseDetals";
    }
    
    
    @RequestMapping(value="timeTable",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTimeTable(Long id){
        User user = (User) session.getAttribute("existUser");
        Map<String, Object> timeTable = courseService.getTimeTable(id,user.getRole());
        return timeTable;
    }
    
    
    /**
     * 上传班级图片
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="uploadFile",method = RequestMethod.POST,consumes = {"multipart/form-data"})
    @ResponseBody
    public String uploadFile(Map<String, Object> model) throws Exception{
        MultipartHttpServletRequest murequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = murequest.getFileMap();
        String fileName = null;
        for (MultipartFile multipartFile : fileMap.values()) {
            fileName = checkTheFile(multipartFile);
        }
        return fileName;
        
    }
    
    /**
     * 添加课程信息
     * @param trainingClass
     * @param hourTo1
     * @param hourTo2
     * @param period
     * @param trainer
     * @param title
     * @return
     */
    @RequestMapping(value="addCourse",method=RequestMethod.POST)
    public String addCourse(TrainingClass trainingClass,String ageRange1,String ageRange2,
                            String hourTo1,String hourTo2,String[] period,Long trainer,String title){
        String per = String.join("-", period);
        trainingClass.setPeriod(per);
        String hourTo = hourTo1 + "-" + hourTo2;
        trainingClass.setHourTo(hourTo);
        trainingClass.setClassName(title);
        trainingClass.setAgeRange(ageRange1+"-"+ageRange2);
        courseService.addCourse(trainingClass,trainer);
        
        return "redirect:/rest/page/addCourse";
    }
    
    /**
     * 查看当前开班的信息
     * @return
     */
    @RequestMapping(value="showOpenCourse",method = RequestMethod.GET)
    public String showOpenCourse(Model model){
        List<TrainingClassToDisPlay> courses = courseService.getOpenCourse();
        model.addAttribute("courses", courses);
        return "courseListPage";
    }
    /**
     * 获取具体某一个班级的宣传信息
     * @param classId
     * @return
     */
    @RequestMapping(value="showOpenCourseDetail",method = RequestMethod.GET)
    public String showOpenCourseDetail(Long classId,Model model){
        TrainingClassToDisPlay course = courseService.getOpenCourseDetail(classId);
        User sessionUser = (User) session.getAttribute("existUser");
        boolean flag = false;
        for(User stu:course.getStudents()){
            if (stu.getId() == sessionUser.getId()) {
                flag = true;
            }
        }
        model.addAttribute("course", course);
        if (flag) {
            model.addAttribute("hasAdd", "1");
        }
        return "courseAdDetail";
    }
    /**
     * 学生申请加入课程
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value="joinTheClass",method=RequestMethod.POST)
    @ResponseBody
    public ResponseData joinTheClass(Long classId) throws ParseException {
        User stu = (User) session.getAttribute("existUser");
        
        return courseService.joinTheClass(stu,classId);
    }
    /**
     * 获得最近的未来训练计划
     * @param pictureFile
     * @return
     * @throws Exception
     */
    @RequestMapping(value="closestPlan",method = RequestMethod.GET)
    @ResponseBody
    public TrainingPlan getClosestPlan(Long classId){
        TrainingPlan plan =  planService.getClosestPlan(classId);
        return plan;
    }
    private String checkTheFile(MultipartFile pictureFile) throws Exception{
        //保存图片
        String fileName = UUIDUtils.getUUID();
          
        String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
          
        fileName = fileName+"."+extension;
        File newFile = new File("E:\\comp9323_pro\\file-upload\\"+fileName);
        pictureFile.transferTo(newFile);
        try{
             BufferedImage image = ImageIO.read(newFile);
             if (image != null) {
                int height = image.getHeight();
                int width = image.getWidth();
                System.out.println(height + "------------" + width);
             }
        }catch(IOException e){
              System.out.println("不是图片");
        }
        return fileName;
    }
}
