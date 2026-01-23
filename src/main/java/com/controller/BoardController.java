package com.example.DuZZonCoo.controller;

import com.example.DuZZonCoo.domain.Board;
import com.example.DuZZonCoo.domain.BoardRepository;
import com.example.DuZZonCoo.exception.ErrorCode;

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
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.WRONG_UUID_REQUEST.message()));
        model.addAttribute("board",board);
        return "board/post";
    }

    @GetMapping("/board/{id}/delete")
    public String deleteForm(@PathVariable("id") UUID id, Model model) {
        Board board = boardRepository.findById(id).orElseThrow();
        model.addAttribute("board", board);
        return "board/delete";
}

    @PostMapping("/board/{id}/delete")
    public String deletePost(@PathVariable("id") UUID id, @RequestParam("password") String inputPassword){
        Board board = boardRepository.findById(id).
              orElseThrow(() -> new IllegalArgumentException(ErrorCode.WRONG_UUID_REQUEST.message()));
        if(!board.getPassword().equals(inputPassword)){
            throw new IllegalArgumentException(ErrorCode.INVALID_PASSWORD.message());
        }
        boardRepository.delete(board);
        
        return "redirect:/";
    }
    @GetMapping("/board/{id}/edit")
    public String editPost(@PathVariable("id") UUID id, Model model){
        Board board = boardRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException(ErrorCode.WRONG_UUID_REQUEST.message()));
        model.addAttribute("board", board);
        return "board/edit";
    }
    @PostMapping("/board/{id}/edit")
    public String editPost(@PathVariable("id") UUID id,
                           @RequestParam("password") String inputPassword,
                           Board editedPost){
        Board board = boardRepository.findById(id)
                      .orElseThrow(() -> new IllegalArgumentException(ErrorCode.WRONG_UUID_REQUEST.message()));
        if(!board.getPassword().equals(inputPassword)){
            throw new IllegalArgumentException(ErrorCode.INVALID_PASSWORD.message());
        }
        board.setTitle(editedPost.getTitle());
        board.setContent(editedPost.getContent());

        boardRepository.save(board);

        return "redirect:/post/" + id;
        }
    }
