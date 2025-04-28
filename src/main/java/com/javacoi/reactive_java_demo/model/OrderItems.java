package com.javacoi.reactive_java_demo.model;

public record OrderItems(String sku, Double unitPrice, int quantity, double total) {
}
