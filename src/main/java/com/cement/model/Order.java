package com.cement.model;

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime orderTime;
    private String companyName;
    private int cementKg;

        public Order (LocalDateTime orderTime, String companyName, int cementKg ) {
            this.orderTime = orderTime;
            this.companyName = companyName;
            this.cementKg = cementKg;
}

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCementKg() {
        return cementKg;
    }


}
