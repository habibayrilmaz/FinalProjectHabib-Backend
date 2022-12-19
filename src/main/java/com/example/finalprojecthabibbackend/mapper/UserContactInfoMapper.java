package com.example.finalprojecthabibbackend.mapper;

import com.example.finalprojecthabibbackend.dto.request.UserContactInfoRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserContactInfoResponseDto;
import com.example.finalprojecthabibbackend.model.entity.UserContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "UserContactInfoMapperImpl", componentModel = "spring")
public interface UserContactInfoMapper {

    UserContactInfo toUserContactInfo(UserContactInfoRequestDto userContactInfoRequestDto);

    @Mapping(source = "user.id", target = "userId")
    UserContactInfoResponseDto toUserContactInfoDto(UserContactInfo userContactInfo);

    UserContactInfo toUserContactInfoFromCreateUserContactInfoRequest(UserContactInfoRequestDto userContactInfoRequestDto);

    List<UserContactInfoResponseDto> toUserContactInfoDTOs(List<UserContactInfo> userContactInfoList);
}
