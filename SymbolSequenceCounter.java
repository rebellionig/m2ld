package student.java.homework.weeks.week4_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SymbolSequenceCounter
{

    public static int countSymbolSequence(String fileName, String sequence) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrences(line, sequence);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return count;
    }

    private static int countOccurrences(String text, String sequence) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(sequence, index)) != -1) {
            count++;
            index += sequence.length();
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter the symbol sequence: ");
        String sequence = scanner.nextLine();

        int result = countSymbolSequence(fileName, sequence);
        System.out.printf("The sequence '%s' occurs %d time(s) in the file '%s'.%n", sequence, result, fileName);
    }
}
