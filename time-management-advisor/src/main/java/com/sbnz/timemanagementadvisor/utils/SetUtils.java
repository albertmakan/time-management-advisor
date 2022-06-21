package com.sbnz.timemanagementadvisor.utils;

import java.util.Set;

public class SetUtils {
    public static boolean haveCommon(Set<?> set1, Set<?> set2) {
        return set1.stream().anyMatch(set2::contains);
    }
}
