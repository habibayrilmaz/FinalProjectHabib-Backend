package com.example.finalprojecthabibbackend.mapper;

import com.example.finalprojecthabibbackend.dto.request.AdvertRequestDto;
import com.example.finalprojecthabibbackend.dto.response.AdvertResponseDto;
import com.example.finalprojecthabibbackend.model.entity.Advert;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "AdvertMapperImpl", componentModel = "spring")
public interface AdvertMapper {

    Advert toAdvert(AdvertRequestDto advertRequestDto);

    AdvertResponseDto toAdvertDto(Advert advert);

    Advert toAdvertFromCreateAdvertRequest(AdvertRequestDto advertRequestDto);

    List<AdvertResponseDto> toAdvertDTOs(List<Advert> advertList);
}
