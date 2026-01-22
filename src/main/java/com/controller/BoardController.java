package com.example.DuZZonCoo.controller;

import com.example.DuZZonCoo.domain.Board;
import com.example.DuZZonCoo.domain.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController{
    private final BoardRepository boardRepository;
    
    @GetMapping("/")
    public String list(Model model){
      List<Board> boards = boardRepository.findAllByOrderByCreatedAtDesc();
      model.addAttribute("boards",boards);
      return "board/list";
    } 
    @GetMapping("/board/write")
    public String writePost(){
        return "board/write";
    }
    @PostMapping("/board/write")
    public String write(Board board){
        boardRepository.save(board);
        return "redirect:/";
    }
    @GetMapping("/board/{id}")
    public String showPost(@PathVariable("id") UUID id, Model model){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 접근이긔"));
        model.addAttribute("board",board);
        return "board/post";
    }


}