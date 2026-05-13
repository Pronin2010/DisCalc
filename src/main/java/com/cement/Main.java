package com.cement;


import com.cement.adapter.RawOrderReaderAdapter;
import com.cement.adapter.TxtOrderReaderAdapter;
import com.cement.model.Order;
import com.cement.service.DiscountService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static void main(String[] args) {

        String inputFilePath = "InputData/discount_day.txt";
        String resultFilePath = "OutputData/result.txt";

        List<Order> allOrders = new ArrayList<>();
        allOrders.addAll(readOrdersFromFile(inputFilePath));

        DiscountService discountService = new DiscountService();
        discountService.processOrders(allOrders, resultFilePath);

        System.out.println("Расчет закончен : " + resultFilePath);
    }

    private static List<Order> readOrdersFromFile(String filePath) {
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
