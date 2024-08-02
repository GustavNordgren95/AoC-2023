package aoc01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class aoc_01_p2 {
    public static void main(String[] args) {

        String filePath = "text.txt";
        int totalSum = 0;

        Map<String, String> digitDictionary = new HashMap<>();

        digitDictionary.put("one", "1");
        digitDictionary.put("two", "2");
        digitDictionary.put("three", "3");
        digitDictionary.put("four", "4");
        digitDictionary.put("five", "5");
        digitDictionary.put("six", "6");
        digitDictionary.put("seven", "7");
        digitDictionary.put("eight", "8");
        digitDictionary.put("nine", "9");


        List<String> digitList = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");

        List<String> sortedList = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                Map<Integer, String> digitIndex = new HashMap<>();
                System.out.println(line);

                for (String digit : digitList) {
                    int index = line.indexOf(digit);
                    while (index >= 0) {
                        System.out.println(index);
                        digitIndex.put(index, digit);
                        index = line.indexOf(digit, index + 1);
                    }
                }


                for (Map.Entry<String, String> entry : digitDictionary.entrySet()) {
                    int index = line.indexOf(entry.getKey());
                      while (index >= 0) {
                          System.out.println(index);
                          digitIndex.put(index, entry.getValue());
                          index = line.indexOf(entry.getKey(), index + 1);
                      }

                }
                Map<Integer, String> sortedIndex = digitIndex.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                System.out.println("Sorted index: " + sortedIndex);

                String firstDigit = sortedIndex.values().stream().findFirst().get();
                System.out.println("First digit: " + firstDigit);
                String lastDigit = sortedIndex.values().stream().reduce((first, second) -> second).get();
                System.out.println("Last digit: " + lastDigit);

                String twoDigitString = firstDigit + lastDigit;

                System.out.println("Double digit: " + twoDigitString);

                int twoDigitNumber = Integer.parseInt(twoDigitString);
                totalSum += twoDigitNumber;

            }
            System.out.println("Summary: " + totalSum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}