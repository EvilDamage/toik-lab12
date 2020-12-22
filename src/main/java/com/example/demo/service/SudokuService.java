package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface SudokuService {
    boolean getSudokuVerify();
    Map<String, List<Integer>> getSudokuError();
}
