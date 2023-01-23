package application;

import entities.Customer;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        // Instantiate Customer
        String name;
        String email;
        LocalDate dateOfBirth;
        System.out.println("CUSTOMER DATA");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Date of birth (DD/MM/YYYY): ");
        dateOfBirth = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Customer customer = new Customer(name, email, dateOfBirth);
        System.out.println();

        // Instantiate Order
        System.out.println("ORDER DATA");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scanner.nextLine());
        Order order = new Order(LocalDateTime.now(), status, customer);

        System.out.print("Quantity of itens in order: ");
        int itemsInOrder = Integer.parseInt(scanner.nextLine());
        System.out.println();

        // Instantiate Products and OrderItems to fill order's list
        for (int i = 1; i <= itemsInOrder; i++) {
            String prodName;
            double prodPrice;
            int quantity;
            System.out.println("Item #" + i + " data");
            System.out.print("Product name: ");
            prodName = scanner.nextLine();
            System.out.print("Product price: ");
            prodPrice = Double.parseDouble(scanner.nextLine().replace(",","."));
            System.out.print("Quantity: ");
            quantity = Integer.parseInt(scanner.nextLine());

            Product product = new Product(prodName, prodPrice);
            OrderItem orderItem = new OrderItem(quantity, prodPrice, product);
            order.addItem(orderItem);
            System.out.println();
        }

        System.out.println("ORDER SUMMARY");
        System.out.println(order);
    }
}
