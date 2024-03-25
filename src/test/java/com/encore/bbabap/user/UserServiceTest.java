//package com.encore.bbabap.user;
//
//import com.encore.bbabap.domain.enums.CarType;
//import com.encore.bbabap.domain.user.User;
//import com.encore.bbabap.service.user.UserService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserServiceTest {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @DisplayName("비밀번호 암호화 테스트")
//    @Test
//    void testEncodePassword(){
//        //given
//        String rawPassword = "1234";
//
//        //when 행위만
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//
//        //then 행위에 대한 결과
//        assertAll(
//                () -> assertNotEquals(rawPassword, encodedPassword),
//                () -> assertTrue(passwordEncoder.matches(rawPassword, encodedPassword))
//        );
//        // 단방향
//    }
//
//    // member service
//    @DisplayName("회원 가입 시 이메일 중복은 허용하지 않는다.")
//    @Test
//    void signUp() {
//        //given
//        List<User> users = List.of(
//                createMember("aaa@naver.com", "동동이", "1324", CarType.A_TYPE),
//                createMember("aaa@naver.com", "동동삼", "1324", CarType.A_TYPE)
//        );
//        //when
//
//        //then
//    }
//
//    private static User createMember(String email, String nickname, String password,
//            CarType carType) {
//
//        return User.builder()
//                .email(email)
//                .nickname(nickname)
//                .password(password)
//                .carType(carType)
//                .build();
//    }
//
//}