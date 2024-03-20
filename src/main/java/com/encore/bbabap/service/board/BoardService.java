package com.encore.bbabap.service.board;


import com.encore.bbabap.api.board.request.BoardRequestDTO;
import com.encore.bbabap.api.board.response.BoardResponseDTO;
import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.domain.user.UserStatus;
import com.encore.bbabap.repository.user.BoardRepository;
import com.encore.bbabap.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository; // BoardRepository 주입

    @Autowired
    private UserRepository userRepository;

    public BoardResponseDTO registerBoard(BoardRequestDTO requestDTO) {
        Board board = new Board();
        board.setTitle(requestDTO.getTitle());
        board.setContent(requestDTO.getContent());

        // 사용자 정보를 가져와서 게시판 엔티티에 연결
        User user = userRepository.findByUserId(String.valueOf(requestDTO.getUserId()))
                .orElseThrow(() -> new RuntimeException("User not found with id: " + requestDTO.getUserId()));
        board.setUser(user);
        board.setDeleteYN(UserStatus.N);
        boardRepository.save(board);

        BoardResponseDTO responseDTO = new BoardResponseDTO();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setMessage("게시판 등록이 성공적으로 완료되었습니다.");
        return responseDTO;
    }
}
