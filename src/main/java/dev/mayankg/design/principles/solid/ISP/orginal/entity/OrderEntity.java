package dev.mayankg.design.principles.solid.ISP.orginal.entity;

import java.time.LocalDateTime;

//OrderEntity entity class
class OrderEntity extends Entity {
    private LocalDateTime orderPlacedOn;
    private double totalValue;

    public LocalDateTime getOrderPlacedOn() {
        return orderPlacedOn;
    }

    public void setOrderPlacedOn(LocalDateTime orderPlacedOn) {
        this.orderPlacedOn = orderPlacedOn;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}