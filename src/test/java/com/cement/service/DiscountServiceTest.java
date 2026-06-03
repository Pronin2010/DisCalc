package com.cement.service;


import com.cement.model.Order;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiscountServiceTest {

    private DiscountService discountService = new DiscountService();

    @Test
    void returnEmptyList (){
        List<String> result = discountService.processOrders(
                List.of(),
                10,
                100,
                50,
                5,
                500
        );
        assertTrue(result.isEmpty());
    }
    @Test
    void discountForFirstOrder(){
        Order order = new Order(LocalDateTime.parse("2021-02-09T08:19:22"),
                "Company 1",
                100);
        List<String> result = discountService.processOrders(
                List.of(order),
                10,
                5,
                0,
                500,
                50);

        assertEquals(1, result.size());
        assertEquals("Company 1", result.get(0));
    }
    @Test
    void discountStepsForThreeOrders(){
        Order order1 = new Order(LocalDateTime.parse("2021-02-09T16:00:22"),
                "Company1",
                1000);
        Order order2 = new Order(LocalDateTime.parse("2021-03-09T16:00:22"),
                "Company2",
                1000);
        Order order3 = new Order(LocalDateTime.parse("2021-04-09T16:00:22"),
                "Company3",
                1000);

        List<String> result = discountService.processOrders(
                List.of(order1, order2, order3),
                15,
                10,
                5,
                500,
                50);

        assertEquals("Company1:8500", result.get(0));
        assertEquals("Company2:9500", result.get(1));
        assertEquals("Company3:9500", result.get(2));
    }
}