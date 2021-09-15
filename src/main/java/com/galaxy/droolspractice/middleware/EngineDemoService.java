package com.galaxy.droolspractice.middleware;

import com.galaxy.droolspractice.api.model.engine.Politician;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * 引擎层-ShowDemo
 *
 * @author yanghaolei
 * @date 9/14/21 7:33 PM
 */

@Slf4j
@Service
@AllArgsConstructor
public class EngineDemoService {


    /**
     * 展示Drools的一个例子
     *
     * @return
     */
    public Boolean showDemo() {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());
        execute(kc);
        return Boolean.TRUE;
    }

    private void execute(KieContainer kc) {
        KieSession ksession = kc.newKieSession("HonestPoliticianKS");

        final Politician p1 = new Politician("President of Umpa Lumpa", true);
        final Politician p2 = new Politician("Prime Minster of Cheeseland", true);
        final Politician p3 = new Politician("Tsar of Pringapopaloo", true);
        final Politician p4 = new Politician("Omnipotence Om", true);

        ksession.insert(p1);
        ksession.insert(p2);
        ksession.insert(p3);
        ksession.insert(p4);

        ksession.fireAllRules();

        ksession.dispose();
    }
}
