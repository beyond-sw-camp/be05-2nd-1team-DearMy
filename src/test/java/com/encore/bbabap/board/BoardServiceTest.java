package com.encore.bbabap.board;

import com.encore.bbabap.api.board.request.BoardRequestDTO;
import com.encore.bbabap.api.board.response.BoardResponseDTO;
import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.repository.board.BoardRepository;
import com.encore.bbabap.repository.user.UserRepository;
import com.encore.bbabap.service.board.BoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;

<<<<<<< HEAD
//@SpringBootTest
//public class BoardServiceTest {
//
//    @Autowired
//    private BoardService boardService;
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//        boardRepository = Mockito.mock(BoardRepository.class);
//        userRepository = Mockito.mock(UserRepository.class);
//        boardService = new BoardService(boardRepository, userRepository);
//    }
//
//    @DisplayName("게시물 생성 테스트")
//    @Test
//    void createBoardTest() {
//        // given
//        BoardRequestDTO requestDTO = new BoardRequestDTO();
//        requestDTO.setTitle("Test Title");
//        requestDTO.setContent("Test Content");
////        requestDTO.setEmail("test@example.com");
//
//        User user = new User();
//        user.setEmail("test@example.com");
//        user.setNickname("test_user");
//
////        when(userRepository.findByEmail(requestDTO.getEmail())).thenReturn(user);
//        when(boardRepository.save(any(Board.class))).thenAnswer(invocation -> {
//            Board board = invocation.getArgument(0);
//            board.setId(1L); // Setting ID for the saved board
//            return board;
//        });
//
//        // when
//        BoardResponseDTO createdBoard = boardService.createBoard(requestDTO);
//
//        // then
//        assertThat(createdBoard).isNotNull();
//        assertThat(createdBoard.getId()).isEqualTo(1L);
//        assertThat(createdBoard.getTitle()).isEqualTo("Test Title");
//        assertThat(createdBoard.getContent()).isEqualTo("Test Content");
//        assertThat(createdBoard.getEmail()).isEqualTo("test@example.com");
//    }
=======
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        boardRepository = Mockito.mock(BoardRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        boardService = new BoardService(boardRepository, userRepository);
    }

    @DisplayName("게시물 생성 테스트")
    @Test
    void createBoardTest() {
        // given
        BoardRequestDTO requestDTO = new BoardRequestDTO();
        requestDTO.setTitle("Test Title");
        requestDTO.setContent("Test Content");
//        requestDTO.setEmail("test@example.com");

        User user = new User();
//        user.setEmail("test@example.com");
//        user.setNickname("test_user");

//        when(userRepository.findByEmail(requestDTO.getEmail())).thenReturn(user);
        when(boardRepository.save(any(Board.class))).thenAnswer(invocation -> {
            Board board = invocation.getArgument(0);
            board.setId(1L); // Setting ID for the saved board
            return board;
        });

        // when
        BoardResponseDTO createdBoard = boardService.createBoard(requestDTO);

        // then
        assertThat(createdBoard).isNotNull();
        assertThat(createdBoard.getId()).isEqualTo(1L);
        assertThat(createdBoard.getTitle()).isEqualTo("Test Title");
        assertThat(createdBoard.getContent()).isEqualTo("Test Content");
        assertThat(createdBoard.getEmail()).isEqualTo("test@example.com");
    }
>>>>>>> refactoring-zn

//    @DisplayName("모든 게시물 조회 테스트")
//    @Test
//    void getAllBoardsTest() {
//        // given
//        List<Board> boards = new ArrayList<>();
//        boards.add(new Board(1L, "Test Title 1", "Test Content 1", LocalDateTime.now(), null, false, new User()));
//        boards.add(new Board(2L, "Test Title 2", "Test Content 2", LocalDateTime.now(), null, false, new User()));
//
//        when(boardRepository.findAll()).thenReturn(boards);
//
//        // when
//        List<BoardResponseDTO> boardResponseDTOList = boardService.getAllBoards();
//
//        // then
//        assertThat(boardResponseDTOList).isNotEmpty();
//        assertThat(boardResponseDTOList.size()).isEqualTo(2);
//        assertThat(boardResponseDTOList.get(0).getTitle()).isEqualTo("Test Title 1");
//        assertThat(boardResponseDTOList.get(1).getTitle()).isEqualTo("Test Title 2");
//    }

    // Update 및 Delete 테스트도 유사한 방식으로 작성 가능합니다.
//}
