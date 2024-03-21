package com.encore.bbabap.api.comment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    private String content;
    private Long boardId;
}
