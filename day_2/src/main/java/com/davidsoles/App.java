
package com.davidsoles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Advent of Code 2021 - Day 2
 *
 * @author David Soles
 */
public class App {

    private static final String INPUT_FILE = "input.txt";

    public static void main(String[] args) {
        Map<String, Integer> inputList = new HashMap<String, Integer>();
        try {
            var aim = 0;
            var position = 0;
            var depth = 0;
            File input = new File(INPUT_FILE);
            Scanner scanner = new Scanner(input);
            var i = 0;
            while (scanner.hasNext()) {
                i++;
                var line = scanner.nextLine().split(" ");
                switch (line[0].toString()) {
                case "down":
                    // depth += Integer.valueOf(line[1]);
                    // inputList.put("depth", depth);
                    aim += Integer.valueOf(line[1]);
                    inputList.put("aim", aim);
                    break;
                case "up":
                    // depth -= Integer.valueOf(line[1]);
                    // inputList.put("depth", depth);
                    aim -= Integer.valueOf(line[1]);
                    inputList.put("aim", aim);
                    break;
                case "forward":
                    position += Integer.valueOf(line[1]);
                    inputList.put("position", position);
                    depth += aim * Integer.valueOf(line[1]);
                    inputList.put("depth", depth);
                    break;
                }
                for (String key : inputList.keySet()) {
                    System.out.println("i=" + i + " >> " + key + " = " + inputList.get(key));
                }
            }
            scanner.close();
            var finalPosition = inputList.get("position") * inputList.get("depth");
            System.out.println("Final Position = " + finalPosition);
        } catch (

        FileNotFoundException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
}
