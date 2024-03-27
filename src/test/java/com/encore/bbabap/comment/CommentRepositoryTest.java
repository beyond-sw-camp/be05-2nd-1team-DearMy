package com.encore.bbabap.comment;

import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.comment.Comment;
import com.encore.bbabap.domain.enums.CarType;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.repository.Comment.CommentRepository;
import com.encore.bbabap.repository.board.BoardRepository;
import com.encore.bbabap.repository.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 내장 데이터베이스 사용하지 않음
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("Repository를 통한 코멘트 생성")
    @Transactional
    void saveComment(){
         /*
        given
         */

        User user1 = User.builder().email("test1@gmail.com").password("pwd").nickname("유저1").carType(CarType.A_TYPE).build();
        User user2 = User.builder().email("test2@gmail.com").password("pwd").nickname("유저2").carType(CarType.B_TYPE).build();

        userRepository.save(user1);
        userRepository.save(user2);

        Board board1 = Board.builder()
                .title("코멘트 생성 테스트 게시물 제목 1")
                .content("코멘트 생성 테스트 게시물 내용 1")
                .user(user1)
                .build();

        Board board2 = Board.builder()
                .title("코멘트 생성 테스트 게시물 제목 2")
                .content("코멘트 생성 테스트 게시물 내용 2")
                .user(user2)
                .build();

        boardRepository.save(board1);
        boardRepository.save(board2);

        Comment comment1 = Comment.builder()
                .createdAt(LocalDateTime.now())
                .user(user1)
                .board(board1)
                .content("어쩌구")
                .build();

        Comment comment2 = Comment.builder()
                .createdAt(LocalDateTime.now())
                .user(user2)
                .board(board2)
                .content("저쩌구")
                .build();

        /*
        when
         */
        Comment savedComment1 = commentRepository.save(comment1);
        Comment savedComment2 = commentRepository.save(comment2);

        /*
        then
         */
        assertThat(savedComment1.getBoard().getId()).isEqualTo(board1.getId());
        assertThat(savedComment2.getBoard().getId()).isEqualTo(board2.getId());

    }

}
