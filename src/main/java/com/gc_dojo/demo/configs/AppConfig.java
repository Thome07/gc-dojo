package com.gc_dojo.demo.configs;

import jakarta.annotation.PostConstruct;

import java.util.TimeZone;

public class AppConfig {
    @PostConstruct
    public void timeZoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}