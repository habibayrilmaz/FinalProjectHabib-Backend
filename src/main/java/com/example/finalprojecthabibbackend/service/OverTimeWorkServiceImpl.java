package com.example.finalprojecthabibbackend.service;

import com.example.finalprojecthabibbackend.dto.request.OverTimeWorkRequestDto;
import com.example.finalprojecthabibbackend.dto.response.OverTimeWorkResponseDto;
import com.example.finalprojecthabibbackend.exception.NotFoundException;
import com.example.finalprojecthabibbackend.mapper.OverTimeWorkMapper;
import com.example.finalprojecthabibbackend.model.entity.OverTimeWork;
import com.example.finalprojecthabibbackend.model.entity.User;
import com.example.finalprojecthabibbackend.repository.OverTimeWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OverTimeWorkServiceImpl implements OverTimeWorkService {
    private final UserService userService;
    private final OverTimeWorkMapper overTimeWorkMapper;
    private final OverTimeWorkRepository overTimeWorkRepository;

    @Transactional
    @Override
    public OverTimeWorkResponseDto createOverTimeWork(OverTimeWorkRequestDto overTimeWorkRequestDto) {
        User user = userService.getUsers(overTimeWorkRequestDto.getUserId());
        if (user.getId() == null) {
            throw new NotFoundException("OverTimeWork Not Found!");
        }
        OverTimeWork overTimeWork = overTimeWorkMapper.toOverTimeWorkFromCreateOverTimeWorkRequest(overTimeWorkRequestDto);
        overTimeWork.setUser(user);
        return overTimeWorkMapper.toOverTimeWorkDto(overTimeWorkRepository.save(overTimeWork));
    }

    @Transactional(readOnly = true)
    @Override
    public List<OverTimeWorkResponseDto> getAllOverTimeWork() {
        return overTimeWorkRepository.findAll().stream().map(overTimeWorkMapper::toOverTimeWorkDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public OverTimeWorkResponseDto getOverTimeWork(Long overTimeWorkId) {
        return overTimeWorkRepository.findById(overTimeWorkId).map(overTimeWorkMapper::toOverTimeWorkDto).orElseThrow(() -> new NotFoundException("OverTime Work with id: " + overTimeWorkId + " could not be found"));
    }

    @Transactional
    @Override
    public void deleteOverTimeWorkById(Long overTimeWorkId) {
        overTimeWorkRepository.deleteById(overTimeWorkId);
    }

    @Transactional
    @Override
    public OverTimeWorkResponseDto updateOverTimeWork(Long overTimeWorkId, OverTimeWorkRequestDto overTimeWorkRequestDto) {
        return overTimeWorkRepository.findById(overTimeWorkId)
                .map(overTimeWork -> updateOverTimeWorkDto(overTimeWorkRequestDto, overTimeWork))
                .map(overTimeWorkRepository::save)
                .map(overTimeWorkMapper::toOverTimeWorkDto)
                .orElse(null);
    }

    private static OverTimeWork updateOverTimeWorkDto(OverTimeWorkRequestDto overTimeWorkRequestDto, OverTimeWork overTimeWork) {
        overTimeWork.setTimeOfOverTimeWork(overTimeWorkRequestDto.getTimeOfOverTimeWork());
        overTimeWork.setDetailOfOverTimeWork(overTimeWorkRequestDto.getDetailOfOverTimeWork());
        overTimeWork.setDateOfOverTimeWork(overTimeWorkRequestDto.getDateOfOverTimeWork());
        return overTimeWork;
    }

}
