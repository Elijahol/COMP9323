package com.vport.system.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vport.system.bean.PlanTree;
import com.vport.system.mapper.PlanTypeMapper;
import com.vport.system.pojo.PlanType;
import com.vport.system.service.PlanService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Service
public class PlanServiceImpl implements PlanService {
    
    @Autowired
    private PlanTypeMapper planTypeMapper;
    
    private PlanType searchChilren(PlanType planType, Map<Long, List<PlanType>> typeMap) {
        if (typeMap.get(planType.getId())!=null) {
            List<PlanType> chilren = typeMap.get(planType.getId());
            for (PlanType child : chilren) {
                child.setChlidren(new ArrayList<PlanType>());
                planType.getChlidren().add(searchChilren(child, typeMap));
            }
        }
        return planType;
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
            List<PlanType> types = planTypeMapper.select(null);
            Map<Long, List<PlanType>> typeMap = new HashMap<Long, List<PlanType>>();
            for (PlanType planType : types) {
                if(!typeMap.containsKey(planType.getParentId())){
                    typeMap.put(planType.getParentId(), new ArrayList<PlanType>());
                }
                typeMap.get(planType.getParentId()).add(planType);
            }
            List<PlanType> list = typeMap.get(0L);
            for (PlanType planType : list) {
                planType.setChlidren(new ArrayList<PlanType>());
                planType = searchChilren(planType,typeMap);
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
    
  

   
    
    
}
