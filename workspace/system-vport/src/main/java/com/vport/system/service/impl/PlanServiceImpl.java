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

@Service
public class PlanServiceImpl implements PlanService {
    
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private InfoService infoService;
    
    
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
        //体能类
        PhysicalContent physicalPart = new PhysicalContent();
        //热身
        List<PhysicalDetailNonSpecilized> warmUp = planMapper.selectWarmUpBySchemaId(schemaId);
        physicalPart.setWarmUp(warmUp);
        
        //专项训练
        
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
        //放松
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
    /**
     * 获取训练计划树形结构
     */
    public PlanTree getPlanTree(){
        /**
         * 使用缓存优化程序，先从缓存中获取数据
         *      获取到：直接返回
         *      获取不到，再去查数据库，存到缓存中
         */
        PlanTree result = null;
        CacheManager cacheManager = CacheManager.create(PlanServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        Cache cache = cacheManager.getCache("planTypeCache");
        //判断缓存中是否有集合
        Element element = cache.get("planTree");
        if (element == null) {
            System.out.println("没有缓存，查询数据库=======");
            result = new PlanTree();
            //所有的训练内容
            List<PlanType> types = planMapper.selectTypeWithUnit();
            //key=parentid, value=chlidrenList
            Map<Long, List<PlanType>> typeMap = new HashMap<Long, List<PlanType>>();
            for (PlanType planType : types) {
                if(!typeMap.containsKey(planType.getParentId())){
                    typeMap.put(planType.getParentId(), new ArrayList<PlanType>());
                }
                typeMap.get(planType.getParentId()).add(planType);
            }
            //得到最顶层的两个训练项目：体能和技战术
            List<PlanType> list = typeMap.get(0L);
            for (PlanType planType : list) {
                planType.setChildren(new ArrayList<PlanType>());
                planType = searchChildren(planType,typeMap);
                result.getData().add(planType);
            }
            element = new Element("planTree", result);
            cache.put(element);
        }else{
            System.out.println("有缓存，没有查询数据库=======");
            result = (PlanTree) element.getObjectValue();
        }
        
        return result;
    }
    /**
     * 创建新的训练计划
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
     * 根据训练计划id提取训练计划内容
     */
    public TrainingPlanInfo getTrainingPlanInfo(Long schemaId){
        
        TrainingPlanInfo trainingPlanInfo = planMapper.selectPlanInfoById(schemaId);
         
        setPhysicalContent(schemaId, trainingPlanInfo);
        
        setSkillContent(schemaId, trainingPlanInfo);
        return trainingPlanInfo;
    }

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

    

    
    
  

   
    
    
}
