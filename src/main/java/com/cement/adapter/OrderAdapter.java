package com.cement.adapter;

import com.cement.model.Order;

import java.util.List;

public interface OrderAdapter {
    List<Order> readOrder(String filePath);
}
