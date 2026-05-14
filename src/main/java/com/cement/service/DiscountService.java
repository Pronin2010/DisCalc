package com.cement.service;

import com.cement.model.Order;
import com.cement.model.BusinessData;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class DiscountService {


    public List<String> processOrders (List<Order> orders,
                                       int startDiscountPercent,
                                       int discountStep,
                                       int minDiscountPercent,
                                       int pricePer50Kg,
                                       int kgPerBag) {

        AtomicInteger currentDiscount = new AtomicInteger(startDiscountPercent);

        List<String> result = orders.stream()
                .sorted(Comparator.comparing(Order::getOrderTime))
                .map(order -> {
                    int discount = Math.max(currentDiscount.getAndUpdate(
                            v -> Math.max(v - discountStep, minDiscountPercent)
                    ), minDiscountPercent);

                    double pricePerKg = (double) pricePer50Kg / kgPerBag;
                    double cost = order.getCementKg() * pricePerKg * (1.0 - discount / 100.0);
                    return order.getCompanyName() + " - " + (int) cost;
                })
                .toList();
        return result;
    }
}
