package com.jb;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.jb")
@PropertySource("classpath:bakery.properties")
public class BakeryConfiguration {
}
