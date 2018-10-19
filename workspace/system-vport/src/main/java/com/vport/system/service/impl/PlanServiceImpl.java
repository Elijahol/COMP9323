package com.vport.system.service.impl;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.vport.system.bean.MakeTrainingPlan;
import com.vport.system.bean.PlanTree;
import com.vport.system.mapper.InfoMapper;
import com.vport.system.mapper.PlanMapper;
import com.vport.system.pojo.training.PhysicalContent;
import com.vport.system.pojo.training.PhysicalDetail;
import com.vport.system.pojo.training.PhysicalDetailNonSpecilized;
import com.vport.system.pojo.training.PhysicalDetailSpecilized;
import com.vport.system.pojo.training.PlanType;
import com.vport.system.pojo.training.SkillDetail;
import com.vport.system.pojo.training.SkillDetailWithFullInfo;
import com.vport.system.pojo.training.TrainingPlan;
import com.vport.system.pojo.training.TrainingPlanInfo;
import com.vport.system.service.InfoService;
import com.vport.system.service.PlanService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
/**
 * This Class is an implementation of the interface PlanService.
 * The main function of this class is to complete the business logic 
 * relating to training plan including add, get the plan framework, 
 * get a specific plan detail and so on
 * @author Siyu Wang
 *
 */
@Service
public class PlanServiceImpl implements PlanService {
    
    @Autowired
    private PlanMapper planMapper;
    /**
     * infoService injection
     * The purpose of using infoService is to send the notification
     * after the relevant operation
     */
    @Autowired
    private InfoService infoService;
    
    
    
    /**
     * Get the tree structure of the plan types
     * by using depth first search
     */
    public PlanTree getPlanTree(){
        /**
         * Using the cache to store the plan types
         * to avoid frequently access to the database.
         * Firstly, if the container of the Ehcache has the plan types,
         * the method will directly return the data.
         * Secondly, if the container does not have the data,
         * apply the algorithm to get and format the data.
         */
        PlanTree result = null;
        CacheManager cacheManager = CacheManager.create(PlanServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        Cache cache = cacheManager.getCache("planTypeCache");
        //check if the cache has the data 
        Element element = cache.get("planTree");
        if (element == null) {
            System.out.println("no cache,access the database=======");
            result = new PlanTree();
            //Get all plan types
            List<PlanType> types = planMapper.selectTypeWithUnit();
            //key=parentid, value=chlidrenList
            //put each plan type into the map with parent id as the key
            Map<Long, List<PlanType>> typeMap = new HashMap<Long, List<PlanType>>();
            for (PlanType planType : types) {
                if(!typeMap.containsKey(planType.getParentId())){
                    typeMap.put(planType.getParentId(), new ArrayList<PlanType>());
                }
                typeMap.get(planType.getParentId()).add(planType);
            }
            //get the root elements of the plan tree
            List<PlanType> list = typeMap.get(0L);
            for (PlanType planType : list) {
                planType.setChildren(new ArrayList<PlanType>());
                //DFS
                //using the private method "searchChildren" to get the children of each node 
                planType = searchChildren(planType,typeMap);
                result.getData().add(planType);
            }
            element = new Element("planTree", result);
            cache.put(element);
        }else{
            System.out.println("has cache，not access the database=======");
            result = (PlanTree) element.getObjectValue();
        }
        
        return result;
    }
    /**
     * make a new plan.
     * store the data into relevant tables of the database.
     * 
     */
    @Override
    public void makeNewPlan(MakeTrainingPlan newPlan) {

        TrainingPlan plan = newPlan.getPlan();
        plan.setCreated(new Date());
        planMapper.insertNewPlan(plan);
        
        List<PhysicalDetail> physicalDetails = newPlan.getPhysicalDetails();
        for (PhysicalDetail physicalDetail : physicalDetails) {
            planMapper.insertPhysicalDetail(physicalDetail);
            planMapper.insertPhysicalSchemaDetail(plan.getId(),physicalDetail.getId());
        }
        
        List<SkillDetail> skillDetails = newPlan.getSkillDetails();
        for (SkillDetail skillDetail : skillDetails) {
            planMapper.insertSkillDetail(skillDetail);
            planMapper.insertSkillSchemaDetail(plan.getId(), skillDetail.getId());
        }
        infoService.addNewPlanInfoToStu(plan.getId(), plan.getClassId());
    }
    /**
     * Get the specific plan detail according to the plan id.
     * 
     */
    public TrainingPlanInfo getTrainingPlanInfo(Long schemaId){
        
        TrainingPlanInfo trainingPlanInfo = planMapper.selectPlanInfoById(schemaId);
         
        setPhysicalContent(schemaId, trainingPlanInfo);
        
        setSkillContent(schemaId, trainingPlanInfo);
        return trainingPlanInfo;
    }
    /**
     * Get the closest future plan according to the class id
     */
    @Override
    public TrainingPlan getClosestPlan(Long classId) {
        List<TrainingPlan> list = planMapper.findFuturePlan(classId);
        if (list.isEmpty()) {
            return null;
        }
        TrainingPlan trainingPlan = list.get(0);
        Date trainingTime = trainingPlan.getTrainingTime();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm EEEE",Locale.ENGLISH);
        trainingPlan.setTrainingDate(sdf.format(trainingTime));
        return trainingPlan;
    }

    
    private PlanType searchChildren(PlanType planType, Map<Long, List<PlanType>> typeMap) {
        if (typeMap.get(planType.getId())!=null) {
            List<PlanType> children = typeMap.get(planType.getId());
            for (PlanType child : children) {
                child.setChildren(new ArrayList<PlanType>());
                planType.getChildren().add(searchChildren(child, typeMap));
            }
        }
        return planType;
    }
    
    private void setPhysicalContent(Long schemaId, TrainingPlanInfo trainingPlanInfo) {
        //Physical content
        PhysicalContent physicalPart = new PhysicalContent();
        //Warm up part
        List<PhysicalDetailNonSpecilized> warmUp = planMapper.selectWarmUpBySchemaId(schemaId);
        physicalPart.setWarmUp(warmUp);
        
        //Specialized part
        
        List<PhysicalDetailSpecilized> specializedTrainingInit = planMapper.selectSpecilizedBySchemaId(schemaId);
        Map<String,List<PhysicalDetailSpecilized>> specializedTraining = new HashMap<String,List<PhysicalDetailSpecilized>>();
        for (PhysicalDetailSpecilized physicalDetailSpecilized : specializedTrainingInit) {
            String parentName = physicalDetailSpecilized.getParentName();
            if (!specializedTraining.containsKey(parentName)) {
                List<PhysicalDetailSpecilized> list = new ArrayList<PhysicalDetailSpecilized>();
                list.add(physicalDetailSpecilized);
                specializedTraining.put(parentName, list);
            }else{
                specializedTraining.get(parentName).add(physicalDetailSpecilized);
            }
        }
        physicalPart.setSpecializedTraining(specializedTraining);
        //Relaxation
        List<PhysicalDetailNonSpecilized> relaxiation = planMapper.selectRelaxiationBySchemaId(trainingPlanInfo.getId());
        physicalPart.setRelaxiation(relaxiation);
        trainingPlanInfo.setPhysicalPart(physicalPart);
    }
    
    private void setSkillContent(Long schemaId, TrainingPlanInfo trainingPlanInfo) {
        List<SkillDetailWithFullInfo> list = planMapper.selectSkillDetailWithFullInfo(schemaId);
        Map<String, List<SkillDetailWithFullInfo>> map = new HashMap<String, List<SkillDetailWithFullInfo>>();
        for (SkillDetailWithFullInfo skillDetailWithFullInfo : list) {
            String parentName = skillDetailWithFullInfo.getParentName();
            if (!map.containsKey(parentName)) {
                List<SkillDetailWithFullInfo> newList = new ArrayList<SkillDetailWithFullInfo>();
                newList.add(skillDetailWithFullInfo);
                map.put(parentName, newList);
            }else{
                map.get(parentName).add(skillDetailWithFullInfo);
            }
        }
        trainingPlanInfo.setSkillPart(map);
    }
    
    
  

   
    
    
}
