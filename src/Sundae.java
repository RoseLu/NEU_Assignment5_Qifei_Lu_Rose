
/**
 * Created by qiqi on 2016/10/11.
 */
public class Sundae extends IceCream {
    private String toppingName;
    private int toppingCost;

    public Sundae(String iceCreamName, int iceCreamCost, String toppingName, int toppingCost) {
        super(iceCreamName, iceCreamCost);
        this.toppingName = toppingName;
        this.toppingCost = toppingCost;
    }

    @Override
    public int getCost() {
        return super.getCost() + toppingCost;
    }

    public String getToppingName() {
        return toppingName;
    }
}
