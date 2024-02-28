package HotelReservationManager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import HotelReservationManager.convertor.ReservationEntityToReservationResponseConverter;
import HotelReservationManager.convertor.ReservationRequestToReservationEntityConverter;
import HotelReservationManager.convertor.RoomEntityToReservableRoomResponseConverter;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

        @Autowired
        ApplicationContext context;

        private Set<Converter<?, ?>> getConverters() {
                Set<Converter<?, ?>> converters = new HashSet<Converter<?, ?>>();
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

                // Add type parameter to ensure type safety
                Set<Converter<?, ?>> converters = getConverters();
                bean.setConverters(converters);

                bean.afterPropertiesSet();

                return bean.getObject();
        }
}
