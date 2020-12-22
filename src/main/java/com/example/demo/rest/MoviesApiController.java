package com.example.demo.rest;

import com.example.demo.service.SudokuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MoviesApiController {
    final SudokuService sudokuService;

    public MoviesApiController(SudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }

    @CrossOrigin
    @GetMapping("/api/sudoku/verify")
    public ResponseEntity <Map<String, List<Integer>>> getSudokuValidation(){
        if(sudokuService.getSudokuVerify()){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<>(sudokuService.getSudokuError(), HttpStatus.BAD_REQUEST);
        }

    }
}
