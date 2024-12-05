package com.day1.exercise;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static List<String> list1 = new ArrayList<>();
    public static List<String> list2 = new ArrayList<>();

    public static void main(String[] args) {
        readFile();
        Collections.sort(list1);
        Collections.sort(list2);

        
        int total = 0;

        for (int i = 0; i < list1.size(); i++) {
            int sub_count=0;
            for (int j = 0; j < list2.size(); j++) {
                if (Integer.parseInt(list1.get(i)) == Integer.parseInt(list2.get(j))) {
                    sub_count++;
                }
            }
            total += Integer.parseInt(list1.get(i)) * sub_count;
            sub_count = 0;
        }
        System.out.println(total);
    }

    // Open a file and create two sorted lists
    public static void readFile() {
        String filePath = "/home/jmueller/Classes/AoC2024/demo/src/main/location_id_list.txt";
        //String filePath = "/home/jmueller/Classes/AoC2024/demo/src/main/test.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split("   ");
                list1.add(columns[0]);
                list2.add(columns[1]);
            }

        } catch (Exception e) {}
    
    }
}
