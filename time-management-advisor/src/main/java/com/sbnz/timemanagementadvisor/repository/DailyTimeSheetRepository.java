package com.sbnz.timemanagementadvisor.repository;

import com.sbnz.timemanagementadvisor.model.DailyTimeSheet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DailyTimeSheetRepository extends MongoRepository<DailyTimeSheet, ObjectId> {
    Optional<DailyTimeSheet> findByDay(LocalDate day);
}
