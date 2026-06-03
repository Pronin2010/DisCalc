package com.cement;

import com.cement.adapter.OrderAdapterFactory;
import com.cement.model.OrderDiscountParam;
import com.cement.service.DiscountService;
import com.cement.service.FileOrderService;
import com.cement.service.OrderManager;


public class Main {

    static void main(String[] args) {

        OrderDiscountParam orderDiscountParam = new OrderDiscountParam(
                500,
                50,
                50,
                5,
                0,
                "InputData/discount_day.txt",
                "OutputData/result.txt"
        );

        OrderAdapterFactory readOrder = new OrderAdapterFactory();
        FileOrderService writeResult = new FileOrderService();
        DiscountService discountService = new DiscountService();

        OrderManager orderManager = new OrderManager(readOrder, writeResult, discountService);
        orderManager.process(orderDiscountParam);


    }


}
