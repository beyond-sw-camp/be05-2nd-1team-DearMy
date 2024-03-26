package com.encore.bbabap.comment;

import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.comment.Comment;
import com.encore.bbabap.domain.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CommentDomainTest {

    @Test
    @DisplayName("댓글 생성 확인")
    void createComment(){
        Comment comment = Comment.builder()
                .id(100L)
                .createdAt(LocalDateTime.now())
                .user(User.builder().email("test1234@gmail.com").build())
                .board(Board.builder().id(123L).title("코멘트 생성 테스트 게시물 제목").content("코멘트 생성 테스트 게시물 내용").user(User.builder().email("test1234@gmail.com").build()).build())
                .build();
        assertThat(comment.getBoard().getId()).isEqualTo(123L);
        assertThat(comment.getUser().getEmail()).isEqualTo("test1234@gmail.com");
    }
    // 테스트 성공
}
