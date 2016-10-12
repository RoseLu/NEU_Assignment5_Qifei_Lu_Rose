/**
 * Created by qiqi on 2016/10/11.
 */
public class Candy extends DessertItem {

    private double pound;
    private int pricePerPound;

    public Candy(String name, double pound, int pricePerPound) {
        super(name);
        this.pound = pound;
        this.pricePerPound = pricePerPound;
    }

    @Override
    public int getCost() {
        double cost = pound * pricePerPound;
        return (int) Math.round(cost);
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    public double getPound() {
        return pound;
    }
}
