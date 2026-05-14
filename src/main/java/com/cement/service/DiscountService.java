package com.cement.service;

import com.cement.model.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DiscountService {


    public List<String> processOrders(List<Order> orders,
                                      int startDiscountPercent,
                                      int discountStep,
                                      int minDiscountPercent,
                                      int pricePer50Kg,
                                      int kgPerBag) {

        int currentDiscount = startDiscountPercent;
        List<String> result = new ArrayList<>();
        orders.sort(Comparator.comparing(Order::orderTime));

        for (Order order : orders) {
            int discount = Math.max(currentDiscount, minDiscountPercent);
            currentDiscount = Math.max(currentDiscount - discountStep, minDiscountPercent);

            double costForOneKg = (double) pricePer50Kg / kgPerBag;
            double costForOrder = order.cementKg() * costForOneKg * (1.0 - discount / 100.0);
            result.add(order.companyName() + ":" + (int) costForOrder);
        }
        return result;
    }
}
