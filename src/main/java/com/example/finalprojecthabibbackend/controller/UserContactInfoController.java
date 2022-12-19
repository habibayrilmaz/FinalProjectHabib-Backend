package com.example.finalprojecthabibbackend.controller;

import com.example.finalprojecthabibbackend.dto.request.UserContactInfoRequestDto;
import com.example.finalprojecthabibbackend.dto.response.UserContactInfoResponseDto;
import com.example.finalprojecthabibbackend.service.UserContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-contact")
@RequiredArgsConstructor
public class UserContactInfoController {
    private final UserContactInfoService userContactInfoService;

    @PostMapping("/add")
    public ResponseEntity<UserContactInfoResponseDto> createUserContactInfo(@RequestBody UserContactInfoRequestDto userContactInfoRequestDto) {
        return ResponseEntity.ok(userContactInfoService.createUserContactInfo(userContactInfoRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserContactInfoResponseDto>> getAllUserContactInfo() {
        return ResponseEntity.ok(userContactInfoService.getAllUserContactInfo());
    }

    @GetMapping("/{userContactInfoId}")
    public ResponseEntity<UserContactInfoResponseDto> getUserContactInfo(@PathVariable Long userContactInfoId) {
        return ResponseEntity.ok(userContactInfoService.getUserContactInfo(userContactInfoId));
    }

    @DeleteMapping("/{userContactInfoId}")
    public ResponseEntity<?> deleteUserContactInfo(@PathVariable Long userContactInfoId) {
        userContactInfoService.deleteUserContactInfoById(userContactInfoId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userContactInfoId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<UserContactInfoResponseDto> updateUserContactInfo(@PathVariable Long userContactInfoId, @RequestBody UserContactInfoRequestDto userContactInfoRequestDto) {
        return ResponseEntity.ok(userContactInfoService.updateUserContactInfo(userContactInfoId, userContactInfoRequestDto));
    }

    @GetMapping("/{userId}/info")
    public ResponseEntity<List<UserContactInfoResponseDto>> getUserContactForUserId(@PathVariable(value = "userId") Long userId) {
        return ResponseEntity.ok(userContactInfoService.getUserContactByUserId(userId));
    }


}