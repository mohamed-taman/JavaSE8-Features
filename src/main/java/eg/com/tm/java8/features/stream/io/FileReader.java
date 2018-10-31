/*
 * Copyright (C) 2018 mohamed_taman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package eg.com.tm.java8.features.stream.io;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.System.*;

/**
 * This class shows how to read files using Java SE 8 stream for large and small files.
 * Also using other JDK libs to read files.
 * <p>
 * I have used sample file with size 1GB for all these. Reading such a large file in memory is not a good option,
 * I will cover various methods outlining How to read large file in Java line by line.
 * <p>
 * As we saw how to read a large file in Java efficiently. Few things which you need to pay close attention:
 * <p>
 * 1- Reading the large file in one go will not be a good option (You will get OutOfMemoryError ).
 * 2- I have Adapted technique to read large file line by line to keep memory footprint low.
 * 3- I used VisualVM to monitoring Memory, CPU and Thread-pool information while running these programmes.
 * <p>
 * based on our test, BufferReader has the lowest memory footprint, though the overall execution was slow.
 *
 * @author mohamed_taman
 */
public final class FileReader {

    private FileReader() {
    }


    /**
     * We will cover various options how to read a file in Java efficiently using plain Java API.
     * <p>
     * Output:
     * Max Memory Used : 258MB
     * Time Take : 100 Seconds
     *
     * @param fileName points to the file should be red.
     * @throws IOException in case of any IO exceptions.
     */
    public static void readLargeFileByBufferReader(final String fileName) throws IOException {

        try (BufferedReader fileBufferReader = new BufferedReader(new java.io.FileReader(fileName))) {
            String fileLineContent;
            while ((fileLineContent = fileBufferReader.readLine()) != null) out.println(fileLineContent);
        }
    }

    /**
     * Using Java 8 Stream API.
     * <p>
     * Output:
     * Max Memory Used : 390MB
     * Time Take : 60 Seconds
     *
     * @param fileName points to the file should be red.
     * @throws IOException in case of any IO exceptions.
     */
    public static void readLargeFileByStream(final String fileName) throws IOException {
        try (Stream inputStream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            inputStream.forEach(out::println);
        }
    }


    /**
     * Using Java Scanner, Java Scanner API also provides a way to read large file line by line.
     * <p>
     * Output:
     * Max Memory Used : 460MB
     * Time Take : 60 Seconds
     *
     * @param fileName points to the file should be red.
     * @throws IOException in case of any IO exceptions.
     */
    public static void readLargeFileByScanner(final String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(fileName);

        try (Scanner fileScanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            while (fileScanner.hasNextLine()) out.println(fileScanner.nextLine());
        }
    }

}
