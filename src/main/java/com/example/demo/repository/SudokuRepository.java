package com.example.demo.repository;

public interface SudokuRepository {
    String PATH = "src/resources/sudoku.csv";
    Integer[][] getSudokuList();
    void readCsvFile();
}
