package aoc01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Aoc_01_p1 {
    public static void main(String[] args) {
        String filePath = "text.txt";
        int totalSum = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("\\d");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    char firstDigit = matcher.group().charAt(0);
                    char lastDigit = firstDigit;
                    while (matcher.find()) {
                        lastDigit = matcher.group().charAt(0);
                    }
                    String twoDigitString = String.valueOf(firstDigit) + String.valueOf(lastDigit);
                    int twoDigitNumber = Integer.parseInt(twoDigitString);
                    totalSum += twoDigitNumber;

                    System.out.println("Two-digit number formed from first and last digit: " + twoDigitNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total sum of two-digit numbers: " + totalSum);
    }
}