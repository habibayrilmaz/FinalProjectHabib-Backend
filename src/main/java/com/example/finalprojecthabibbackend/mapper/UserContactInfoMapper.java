package com.example.finalprojecthabibbackend.mapper;

import com.example.finalprojecthabibbackend.dto.request.UserContactInfoRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserContactInfoResponseDto;
import com.example.finalprojecthabibbackend.model.entity.UserContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "UserContactInfoMapperImpl", componentModel = "spring")
public interface UserContactInfoMapper {

    @Mapping(source = "user.id", target = "userId")
    UserContactInfoResponseDto toUserContactInfoDto(UserContactInfo userContactInfo);

    UserContactInfo toUserContactInfoFromCreateUserContactInfoRequest(UserContactInfoRequestDto userContactInfoRequestDto);
}
