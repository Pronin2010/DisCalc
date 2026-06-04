package com.cement.service;

import com.cement.adapter.OrderAdapterFactory;
import com.cement.model.OrderDiscountParam;
import com.cement.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
            private final OrderAdapterFactory readOrder;
            private final FileOrderService writeResult;
            private final DiscountService discountService;

            public OrderManager(OrderAdapterFactory readOrder,
                                     FileOrderService writeResult,
                                     DiscountService discountService) {
                this.readOrder = readOrder;
                this.writeResult = writeResult;
                this.discountService = discountService;
    }

    public void process(OrderDiscountParam orderDiscountParam) {
        List<Order> allOrders = new ArrayList<>();


        allOrders.addAll(readOrder.readOrdersFromFile(orderDiscountParam.getInputFilePath()));
        writeResult.write((discountService.processOrders(allOrders,
                        orderDiscountParam.getStartDiscountPercent(),
                        orderDiscountParam.getDiscountStep(),
                        orderDiscountParam.getMinDiscountPercent(),
                        orderDiscountParam.getPriceFor50Kg(),
                        orderDiscountParam.getKgPerBag())),
                orderDiscountParam.getResultFilePath());


        System.out.println("Расчет закончен : " + orderDiscountParam.getResultFilePath());
    }

}
