package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.model.User;
import com.sbnz.timemanagementadvisor.repository.UserRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final KieContainer kieContainer;

    public User classify(User user) {
        KieSession kieSession = kieContainer.newKieSession("ksession-plan-day");
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();
        return user;
    }

}
