package com.encore.bbabap.service.Comment;

import com.encore.bbabap.api.comment.request.CommentRequestDTO;
import com.encore.bbabap.api.comment.response.CommentResponseDTO;
import com.encore.bbabap.domain.Comment.Comment;
import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.repository.Comment.CommentRepository;
import com.encore.bbabap.repository.board.BoardRepository;
import com.encore.bbabap.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponseDTO addComment(CommentRequestDTO requestDTO) {
        Board board = boardRepository.findById(requestDTO.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + requestDTO.getBoardId()));

        User user = userRepository.findByEmail(requestDTO.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found with email: " + requestDTO.getEmail());
        }

        Comment comment = Comment.builder()
                .content(requestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .user(user)
                .board(board)
                .build();

        Comment savedComment = commentRepository.save(comment);
        return CommentResponseDTO.builder()
                .id(savedComment.getId())
                .content(savedComment.getContent())
                .createdAt(savedComment.getCreatedAt())
                .email(savedComment.getUser().getEmail())
                .boardId(savedComment.getBoard().getId())
                .build();
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));
        commentRepository.delete(comment);
    }
}
