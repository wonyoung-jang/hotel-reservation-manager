package com.wjang.hotel_reservation_manager.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ApiConfig implements  WebMvcConfigurer{

//Not needing the object member is a change in recent versions of spring.

//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.registerModule(new JavaTimeModule());
//
//
//        return new ObjectMapper();
//    }
//
//    @Bean
//    public ObjectWriter objectWriter(ObjectMapper objectMapper) {
//        return objectMapper.writerWithDefaultPrettyPrinter();
//    }
}
