import java.util.ArrayList;

public class Meal {
    String name;
    double price;
    String[] sides;

    public Meal(String n, double p, String[] s)
    {
        name = n;
        price = p;
        sides = s;
    }

    public double getPrice() {
        return price;
    }

    public String[] getSides() {
        return sides;
    }
}
