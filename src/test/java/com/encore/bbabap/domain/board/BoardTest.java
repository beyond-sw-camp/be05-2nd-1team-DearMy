package com.encore.bbabap.domain.board;

import com.encore.bbabap.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardTest {

    @DisplayName("게시물 생성 테스트")
    @Test
    public void testFactoryMethod() {
        // Given
        String title = "테스트 게시물";
        String content = "테스트 내용";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        Boolean deletedYn = false;
        LocalDateTime deletedAt = null;
        User user = User.builder()
                .email("test@example.com")
                .password("password")
                .nickname("Test User")
                .build();

//        // When
//        Board board = Board.create(title, content, registeredAt, updatedAt, deletedYn, deletedAt, user);

        // When
        Board board = Board.builder()
                .title(title)
                .content(content)
                .registeredAt(registeredAt)
                .updatedAt(updatedAt)
                .deletedYn(deletedYn)
                .deletedAt(deletedAt)
                .user(user)
                .build();

        // Then
        assertNotNull(board);
        assertEquals(title, board.getTitle());
        assertEquals(content, board.getContent());
        assertEquals(registeredAt, board.getRegisteredAt());
        assertEquals(updatedAt, board.getUpdatedAt());
        assertEquals(deletedYn, board.getDeletedYn());
        assertEquals(deletedAt, board.getDeletedAt());
        assertEquals(user, board.getUser());
    }
}
