package restaurant;

import restaurant.condiments.Sauce;
import restaurant.exceptions.TooManySaucesException;

import java.util.List;

public class Restaurant {

    public static void main(String[] args) {
        orderUp();
    }

    public static void orderUp() {
        try {
            Order order = new Order();
            order.setSauces(List.of(new Sauce("Kepsut"), new Sauce("Kepsut"), new Sauce("Kepsut"), new Sauce("Kepsut"), new Sauce("Kepsut")));

            handleOrder(order);
        } catch (TooManySaucesException tooManySaucesException) {
            System.out.println(tooManySaucesException.getMessage());
            return;
        }
    }

    public static void handleOrder(Order order) {
        // TODO:
    }

}
