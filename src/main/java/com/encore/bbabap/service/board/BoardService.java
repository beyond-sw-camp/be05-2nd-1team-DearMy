package com.encore.bbabap.service.board;


import com.encore.bbabap.api.board.request.BoardRequestDTO;
import com.encore.bbabap.api.board.response.BoardResponseDTO;
import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.repository.board.BoardRepository;
import com.encore.bbabap.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public BoardResponseDTO createBoard(BoardRequestDTO requestDTO) {

        // 사용자 인증 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 사용자가 인증되었는지 확인
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User authentication failed");
        }

        // 사용자의 이메일 가져오기
        String userEmail = authentication.getName();

        // 이메일을 사용하여 사용자 정보 가져오기
        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            throw new RuntimeException("User not found with email: " + userEmail);
        }

//        User user = userRepository.findByEmail(requestDTO.getEmail());
//        if (user == null) {
//            throw new RuntimeException("User not found with email: " + requestDTO.getEmail());
//        }

//        Board board = new Board();
//        board.setTitle(requestDTO.getTitle());
//        board.setContent(requestDTO.getContent());
//        board.setUser(user);
//        Board savedBoard = boardRepository.save(board);

        Board board = Board.builder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .user(user)
                .registeredAt(LocalDateTime.now()) // 등록 시간 추가
                .build();
        Board savedBoard = boardRepository.save(board);

        return convertToDTO(savedBoard);
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDTO> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardResponseDTO getBoardById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + id));
        return convertToDTO(board);
    }

    @Transactional
    public BoardResponseDTO updateBoard(Long id, BoardRequestDTO requestDTO) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + id));

        board.setTitle(requestDTO.getTitle());
        board.setContent(requestDTO.getContent());
        board.setUpdatedAt(LocalDateTime.now());

        return convertToDTO(board);
    }

//    @Transactional
//    public void deleteBoard(Long id) {
//        boardRepository.deleteById(id);
//    }

    @Transactional
    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + id));

        // 삭제 여부 플래그 설정
        board.setDeletedYn(true);

        // 삭제 시간 설정
        board.setDeletedAt(LocalDateTime.now());

        // 실제로 데이터를 삭제하는 경우
        // boardRepository.delete(board);
    }

    private BoardResponseDTO convertToDTO(Board board) {
        return BoardResponseDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .registeredAt(board.getRegisteredAt())
                .updatedAt(board.getUpdatedAt())
                .deletedYn(board.getDeletedYn())
                .email(board.getUser().getEmail())
                .build();
    }
}
