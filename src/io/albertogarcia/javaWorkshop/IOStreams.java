package io.albertogarcia.javaWorkshop;

import java.io.*;
import java.nio.file.*; // New/Better implementation of File/FileReader, see newBuffReader
import java.util.List;

public class IOStreams {

    public void buffWriter() throws IOException {
        String[] data = {"Line 1", "Line 2 2", "Line 3 3 3", "Line 4 4 4 4"};

        // Example of try-with-resources. Calls AutoClosable interface so that
        // stream is safely closed. The alternative would be defining the
        // catch.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("file1.txt"))) {
            for (String d:data) {
                bw.write(d);
                bw.newLine();
            }
        }
    }

    public void buffReader() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        }
    }

    public void newBuffReader() throws  IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get("file1.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        }
    }

    public void readAllLines() throws IOException{
        // Careful with Files.readAllLines, you have to consider how large the data is and memory.
        List<String> list = Files.readAllLines(Paths.get("file1.txt"));
        System.out.println("In readAllLines()");
        for (String str:list) {
            System.out.println(str);
        }
    }
}
