package com.wjang.hotel_reservation_manager.config;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.wjang.hotel_reservation_manager.convertor.ReservationEntityToReservationResponseConverter;
import com.wjang.hotel_reservation_manager.convertor.ReservationRequestToReservationEntityConverter;
import com.wjang.hotel_reservation_manager.convertor.RoomEntityToReservableRoomResponseConverter;

@Configuration
public class ConversionConfig {

        @Autowired
        ApplicationContext context;

        @SuppressWarnings("rawtypes")
        private Set<Converter> getConverters() {
                Set<Converter> converters = new HashSet<Converter>();
                converters.add(new RoomEntityToReservableRoomResponseConverter());
                converters.add(new ReservationRequestToReservationEntityConverter(context));
                converters.add(new ReservationEntityToReservationResponseConverter());

                return converters;
        }

        @SuppressWarnings("null")
        @Bean
        public ConversionService conversionService() {
                ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
                bean.setConverters(getConverters());
                bean.afterPropertiesSet();

                return bean.getObject();
        }
}
