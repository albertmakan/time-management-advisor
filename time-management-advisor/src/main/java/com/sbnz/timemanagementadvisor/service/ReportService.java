package com.sbnz.timemanagementadvisor.service;

import com.sbnz.timemanagementadvisor.dto.ReportDTO;
import com.sbnz.timemanagementadvisor.dto.ReportRequest;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReportService {
    private final DailyTimeSheetService dailyTimeSheetService;
    private final KieContainer kieContainer;

    public List<ReportDTO> getReport(ReportRequest reportRequest) {
        List<ReportDTO> reportDTOS = new ArrayList<>();
        KieSession kieSession = kieContainer.newKieSession("ksession-reports");
        dailyTimeSheetService.getAll().forEach(kieSession::insert);
        String queryName = reportRequest.isByIds() ? "Report by ids" : "Report by types";

        for (QueryResultsRow result : kieSession.getQueryResults(queryName, reportRequest))
            reportDTOS.add(new ReportDTO(
                    (LocalDate) result.get("$day"),
                    (Set<String>) result.get("$titles"),
                    (Long) result.get("$duration")
            ));

        kieSession.dispose();

        return reportDTOS;
    }
}

