package com.sbnz.timemanagementadvisor;

import com.sbnz.timemanagementadvisor.model.Activity;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CEPTests {

    @Test
    void test() {
        List<Activity> l = new ArrayList<>();
        Activity a2 = new Activity();
        a2.setId(new ObjectId());
        Activity a1 = new Activity();
        a1.setId(new ObjectId());
        ObjectId id= a1.getId();

        l.add(a2);
        l.add(a1);

        System.out.println(l.removeIf(a->a.getId()==id));
    }
}
