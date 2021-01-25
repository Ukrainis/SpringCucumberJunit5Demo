package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.test.context.support.DefaultActiveProfilesResolver;

public class SpringActiveProfileResolver extends DefaultActiveProfilesResolver {
    
    private final String springProfileActiveWithDot = "spring.profiles.active";
    private final String springProfilesActiveWithUnderscore = "spring_profiles_active";

    public String[] resolve(Class<?> testClass) {
        String[] resolve = super.resolve(testClass);
        if (ArrayUtils.isEmpty(resolve)) {
            Map<String, String> systemProperties = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            systemProperties.putAll(new HashMap(System.getProperties()));
            if (systemProperties.containsKey(springProfileActiveWithDot) || 
                systemProperties.containsKey(springProfilesActiveWithUnderscore)) {
                    if (systemProperties.containsKey(springProfileActiveWithDot)) {
                        resolve = systemProperties.get(springProfileActiveWithDot).split(",");
                    } else {
                        resolve = systemProperties.get(springProfilesActiveWithUnderscore).split(",");
                    }
                }
        }
        if (resolve.length == 0) {
            resolve = new String[] {"prod"};
        }
        return resolve;
    }
}
