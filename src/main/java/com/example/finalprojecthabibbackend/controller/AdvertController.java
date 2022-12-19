package com.example.finalprojecthabibbackend.controller;

import com.example.finalprojecthabibbackend.dto.request.AdvertRequestDto;
import com.example.finalprojecthabibbackend.dto.response.AdvertResponseDto;
import com.example.finalprojecthabibbackend.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advert")
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertService advertService;

    @PostMapping("/add")
    public ResponseEntity<AdvertResponseDto> createAdvert(@RequestBody AdvertRequestDto advertRequestDto) {
        return ResponseEntity.ok(advertService.createAdvert(advertRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdvertResponseDto>> getAllAdvert() {
        return ResponseEntity.ok(advertService.getAllAdvert());
    }

    @GetMapping("/{advertId}")
    public ResponseEntity<AdvertResponseDto> getAdvert(@PathVariable Long advertId) {
        return ResponseEntity.ok(advertService.getAdvert(advertId));
    }

    @DeleteMapping("/{advertId}")
    public ResponseEntity<?> deleteAdvert(@PathVariable Long advertId) {
        advertService.deleteAdvertById(advertId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{advertId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<AdvertResponseDto> updateAdvert(@PathVariable Long advertId, @RequestBody AdvertRequestDto advertRequestDto) {
        return ResponseEntity.ok(advertService.updateAdvert(advertId, advertRequestDto));
    }

}