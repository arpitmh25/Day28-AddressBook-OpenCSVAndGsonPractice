package com.bridgelabz.day28;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class OpenCSVReader {
    public static final String CSV_FILE_PATH = "./users.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            List<String[]> records = null;
            try {
                records = csvReader.readAll();
            } catch (CsvException e) {
                e.printStackTrace();
            }
            for (String[] record : records) {
                System.out.println("Name: " + record[0]);
                System.out.println("Email: " + record[1]);
                System.out.println("Phone: " + record[2]);
                System.out.println("Country: " + record[3]);
                System.out.println("==================");
            }
        }
    }
}