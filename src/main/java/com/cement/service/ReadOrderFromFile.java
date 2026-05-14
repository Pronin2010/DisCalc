package com.cement.service;

import com.cement.adapter.RawOrderReaderAdapter;
import com.cement.adapter.TxtOrderReaderAdapter;
import com.cement.model.Order;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadOrderFromFile {
    public List<Order> readOrdersFromFile(String filePath) {
        try {
            String firstLine = Files.readAllLines(Path.of(filePath)).getFirst();
            if (firstLine.contains("|")) {
                return new TxtOrderReaderAdapter().readOrder(filePath);
            } else if (firstLine.contains("#")) {
                return new RawOrderReaderAdapter().readOrder(filePath);
            } else {
                throw new RuntimeException("Не найдены разделители");
            }
        } catch (Exception e){
            throw new RuntimeException("Не возможно прочитать файл: " + filePath);
        }
    }

}
