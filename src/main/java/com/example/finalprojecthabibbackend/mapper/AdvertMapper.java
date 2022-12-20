package com.example.finalprojecthabibbackend.mapper;

import com.example.finalprojecthabibbackend.dto.request.AdvertRequestDto;
import com.example.finalprojecthabibbackend.dto.response.AdvertResponseDto;
import com.example.finalprojecthabibbackend.model.entity.Advert;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AdvertMapperImpl", componentModel = "spring")
public interface AdvertMapper {

    AdvertResponseDto toAdvertDto(Advert advert);

    Advert toAdvertFromCreateAdvertRequest(AdvertRequestDto advertRequestDto);

}
