package com.example.mapper;

/**
 * @Author: w00990
 * @Date: 2020/12/14
 */

import com.example.dto.Car;
import com.example.dto.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);


    @Mapping(source = "numberOfSeats", target = "seatCount", numberFormat = "#.##E0")
    CarDto carToCarDto(Car car);
}
