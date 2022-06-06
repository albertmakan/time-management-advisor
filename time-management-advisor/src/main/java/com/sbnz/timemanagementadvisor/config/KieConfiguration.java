package com.sbnz.timemanagementadvisor.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KieConfiguration {

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(
                ks.newReleaseId("com.sbnz", "time-management-advisor-kjar", "0.0.1-SNAPSHOT")
        );
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(10_000);
        return kContainer;
    }

    @Bean(name = "eventsSession")
    public KieSession eventsSession() {
        return kieContainer().newKieSession("ksession-monitoring");
    }

}
