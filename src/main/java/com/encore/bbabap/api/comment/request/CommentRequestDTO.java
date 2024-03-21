package com.encore.bbabap.api.comment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    private String content;
    private String email; // 사용자 이메일
    private Long boardId; // 게시물 ID
}
