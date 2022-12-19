package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.AdvertRequestDto;
import com.example.finalprojecthabibbackend.dto.response.AdvertResponseDto;
import com.example.finalprojecthabibbackend.exception.NotFoundException;
import com.example.finalprojecthabibbackend.mapper.AdvertMapper;
import com.example.finalprojecthabibbackend.model.entity.Advert;
import com.example.finalprojecthabibbackend.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {
    private final AdvertRepository advertRepository;
    private final AdvertMapper advertMapper;

    @Transactional
    @Override
    public AdvertResponseDto createAdvert(AdvertRequestDto advertRequestDto) {
        Advert advert = advertMapper.toAdvertFromCreateAdvertRequest(advertRequestDto);
        return advertMapper.toAdvertDto(advertRepository.save(advert));
    }

    @Transactional(readOnly = true)
    @Override
    public List<AdvertResponseDto> getAllAdvert() {
        return advertRepository.findAll().stream().map(advertMapper::toAdvertDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public AdvertResponseDto getAdvert(Long advertId) {
        return advertRepository.findById(advertId).map(advertMapper::toAdvertDto).orElseThrow(() -> new NotFoundException("Advert with id: " + advertId + " could not be found"));
    }

    @Transactional
    @Override
    public void deleteAdvertById(Long advertId) {
        advertRepository.deleteById(advertId);
    }

    @Transactional
    @Override
    public AdvertResponseDto updateAdvert(Long advertId, AdvertRequestDto advertRequestDto) {
        return advertRepository.findById(advertId).map(advert -> updateAdvertDto(advertRequestDto, advert)).map(advertRepository::save).map(advertMapper::toAdvertDto).orElse(null);
    }

    private static Advert updateAdvertDto(AdvertRequestDto advertRequestDto, Advert advert) {
        advert.setAdvertDepartment(advertRequestDto.getAdvertDepartment());
        advert.setAdvertHeader(advertRequestDto.getAdvertHeader());
        advert.setAdvertDetail(advertRequestDto.getAdvertDetail());
        advert.setAdvertPosition(advertRequestDto.getAdvertPosition());
        advert.setAdvertType(advertRequestDto.getAdvertType());
        return advert;
    }
}
