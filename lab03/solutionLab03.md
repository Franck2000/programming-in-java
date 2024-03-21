

# 2) throws ,	throw ,	try-catch ,	try- finally , and	try-catch-finally


##  Differences Between Checked and Unchecked Exceptions

## Checked Exceptions:

- Checked exceptions are subclasses of `java.lang.Exception` (excluding subclasses of `RuntimeException` and `Error`).
- These exceptions must be either caught or declared in the method signature using the `throws` keyword.
- The compiler enforces handling of checked exceptions at compile-time, ensuring that the programmer explicitly handles or acknowledges the possibility of the exception being thrown.
- Examples of checked exceptions include `IOException`, `FileNotFoundException`, and `SQLException`.
- Checked exceptions are typically used to represent error conditions that are recoverable and expected, such as file not found or network connection issues.

## Unchecked Exceptions:

- Unchecked exceptions are subclasses of `java.lang.RuntimeException` or `java.lang.Error`.
- These exceptions do not need to be explicitly caught or declared in the method signature.
- Unchecked exceptions are not checked by the compiler at compile-time. Instead, they are handled at runtime.
- Examples of unchecked exceptions include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`.
- Unchecked exceptions are usually caused by programming errors, such as attempting to access a null reference or dividing by zero.

### Key Differences:

- **Handling Requirement:** Checked exceptions must be handled explicitly either by catching them using a `try-catch` block or by declaring them in the method signature using `throws`, while unchecked exceptions do not have such requirements.
  
- **Compile-Time Checking:** Checked exceptions are checked by the compiler at compile-time, ensuring that the programmer deals with them, whereas unchecked exceptions are not checked by the compiler.
  
- **Exception Hierarchy:** Checked exceptions are subclasses of `java.lang.Exception`, while unchecked exceptions are subclasses of `java.lang.RuntimeException` or `java.lang.Error`.
  
- **Error vs. Exception:** Unchecked exceptions include both runtime exceptions and errors, while checked exceptions do not include errors.

In practice, checked exceptions are often used for recoverable conditions where the application can take corrective action, while unchecked exceptions are typically used for programming errors or exceptional conditions that are beyond the control of the application.


## The meaning of keywords throw and throws
- throw is used to throw an exception explicitly within a method, while throws is used in the method signature to declare the types of exceptions that the method may throw.
- throw is followed by an instance of an exception class, while throws is followed by the names of the exception classes separated by commas.
- throw is used within the method body, while throws is used in the method declaration.
- In summary, throw is used to throw an exception, while throws is used to declare the exceptions that a method may throw. They both play crucial roles in handling exceptions in Java programs.

# 4) Reading from the Console:

# 5) Simple File I/O: text files

````java
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

````


# 6) Simple File I/O: binary files

1. **BufferedReader**: Reads text from a character-input stream, buffering characters for efficient reading of characters, arrays, and lines.

2. **BufferedWriter**: Writes text to a character-output stream, buffering characters for efficient writing of single characters, arrays, and strings.

3. **FileReader**: Reads character files, providing a stream of characters from the file.

4. **FileWriter**: Writes character files, enabling writing text to a character-output stream.

5. **PrintWriter**: Writes formatted data to an underlying writer.

6. **FileInputStream**: Reads bytes from a file in a file system.

7. **FileOutputStream**: Writes bytes to a file in a file system.

8. **DataInputStream**: Reads primitive Java data types from an underlying input stream in a machine-independent way.

9. **DataOutputStream**: Writes primitive Java data types to an output stream in a portable way.

10. **ObjectInputStream**: Deserializes primitive data and objects previously written using ObjectOutputStream.

11. **ObjectOutputStream**: Serializes an object and sends it to an output stream.

12. **Files**: Provides utility methods for operating on files, such as creating, moving, copying, deleting files, and reading/writing file contents.

13. **Path**: Represents a file or directory path, providing methods for accessing information about the path, such as obtaining the file name or parent directory.

14. **File**: Provides methods for working with files and directories, such as creating, deleting, renaming files, and checking file properties.

These classes are fundamental for performing file I/O operations in Java applications, offering various functionalities to work efficiently with different types of data and file formats.



# the rest of my answer is on my repos 
https://github.com/Franck2000/programming-in-java.git
