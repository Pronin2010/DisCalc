package com.cement.service;

import com.cement.adapter.OrderAdapterFactory;
import com.cement.model.Order;
import com.cement.model.OrderDiscountParam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

class OrderManagerTest {
    @Mock
    private OrderAdapterFactory readOrder;
    @Mock
    private FileOrderService writeResult;
    @Mock
    private DiscountService discountService;
    @InjectMocks
    private OrderManager orderManager;


    @Test
    void shouldProcessOrdersAndWriteResult() {
        OrderDiscountParam params = new OrderDiscountParam(
                500,
                50,
                50,
                5,
                0,
                "InputData/discount_day.txt",
                "OutputData/result.txt");

        Order order1 = new Order(LocalDateTime.parse("2021-02-09T08:19:22"),
                "Company 1",
                12345);
        Order order2 = new Order(LocalDateTime.parse("2021-03-09T12:19:22"),
                "Company 2",
                64322);

        List<Order> ordersFromFile = List.of(order1, order2);
        when(readOrder.readOrdersFromFile(params.getInputFilePath())).thenReturn(ordersFromFile);

        List<String> processedOrders = List.of(
                "Company 1:12345",
                "Company 2:545747",
                "Company 3:755464",
                "Company 4");
        when(discountService.processOrders(
                ordersFromFile,
                50,
                5,
                0,
                500,
                50
        )).thenReturn(processedOrders);


        orderManager.process(params);


        verify(readOrder).readOrdersFromFile(params.getInputFilePath());


        verify(discountService).processOrders(
                ordersFromFile,
                50,
                5,
                0,
                500,
                50);


        verify(writeResult).write(processedOrders, params.getResultFilePath());


        verifyNoMoreInteractions(readOrder, discountService, writeResult);
    }

}