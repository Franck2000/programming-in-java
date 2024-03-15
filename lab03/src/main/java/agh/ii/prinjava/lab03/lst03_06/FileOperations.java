package agh.ii.prinjava.lab03.lst03_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class FileOperations {

    /**
     * Counts the number of characters in a given text file
     */
    public static long countCharacters(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return lines.mapToLong(String::length).sum();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Counts the number of lines in a given text file
     */
    public static long countLines(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return lines.count();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }



    /**
     * Counts the number of words in a given text file
     */
    public static long countWords(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return lines.flatMap(line -> Stream.of(line.split("\\s+"))).count();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Counts the number of whitespace characters in a given text file
     */
    public static long countWhitespaceCharacters(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return lines.mapToLong(line -> line.chars().filter(Character::isWhitespace).count()).sum();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Changes all TAB characters to SPACE characters in a given text file
     */
    public static void replaceTabsWithSpaces(Path filePath) {
        try {
            String content = Files.readString(filePath, StandardCharsets.UTF_8);
            content = content.replaceAll("\t", " ");
            Files.writeString(filePath, content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
