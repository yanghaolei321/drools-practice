package com.galaxy.droolspractice.middleware.executor;

import com.alibaba.fastjson.JSON;
import com.galaxy.droolspractice.api.model.engine.BaseFact;
import com.galaxy.droolspractice.api.model.engine.FactBean;
import com.galaxy.droolspractice.api.model.engine.RuleExecuteGlobal;
import com.galaxy.droolspractice.api.model.engine.RuleExecutorResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Service;

/**
 * 引擎层-规则匹配-Service
 *
 * @author yanghaolei
 * @date 9/14/21 7:33 PM
 */
@Slf4j
public class RuleExecutor {

    private static volatile KieBase kieBase = null;
    private static ReleaseId releaseId =
        new ReleaseIdImpl("com.galaxy.droolspractice", "drools-drt", "1.0");


    /**
     * 获取kieBase
     *
     * @return
     */
    public static KieBase getKieBase() {
        if (kieBase == null) {
            synchronized (KieBase.class) {
                if (kieBase == null) {
                    KieServices kieServices = KieServices.Factory.get();
                    KieContainer kieContainer = kieServices.newKieContainer(getReleaseId());
                    kieBase = kieContainer.getKieBase();
                }
            }
        }
        return kieBase;
    }


    /**
     * 执行层
     *
     * @param fact fact对象
     * @return RuleExecutorResult
     */
    public static RuleExecutorResult execute(FactBean fact) {
        log.info("RuleExecutor|execute|fact={}", JSON.toJSON(fact));
        StatelessKieSession statelessKieSession = getKieBase().newStatelessKieSession();
        RuleExecuteGlobal global = new RuleExecuteGlobal();
        global.setFactBean(fact);
        global.setResult(new RuleExecutorResult());
        statelessKieSession.getGlobals().set("globalParams", global);
        statelessKieSession.execute(fact);
        return global.getResult();
    }

    public static ReleaseId getReleaseId() {
        return releaseId;
    }

}
