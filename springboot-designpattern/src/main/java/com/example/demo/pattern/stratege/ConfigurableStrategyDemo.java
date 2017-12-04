package com.example.demo.pattern.stratege;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

public class ConfigurableStrategyDemo {
    public static IService createService() {
        try {
            Properties prop = new Properties();
            String fileName = "config.properties";

            Resource resource = new ClassPathResource(fileName);

            prop.load(resource.getInputStream());
            String className = prop.getProperty("service");
            Class<?> cls = Class.forName(className);
            return (IService) cls.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        IService service = createService();
        service.action();
    }
}