package com.sbnz.timemanagementadvisor.repository;

import com.sbnz.timemanagementadvisor.model.DayTemplate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayTemplateRepository extends MongoRepository<DayTemplate, ObjectId> {

}
