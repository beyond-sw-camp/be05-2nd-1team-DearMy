//package com.encore.bbabap.user;
//
//import com.encore.bbabap.api.user.request.UserUpdateRequest;
//import com.encore.bbabap.domain.user.User;
//import com.encore.bbabap.domain.enums.CarType;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class UserTest {
//
//
//    @DisplayName("회원 가입 시 회원 상태는 deleteYn = false 이다.")
//    @Test
//    void signUp() {
//        //given
//        User user = createMember("aaa@naver.com", "동동이", "1324", CarType.A_TYPE);
//
//        //when
//        Boolean deletedYn = user.getDeletedYn();
//
//        //then
//        assertThat(deletedYn).isFalse();
//    }
//
//    // TODO : 테스트 실패 -> 매개변수로 빼야할지 고민중
//    @DisplayName("회원 가입 시 가입시간은 현재 날짜와 동일하다.")
//    @Test
//    void signUp2() {
//        //given
//        User user = createMember("aaa@naver.com", "동동이", "1324", CarType.A_TYPE);
//
//        //when
//        LocalDateTime registeredAt = user.getRegisteredAt();
//
//        //then
//        assertThat(registeredAt).isEqualTo(LocalDateTime.now());
//    }
//
//
//    @DisplayName("회원 정보 수정은 닉넥임, 비빌 번호, 차종을 변경할 수 있다.")
//    @Test
//    void update() {
//        //given
//        User user = createMember("aaa@naver.com", "동동이", "1324", CarType.A_TYPE);
//
//        //when
//        String registeredNickname = user.getNickname();
//        String registeredPassword = user.getPassword();
//        CarType registeredCarType = user.getCarType();
//
//        UserUpdateRequest userUpdateRequest = UserUpdateRequest.builder()
//                .nickname("동동십")
//                .password("1234")
//                .carType(CarType.B_TYPE)
//                .build();
//
//        user.updateMemberDetail(userUpdateRequest);
//
//        String afterUpdateNickname = user.getNickname();
//        String afterUpdatePassword = user.getPassword();
//        CarType afterUpdateCarType = user.getCarType();
//
//        //then
//        assertThat(registeredNickname).isNotEqualTo(afterUpdateNickname);
//        assertThat(registeredPassword).isNotEqualTo(afterUpdatePassword);
//        assertThat(registeredCarType).isNotEqualTo(afterUpdateCarType);
//
//    }
//
//    @DisplayName("회원 정보 수정 시 업데이트 시간이 자동으로 변경된다.")
//    @Test
//    void update2() {
//        //given
//        User user = createMember("aaa@naver.com", "동동이", "1324", CarType.A_TYPE);
//
//        //when
//        LocalDateTime beforeUpdatedAt = user.getUpdatedAt();
//        UserUpdateRequest userUpdateRequest = UserUpdateRequest.builder()
//                .nickname("동동십")
//                .password("1234")
//                .carType(CarType.B_TYPE)
//                .build();
//
//        user.updateMemberDetail(userUpdateRequest);
//        LocalDateTime afterUpdatedAt = user.getUpdatedAt();
//
//        //then
//        assertThat(beforeUpdatedAt).isNotEqualTo(afterUpdatedAt);
//    }
//
//    @DisplayName("회원 정보 수정 시 등록시간과 수정시간은 다르게 나온다.")
//    @Test
//    void update3() {
//        //given
//        User user = createMember("aaa@naver.com", "동동이", "1324", CarType.A_TYPE);
//
//        //when
//        LocalDateTime registeredAt = user.getRegisteredAt();
//
//        UserUpdateRequest userUpdateRequest = UserUpdateRequest.builder()
//                .nickname("동동십")
//                .password("1234")
//                .carType(CarType.B_TYPE)
//                .build();
//
//        user.updateMemberDetail(userUpdateRequest);
//        LocalDateTime afterUpdatedAt = user.getUpdatedAt();
//
//        //then
//        assertThat(registeredAt).isNotEqualTo(afterUpdatedAt);
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
//
//}