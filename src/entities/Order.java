package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
    private LocalDateTime orderTime;
    private OrderStatus status;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public Order(LocalDateTime orderTime, OrderStatus status, Customer customer) {
        this.orderTime = orderTime;
        this.status = status;
        this.customer = customer;
    }
    public void addItem(OrderItem item) {
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }
    public Double total(){
        double total = 0;
        for (OrderItem item : items) {
            total += item.subTotal();
        }
        return total;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public List<OrderItem> getItems() {
        return items;
    }


    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order time: " + DATE_TIME_FORMATTER.format(getOrderTime()) + "\n")
                .append("Order status: " + getStatus() + "\n")
                .append("Customer: " + getCustomer() + "\n")
                .append("Order itens: " + "\n");
        for (OrderItem item : getItems())
            sb.append(item);
        sb.append("Total price: $" + String.format("%.2f", total()));
        return sb.toString();
    }
}
