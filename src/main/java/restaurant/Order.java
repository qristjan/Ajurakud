package restaurant;

import restaurant.condiments.Sauce;
import restaurant.exceptions.TooManySaucesException;

import java.util.List;

public class Order {

    private List<Sauce> sauces;

    public List<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(List<Sauce> sauces) throws TooManySaucesException {
        if (sauces != null && sauces.size() > 4) {
            throw new TooManySaucesException("Liiga palju kastmeid!!!");
        }
        this.sauces = sauces;
    }
}
