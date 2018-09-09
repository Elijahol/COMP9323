package com.vport.system.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vport.system.bean.MakeTrainingPlan;
import com.vport.system.bean.PlanTree;
import com.vport.system.mapper.PlanMapper;
import com.vport.system.pojo.PhysicalContent;
import com.vport.system.pojo.PhysicalDetail;
import com.vport.system.pojo.PhysicalDetailNonSpecilized;
import com.vport.system.pojo.PhysicalDetailSpecilized;
import com.vport.system.pojo.PlanType;
import com.vport.system.pojo.SkillDetail;
import com.vport.system.pojo.SkillDetailWithFullInfo;
import com.vport.system.pojo.TrainingPlan;
import com.vport.system.pojo.TrainingPlanInfo;
import com.vport.system.service.PlanService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Service
public class PlanServiceImpl implements PlanService {
    
    @Autowired
    private PlanMapper planMapper;
    
    
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
            List<PlanType> types = planMapper.selectTypeWithUnit();
            Map<Long, List<PlanType>> typeMap = new HashMap<Long, List<PlanType>>();
            for (PlanType planType : types) {
                if(!typeMap.containsKey(planType.getParentId())){
                    typeMap.put(planType.getParentId(), new ArrayList<PlanType>());
                }
                typeMap.get(planType.getParentId()).add(planType);
            }
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

    @Override
    public void makeNewPlan(MakeTrainingPlan newPlan) {

        TrainingPlan plan = newPlan.getPlan();
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
    }
    
    public TrainingPlanInfo getTrainingPlanInfo(Long schemaId){
        
        TrainingPlanInfo trainingPlanInfo = planMapper.selectPlanInfoById(schemaId);
         
        setPhysicalContent(schemaId, trainingPlanInfo);
        
        setSkillContent(schemaId, trainingPlanInfo);
        return trainingPlanInfo;
    }

    

    
    
  

   
    
    
}
