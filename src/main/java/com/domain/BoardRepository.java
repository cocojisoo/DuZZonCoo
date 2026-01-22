package com.example.DuZZonCoo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, UUID>{
    List<Board> findAllByOrderByCreatedAtDesc();
    List<Board> findAllByTitleContaining(String title);
    List<Board> findByWriter(String writer);
}