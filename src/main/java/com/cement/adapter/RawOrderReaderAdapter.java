package com.cement.adapter;

import com.cement.model.Order;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RawOrderReaderAdapter implements OrderReader {
    private static final String DELIMITER = "#";

    @Override
    public List<Order> readOrder(String filePath) {
        try {
            return Files.lines(Path.of(filePath))
                    .map(line -> line.split(DELIMITER))
                    .filter(parts -> parts.length == 3)
                    .map(parts -> new Order(
                            LocalDateTime.parse(parts[0].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")),
                            parts[1].trim(),
                            Integer.parseInt(parts[2])
                    ))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Не удалось прочитать файл: " + filePath);
        }
    }
}
