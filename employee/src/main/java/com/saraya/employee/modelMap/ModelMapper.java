package com.saraya.employee.modelMap;

//import java.time.LocalDate;
//
//import org.modelmapper.Converter;
//import org.modelmapper.Provider;


public class ModelMapper {

	ModelMapper modelmapper = new ModelMapper();
//
//    Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {
//        @Override
//        public LocalDate get() {
//            return LocalDate.now();
//        }
//    };
//
//    Converter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
//        @Override
//        protected LocalDate convert(String source) {
//            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDate localDate = LocalDate.parse(source, format);
//            return localDate;
//        }s
//    }
//
//
////    modelmapper.createTypeMap(String.class, LocalDate.class);
////    modelmapper.addConverter(toStringDate);
////    modelmapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);
}
