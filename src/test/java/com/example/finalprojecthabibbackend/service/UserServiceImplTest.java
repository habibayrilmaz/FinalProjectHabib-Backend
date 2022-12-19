//package com.example.finalprojecthabibbackend.service;
//
//import com.example.finalprojecthabibbackend.dto.request.UserContactInfoRequestDto;
//import com.example.finalprojecthabibbackend.dto.request.UserRequestDto;
//import com.example.finalprojecthabibbackend.dto.response.UserResponseDto;
//import com.example.finalprojecthabibbackend.mapper.UserMapper;
//import com.example.finalprojecthabibbackend.model.entity.User;
//import com.example.finalprojecthabibbackend.model.entity.UserContactInfo;
//import com.example.finalprojecthabibbackend.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private UserMapper userMapper;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @Test
//    void createUser() {
//        UserRequestDto userRequestDto = new UserRequestDto();
//        userRequestDto.setUserName("Habib");
//        userRequestDto.setUserSurname("Ayrılmaz");
//        userRequestDto.setUserContactInfoId(1L);
//
//        User user = new User();
//        user.setId(10L);
//        user.setUserName("Habib");
//        user.setUserSurname("Ayrılmaz");
//
//        UserContactInfo userContactInfo = new UserContactInfo();
//        userContactInfo.setId(7L);
//        userContactInfo.setUserCity("İstanbul");
//
//        UserContactInfoRequestDto userContactInfoRequestDto = new UserContactInfoRequestDto();
//        userContactInfoRequestDto.setUserId(7L);
//        userContactInfoRequestDto.setUserCity("İstanbul");
//
//        user.setUserContactInfo(userContactInfo);
//        userRequestDto.setUserContactInfoId(1L);
//
//        when(userMapper.toUserFromCreateUserRequest(any(UserRequestDto.class))).thenReturn(user);
//        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
//        when(userMapper.toUserDto(userRepository.save(any(User.class)))).thenReturn(userResponseDto);
//
//
//        System.out.println(user.getUserSurname());
//        System.out.println(userResponseDto.getUserName());
//        System.out.println(userResponseDto.getUserName() + "=" + user.getUserSurname() );
//        assertEquals(userResponseDto.getUserName(), user.getUserSurname());
//
//
//
//    }
//
//    @Test
//    void getAllUsers() {
//    }
//
//    @Test
//    void getUser() {
//    }
//
//    @Test
//    void getUsers() {
//    }
//
//    @Test
//    void updateUser() {
//    }
//
//    @Test
//    void deleteById() {
//    }
//}