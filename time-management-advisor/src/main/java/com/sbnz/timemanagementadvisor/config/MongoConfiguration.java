package com.sbnz.timemanagementadvisor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "time-management-advisor";
    }

    @Bean
    @Override
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new MongoLocalDateTimeFromStringConverter());
        converterList.add(new MongoLocalTimeFromStringConverter());
        converterList.add(new MongoLocalDateFromStringConverter());
        converterList.add(new MongoLocalDateTimeToStringConverter());
        converterList.add(new MongoLocalTimeToStringConverter());
        converterList.add(new MongoLocalDateToStringConverter());
        return new MongoCustomConversions(converterList);
    }

    private static final class MongoLocalDateTimeFromStringConverter implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(String source) {
            return LocalDateTime.parse(source);
        }
    }
    private static final class MongoLocalTimeFromStringConverter implements Converter<String, LocalTime> {
        @Override
        public LocalTime convert(String source) {
            return LocalTime.parse(source);
        }
    }
    private static final class MongoLocalDateFromStringConverter implements Converter<String, LocalDate> {
        @Override
        public LocalDate convert(String source) {
            return LocalDate.parse(source);
        }
    }

    private static final class MongoLocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {
        @Override
        public String convert(LocalDateTime source) {
            return source.toString();
        }
    }
    private static final class MongoLocalTimeToStringConverter implements Converter<LocalTime, String> {
        @Override
        public String convert(LocalTime source) {
            return source.toString();
        }
    }
    private static final class MongoLocalDateToStringConverter implements Converter<LocalDate, String> {
        @Override
        public String convert(LocalDate source) {
            return source.toString();
        }
    }
}