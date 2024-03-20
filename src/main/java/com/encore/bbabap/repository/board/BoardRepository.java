package com.encore.bbabap.repository.board;


import com.encore.bbabap.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}