package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.model.StopwatchEvent;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {
    @Autowired @Qualifier("eventsSession")
    private KieSession eventsSession;

    public void insertEvent() {
        eventsSession.insert(new StopwatchEvent());
        eventsSession.fireUntilHalt();
    }
}
