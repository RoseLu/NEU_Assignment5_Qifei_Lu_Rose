/**
 * Created by qiqi on 2016/10/11.
 */
public class Cookie extends DessertItem {
    private int number;
    private int pricePerDozen;

    public Cookie(String name, int number, int pricePerPound) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerPound;
    }

    @Override
    public int getCost() {
        int cost = number * pricePerDozen / 12;
        return (int) Math.round(cost);
    }

    public int getNumber() {
        return number;
    }

    public int getPricePerDozen() {
        return pricePerDozen;
    }
}
