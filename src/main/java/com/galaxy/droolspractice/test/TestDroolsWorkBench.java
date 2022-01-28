package com.galaxy.droolspractice.test;

import cn.hutool.core.util.RandomUtil;
import com.galaxy.droolspractice.api.entity.AdsCrmBrandRelation;
import com.google.common.collect.Lists;
import com.myteam.demo3.Car;
import com.myteam.demo3.FeatureDataObject;
import com.myteam.demo3.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.server.api.marshalling.MarshallingFormat;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类的描述
 *
 * @author yanghaolei
 * @date 2021/11/30 11:13 上午
 */

public class TestDroolsWorkBench {


    private static final String URL = "http://localhost:8080/kie-server/services/rest/server";
    private static final String USER = "kieserver";
    private static final String PASSWORD = "kieserver1!";

    private static final MarshallingFormat FORMAT = MarshallingFormat.JSON;


    public static void main(String[] args) throws IOException {
        TestDroolsWorkBench testWB = new TestDroolsWorkBench();
//        testWB.testConsume();
        testWB.testScanner();
    }


    @Test
    public void testScanner() {
        KieServices ks = KieServices.Factory.get();
        ReleaseId releaseId = ks.newReleaseId("com.myteam", "Demo3", "1.0.0-SNAPSHOT");
        KieContainer kieContainer = ks.newKieContainer(releaseId);
        KieScanner kieScanner = ks.newKieScanner(kieContainer);
        kieScanner.start(10000L);
        while (true) {
            try {
                KieSession kieSession = kieContainer.newKieSession();
                Car c = new Car();
                c.setCarNumber("ss");
                c.setIsRight(Boolean.FALSE);
                System.out.println(" 执行前 " + c.getCarNumber() + " 此时的状态: " + c.getIsRight());
                kieSession.insert(c);
                int i = kieSession.fireAllRules();
                System.out.println("执行了" + i + "条规则" + "\n");
                System.out.println(" 执行后 车牌号：  " + c.getCarNumber() + " 此时的状态: " + c.getIsRight());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

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
        KieServices ks = KieServices.Factory.get();
        ReleaseId releaseId = ks.newReleaseId("com.myteam", "Demo3", "1.0.0-SNAPSHOT");
        KieContainer kieContainer = ks.newKieContainer(releaseId);
        KieScanner kieScanner = ks.newKieScanner(kieContainer);
        kieScanner.start(10000L);

        try {
            KieSession kieSession = kieContainer.newKieSession();
            for (FeatureDataObject obj : featureDataObjectList) {
                kieSession.insert(obj);
            }
            int i = kieSession.fireAllRules();
            System.out.println("执行了" + i + "条规则" + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4 处理
        for (FeatureDataObject obj : featureDataObjectList) {
            if (1 == obj.getProcessFlag()) {
                System.out.println("处理 + " + obj.getId());
            }
        }

    }

    @Test
    public void testDrl() {
        KieServices ks = KieServices.Factory.get();
        ReleaseId releaseId = ks.newReleaseId("com.myteam", "Demo3", "1.0.0-SNAPSHOT");
        KieContainer kieContainer = ks.newKieContainer(releaseId);
        KieScanner kieScanner = ks.newKieScanner(kieContainer);
        kieScanner.start(10000L);

        try {
            KieSession kieSession = kieContainer.newKieSession();
            Person p = new Person();
             p.setName("1");
            System.out.println(" 执行前 " + p.getName());
            kieSession.insert(p);
            int i = kieSession.fireAllRules();
            System.out.println("执行了" + i + "条规则" + "\n");
            System.out.println(" 执行后 " + p.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
