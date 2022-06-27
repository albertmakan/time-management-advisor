package com.sbnz.timemanagementadvisor.repository;

import com.sbnz.timemanagementadvisor.model.Activity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, ObjectId> {
    List<Activity> findAllByIsArchivedFalseAndIsDoneFalse();
    List<Activity> findAllByIsArchivedTrue();
    List<Activity> findAllByIsDoneTrue();
}
