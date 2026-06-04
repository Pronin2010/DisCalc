package com.cement.model;

import java.time.LocalDateTime;

public record Order(LocalDateTime orderTime, String companyName, int cementKg) {
}
