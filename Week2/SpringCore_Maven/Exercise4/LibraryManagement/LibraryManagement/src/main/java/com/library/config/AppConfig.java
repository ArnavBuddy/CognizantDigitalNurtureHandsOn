package com.library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Central Spring configuration for the Library Management application.
 * Enables component scanning and AspectJ-based AOP proxying.
 */
@Configuration
@ComponentScan(basePackages = "com.library")
@EnableAspectJAutoProxy
public class AppConfig {
}
