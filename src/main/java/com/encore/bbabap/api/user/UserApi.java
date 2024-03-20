package com.encore.bbabap.api.user;

import com.encore.bbabap.api.user.request.SignUpUserRequest;
import com.encore.bbabap.api.user.request.UserUpdateRequest;
import com.encore.bbabap.api.user.response.UserResponse;
import com.encore.bbabap.service.user.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class UserApi {

    private final UserService userService;

    // 멤버 가입
    @PostMapping("/register")
    public ResponseEntity<UserResponse> signUp(@RequestBody SignUpUserRequest request) {
        UserResponse userResponse = userService.signUp(request);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    // 전체 멤버 조회
    @GetMapping()
    public List<UserResponse> memberList() {
        return userService.findAll();
    }

    // 멤버 수정
    @PatchMapping("/{id}")
    public void updateMember(@PathVariable Long id,
            @Validated @RequestBody UserUpdateRequest request) {
        userService.updateMember(id, request);
    }

    // 멤버 삭제
    @DeleteMapping("{id}")
    public void deleteMember(@PathVariable Long id) {
        userService.deleteMemberById(id);
    }


}
