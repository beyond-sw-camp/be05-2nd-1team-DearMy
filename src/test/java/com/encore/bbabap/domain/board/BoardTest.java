package com.encore.bbabap.domain.board;

import com.encore.bbabap.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @DisplayName("게시물 생성 테스트")
    @Test
    public void testCreateBoard() {
        // Given
        String title = "테스트 게시물";
        String content = "테스트 내용";
        LocalDateTime now = LocalDateTime.now();
        User user = User.builder()
                .email("bbabap@example.com")
                .password("bbabap")
                .nickname("빠밥")
                .build();

        // When
        Board board = Board.builder()
                .title(title)
                .content(content)
                .registeredAt(now)
                .updatedAt(now)
                .deletedYn(false)
                .deletedAt(null)
                .user(user)
                .build();

        // Then
        assertNotNull(board);
        assertEquals(title, board.getTitle());
        assertEquals(content, board.getContent());
        assertEquals(now, board.getRegisteredAt());
        assertEquals(now, board.getUpdatedAt());
        assertFalse(board.getDeletedYn());
        assertNull(board.getDeletedAt());
        assertEquals(user, board.getUser());
    }

    @DisplayName("게시물 조회 테스트")
    @Test
    public void testReadBoard() {
        // Given
        Long id = 1L;
        String title = "테스트 게시물";
        String content = "테스트 내용";
        LocalDateTime now = LocalDateTime.now();
        User user = User.builder()
                .email("bbabap@example.com")
                .password("bbabap")
                .nickname("빠밥")
                .build();

        // When
        Board board = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .registeredAt(now)
                .updatedAt(now)
                .deletedYn(false)
                .deletedAt(null)
                .user(user)
                .build();

        // Then
        assertNotNull(board);
        assertEquals(id, board.getId());
    }

    @DisplayName("게시물 수정 테스트")
    @Test
    public void testUpdateBoard() {
        // Given
        Long id = 1L;
        String updatedTitle = "수정된 제목";
        String updatedContent = "수정된 내용";
        LocalDateTime now = LocalDateTime.now();
        User user = User.builder()
                .email("bbabap@example.com")
                .password("bbabap")
                .nickname("빠밥")
                .build();

        Board board = Board.builder()
                .id(id)
                .title("테스트 게시물")
                .content("테스트 내용")
                .registeredAt(now)
                .updatedAt(now)
                .deletedYn(false)
                .deletedAt(null)
                .user(user)
                .build();

        // When
        LocalDateTime updatedTime = LocalDateTime.now();
        board.setTitle(updatedTitle);
        board.setContent(updatedContent);
        board.setUpdatedAt(updatedTime);

        // Then
        assertEquals(updatedTitle, board.getTitle());
        assertEquals(updatedContent, board.getContent());
        assertEquals(updatedTime, board.getUpdatedAt());
    }

    @DisplayName("게시물 삭제 테스트")
    @Test
    public void testDeleteBoard() {
        // Given
        Long id = 1L;
        LocalDateTime now = LocalDateTime.now();
        User user = User.builder()
                .email("bbabap@example.com")
                .password("bbabap")
                .nickname("빠밥")
                .build();

        Board board = Board.builder()
                .id(id)
                .title("테스트 게시물")
                .content("테스트 내용")
                .registeredAt(now)
                .updatedAt(now)
                .deletedYn(false)
                .deletedAt(null)
                .user(user)
                .build();

        // When
        LocalDateTime deletedTime = LocalDateTime.now();
        board.setDeletedYn(true);
        board.setDeletedAt(deletedTime);

        // Then
        assertTrue(board.getDeletedYn());
        assertNotNull(board.getDeletedAt());
    }
}
