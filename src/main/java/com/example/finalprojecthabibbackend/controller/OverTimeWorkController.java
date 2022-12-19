package com.example.finalprojecthabibbackend.controller;

import com.example.finalprojecthabibbackend.dto.request.OverTimeWorkRequestDto;
import com.example.finalprojecthabibbackend.dto.response.OverTimeWorkResponseDto;
import com.example.finalprojecthabibbackend.service.OverTimeWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/over-time-work")
@RequiredArgsConstructor
public class OverTimeWorkController {
    private final OverTimeWorkService overTimeWorkService;

    @PostMapping("/add")
    public ResponseEntity<OverTimeWorkResponseDto> createOverTimeWork(@RequestBody OverTimeWorkRequestDto overTimeWorkRequestDto) {
        return ResponseEntity.ok(overTimeWorkService.createOverTimeWork(overTimeWorkRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OverTimeWorkResponseDto>> getAllExpense() {
        return ResponseEntity.ok(overTimeWorkService.getAllOverTimeWork());
    }

    @GetMapping("/{overTimeWorkId}")
    public ResponseEntity<OverTimeWorkResponseDto> getOverTimeWork(@PathVariable Long overTimeWorkId) {
        return ResponseEntity.ok(overTimeWorkService.getOverTimeWork(overTimeWorkId));
    }

    @DeleteMapping("/{overTimeWorkId}")
    public ResponseEntity<?> deleteOverTimeWork(@PathVariable Long overTimeWorkId) {
        overTimeWorkService.deleteOverTimeWorkById(overTimeWorkId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{overTimeWorkId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<OverTimeWorkResponseDto> updateOverTimeWork(@PathVariable Long overTimeWorkId, @RequestBody OverTimeWorkRequestDto overTimeWorkRequestDto) {
        return ResponseEntity.ok(overTimeWorkService.updateOverTimeWork(overTimeWorkId, overTimeWorkRequestDto));
    }

}