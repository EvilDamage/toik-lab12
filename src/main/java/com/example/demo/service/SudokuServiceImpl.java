package com.example.demo.service;

import com.example.demo.repository.SudokuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SudokuServiceImpl implements SudokuService {
    final SudokuRepository sudokuRepository;
    List<Integer> lineIds = new ArrayList<Integer>();
    List<Integer> kolumnIds = new ArrayList<Integer>();
    List<Integer> areaIds = new ArrayList<Integer>();

    public SudokuServiceImpl(SudokuRepository sudokuRepository) { this.sudokuRepository = sudokuRepository; }

    public boolean getSudokuVerify() {
        sudokuRepository.readCsvFile();
        Integer[][] movieDtoList = sudokuRepository.getSudokuList();

        return sudokuVerify(movieDtoList);
    }

    public Map<String, List<Integer>> getSudokuError() {
        Map<String, List<Integer>> mapMovies = new HashMap<>();
        mapMovies.put("lineIds", lineIds);
        mapMovies.put("kolumnIds", kolumnIds);
        mapMovies.put("areaIds", areaIds);

        return mapMovies;
    }

    public boolean sudokuVerify(Integer[][] s) {
        lineIds.clear();
        kolumnIds.clear();
        areaIds.clear();

        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 8; col++)
                for (int col2 = col + 1; col2 < 9; col2++)
                    if (s[row][col].equals(s[row][col2]))
                        lineIds.add(col);

        for (int col = 0; col < 9; col++)
            for (int row = 0; row < 8; row++)
                for (int row2 = row + 1; row2 < 9; row2++)
                    if (s[row][col].equals(s[row2][col]))
                        kolumnIds.add(col);

        for (int row = 0; row < 9; row += 3)
            for (int col = 0; col < 9; col += 3)
                for (int pos = 0; pos < 8; pos++)
                    for (int pos2 = pos + 1; pos2 < 9; pos2++)
                        if (s[row + pos % 3][col + pos / 3].equals(s[row + pos2 % 3][col + pos2 / 3]))
                            areaIds.add(col);

        return lineIds.size() == 0 && kolumnIds.size() == 0 && areaIds.size() == 0;
    }
}
