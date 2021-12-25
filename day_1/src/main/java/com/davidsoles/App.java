
package com.davidsoles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Advent of Code 2021 - Day 1
 *
 * @author David Soles
 */
public class App {

    private static final String INPUT_FILE = "input.txt";

    public static void main(String[] args) {
        App app = new App();
        List<Integer> inputList = new ArrayList<Integer>();
        try {
            File input = new File(INPUT_FILE);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                inputList.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        var resultPart1 = app.part1(inputList);
        var resultPart2 = app.part2(inputList);
        System.out.println("Result Part 1 = " + resultPart1);
        System.out.println("Result Part 2 = " + resultPart2);
    }

    private int part1(List<Integer> numbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0 && numbers.get(i) > numbers.get(i - 1)) {
                count++;
            }
        }
        return count;
    }

    private int part2(List<Integer> numbers) {
        int j = 0;
        int acum = 0;
        int count = 0;
        int prev = 0;
        for (int i = 0; i < numbers.size() - 2; i++) {
            j = i;
            while (j <= i + 2) {
                acum += numbers.get(j);
                j++;
            }
            if (i > 0 && acum > prev) {
                count++;
            }
            prev = acum;
            acum = 0;
        }
        return count;
    }
}
