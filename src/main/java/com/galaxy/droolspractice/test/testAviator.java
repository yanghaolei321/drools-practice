package com.galaxy.droolspractice.test;

import cn.hutool.core.util.RandomUtil;
import com.galaxy.droolspractice.api.entity.AdsCrmBrandRelation;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.myteam.demo3.FeatureDataObject;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类的描述
 *
 * @author yanghaolei
 * @date 2021/12/9 2:45 下午
 */

public class testAviator {


    @Test
    public void testConsume() {

        // 1 获取挂接关系
        List<AdsCrmBrandRelation> adsCrmBrandRelationList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            AdsCrmBrandRelation adsCrmBrandRelation = new AdsCrmBrandRelation()
                .setBrandSellerCode(RandomUtil.randomString(10)).setId(i);
            adsCrmBrandRelationList.add(adsCrmBrandRelation);
            System.out.println("获取到 ：  " + adsCrmBrandRelation);
        }

        // 2 提取数据特征
        List<FeatureDataObject> featureDataObjectList = adsCrmBrandRelationList.stream().map(adsCrmBrandRelation -> {
            FeatureDataObject featureDataObject = new FeatureDataObject();
            featureDataObject.setId(adsCrmBrandRelation.getId());
            featureDataObject.setConsumeOneYear(RandomUtil.randomInt(0, 100));
            featureDataObject.setInvalidOrderNumsForOneYear(RandomUtil.randomInt(0, 100));
            featureDataObject.setProcessFlag(0);
            System.out.println("提取数据特征 id ：  " + featureDataObject.getId() + " 过去一年消耗:"
                + featureDataObject.getConsumeOneYear()
                + " 有效订单: " + featureDataObject.getInvalidOrderNumsForOneYear() +
                "处理标识位：" + featureDataObject.getProcessFlag());
            return featureDataObject;
        }).collect(Collectors.toList());

        // 3 送入规则引擎
        featureDataObjectList.forEach(featureDataObject -> {
            Map<String,Object> paramMap= Maps.newHashMapWithExpectedSize(16);
            paramMap.put("featureDataObject",featureDataObject);
            String rule ="featureDataObject.consumeOneYear > 5 && featureDataObject.invalidOrderNumsForOneYear  <=20";
            Expression expression = AviatorEvaluator.compile(rule);
            Boolean rst = (Boolean)expression.execute(paramMap);
            System.out.println(rst);//true
            if(Boolean.TRUE.equals(rst)){
                featureDataObject.setProcessFlag(1);
            }
        });

        // 4 处理
        for (FeatureDataObject obj : featureDataObjectList) {
            if (1 == obj.getProcessFlag()) {
                System.out.println("处理 + " + obj.getId());
            }
        }

    }
}
