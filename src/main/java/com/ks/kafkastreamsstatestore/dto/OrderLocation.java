package com.ks.kafkastreamsstatestore.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderLocation {
    private String orderNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public OrderLocation() {
    }

    public OrderLocation(String orderNumber, BigDecimal latitude, BigDecimal longitude) {
        this.orderNumber = orderNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLocation that = (OrderLocation) o;
        return orderNumber.equals(that.orderNumber) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, latitude, longitude);
    }

    @Override
    public String toString() {
        return "OrderLocation{" +
                "orderNumber='" + orderNumber + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
