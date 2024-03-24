package com.encore.bbabap.service.board;


import com.encore.bbabap.api.board.request.BoardRequestDTO;
import com.encore.bbabap.api.board.response.BoardResponseDTO;
import com.encore.bbabap.api.comment.response.CommentResponseDTO;
import com.encore.bbabap.config.SecurityUtils;
import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.repository.board.BoardRepository;
import com.encore.bbabap.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

        // 현재 사용자의 이메일 가져오기
        String userEmail = SecurityUtils.getCurrentUserEmail();
        System.out.println("현재 로그인한 사용자의 이메일: " + userEmail);

        // 이메일을 사용하여 사용자 정보 가져오기
        User user = userRepository.findByEmail(userEmail);
        System.out.println(user);

//        if (user == null) {
//            throw new RuntimeException("User not found with email: " + userEmail);
//        } else {
//            System.out.println("사용자 정보를 가져온 이메일: " + userEmail);
//        }

        Board board = Board.builder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .user(user)
                .registeredAt(LocalDateTime.now()) // 등록 시간 추가
                .deletedYn(false) // 게시글 생성시 삭제 여부 false로 등록
                .build();
        Board savedBoard = boardRepository.save(board);

        return convertToDTO(savedBoard);
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDTO> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        for(Board board : boards){ // 삭제된 게시글 조회 x 처리
            if (board.getDeletedYn()){
                boards.remove(board);
            }
        }
        return boards.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardResponseDTO getBoardById(Long id) {
        Board board = boardRepository.findByIdWithComments(id).orElse(null);
        if (board != null && board.getDeletedYn()) { // 삭제된 게시물인 경우
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board with id " + id + " is deleted"); // 삭제된 게시물인 경우
        }
        else if(board==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found with id: " + id); // 없는 게시물인 경우
        }
        return convertToDTO(board); // 해당 게시물이 있는 경우
    }

    @Transactional
    public BoardResponseDTO updateBoard(Long id, BoardRequestDTO requestDTO) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + id));

        // 현재 사용자의 이메일 가져오기
        String currentUserEmail = SecurityUtils.getCurrentUserEmail();

        // 게시물을 작성한 사용자의 이메일 가져오기
        String authorEmail = board.getUser().getEmail();

        // 현재 사용자와 게시물 작성자의 이메일이 일치하는지 확인
        if (!currentUserEmail.equals(authorEmail)) {
            throw new RuntimeException("You do not have permission to update this board.");
        }

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

        String currentUserEmail = SecurityUtils.getCurrentUserEmail(); // 사용자의 이메일 가져오기

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + id));

        // 보드를 작성한 사용자의 이메일과 현재 사용자의 이메일을 비교하여 권한 확인
        if (!board.getUser().getEmail().equals(currentUserEmail)) {
            throw new RuntimeException("You do not have permission to delete this board.");
        }

        // 삭제 여부 플래그 설정
        board.setDeletedYn(true);

        // 삭제 시간 설정
        board.setDeletedAt(LocalDateTime.now());

        // 실제로 데이터를 삭제하는 경우
        // boardRepository.delete(board);
    }

    private BoardResponseDTO convertToDTO(Board board) {
        List<CommentResponseDTO> commentDTOs = board.getComments().stream()
                .map(comment -> CommentResponseDTO.builder()
                        .id(comment.getId())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .email(comment.getUser().getEmail())
                        .boardId(comment.getBoard().getId())
                        .build())
                .collect(Collectors.toList());

        return BoardResponseDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .registeredAt(board.getRegisteredAt())
                .updatedAt(board.getUpdatedAt())
                .deletedYn(board.getDeletedYn())
                .email(board.getUser().getEmail())
                .comments(commentDTOs)
                .build();
    }
}
