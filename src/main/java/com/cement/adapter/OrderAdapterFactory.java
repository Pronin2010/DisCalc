package com.cement.adapter;

import com.cement.CastomExceptions.IORuntimeException;
import com.cement.model.Order;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OrderAdapterFactory {
    public List<Order> readOrdersFromFile(String filePath) {
        try {
            String firstLine = Files.readAllLines(Path.of(filePath)).getFirst();
            if (firstLine.contains("|")) {
                return new TxtOrderAdapter().readOrder(filePath);
            } else if (firstLine.contains("#")) {
                return new RawOrderAdapter().readOrder(filePath);
            } else {
                throw new RuntimeException("Не найдены разделители");
            }
        } catch (Exception e) {
            throw new IORuntimeException("Не возможно прочитать файл: " + filePath);
        }
    }

}
