package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Repository
public class SudokuRepositoryImpl implements SudokuRepository {
    private Integer[][] sudokuList;

    public SudokuRepositoryImpl() {
        sudokuList = new Integer[9][9];
        this.readCsvFile();
    }

    public void readCsvFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH));
            String line;
            reader.readLine();
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] cel = line.split(";");
                for (int col = 0; col < 9; col++) {
                    sudokuList[row][col] = Integer.parseInt(cel[col]);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer[][] getSudokuList() {
        return sudokuList;
    }
}
