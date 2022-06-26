package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.exceptions.ConflictException;
import com.sbnz.timemanagementadvisor.model.User;
import com.sbnz.timemanagementadvisor.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final KieContainer kieContainer;

    public Optional<User> getUser() {
        return userRepository.findAll().stream().findFirst();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User create(User user) {
        getUser().ifPresent((u)-> {
            throw new ConflictException("Application supports only 1 user for now.");
        });
//        KieSession kieSession = kieContainer.newKieSession("ksession-plan-day");
//        kieSession.insert(user);
//        kieSession.fireAllRules();
//        kieSession.dispose();
        return save(user);
    }

}
