package com.cement.adapter;

import com.cement.model.Order;

import java.util.List;

public interface OrderReader {
    List<Order> readOrder(String filePath);
}
