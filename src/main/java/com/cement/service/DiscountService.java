package com.cement.service;

import com.cement.model.Order;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DiscountService {
    private static final int PRICE_PER_50_KG = 500;
    private static final int KG_IN_BAG = 50;
    private static final int START_DISCOUNT_PERCENT = 50;
    private static final int DISCOUNT_STEP = 5;
    private static final int MIN_DISCOUNT_PERCENT = 0;

    public void processOrders(List<Order> orders, String outputFilePath){
        AtomicInteger currentDiscount = new AtomicInteger(START_DISCOUNT_PERCENT);

        List<String> result = orders.stream()
                .sorted(Comparator.comparing(order -> order.getOrderTime()))
                .map(order -> {
                    int discount = Math.max(currentDiscount.getAndUpdate(
                            v -> Math.max(v - DISCOUNT_STEP, MIN_DISCOUNT_PERCENT)
                    ), MIN_DISCOUNT_PERCENT);

                    double pricePerKg = (double) PRICE_PER_50_KG / KG_IN_BAG;
                    double cost = order.getCementKg() * pricePerKg * (1.0 - discount / 100.0);
                    return order.getCompanyName() + " - " + (int) cost;
                })
                .toList();
        writeResult(result,outputFilePath);
    }

    private void writeResult(List<String> result, String outputFilePath) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(outputFilePath)))) {
                result.forEach(writer::println);
        } catch (Exception e) {
                throw new RuntimeException("Не удалось записать файл: " + outputFilePath, e);
         }
    }
}
