package com.day2.exercise;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static List<String> list1 = new ArrayList<>();

    public static void main(String[] args) {
        readFile();
    }

    // Open a file and create two sorted lists
    public static void readFile() {
        String filePath = "/home/jmueller/Classes/AoC2024/demo/src/main/levels_input.txt";
        // String filePath = "/home/jmueller/Classes/AoC2024/demo/src/main/test.txt";
        

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Boolean safe = false;
            int safe_levels = 0;

            List<Integer> list = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] levels = line.split(" ");
                
                // Create a list
                for (int i=0; i < levels.length; i++) {
                    list.add(Integer.parseInt(levels[i]));
                }

                // Determine ascend/decend
                if (list.get(0) > list.get(1)) {
                    // Do nothing
                } else {
                    Collections.reverse(list);
                }

        
                for (int j=0; j < list.size()-1; j++) {
                    
                    int diff = list.get(j) - list.get(j+1);

                    if (list.get(j) > list.get(j+1) && diff <= 3) {    
                        safe = true;
                    } else {
                        safe = false;
                        break;
                    }
                    
                }

                if (safe) {
                    safe_levels++;
                }

                list.clear();
                System.out.println(safe_levels);
            }
        } catch (Exception e) {}
    
    }
}