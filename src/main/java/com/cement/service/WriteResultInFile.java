package com.cement.service;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteResultInFile {


    public void writeResultInFile(List<String> result, String outputFilePath) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(outputFilePath)))) {
            result.forEach(writer::println);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось записать файл: " + outputFilePath, e);
        }
    }

}
