import java.util.Vector;

/**
 * Created by qiqi on 2016/10/11.
 */
public class Checkout {
    private Vector<DessertItem> lists;
    protected final double taxRate;

    public Checkout() {
        lists = new Vector<>();
        taxRate = DessertShoppe.TAX_RATE;
    }

    public int numberOfItems() {
        return lists.size();
    }

    public void enterItem(DessertItem item) {
        lists.add(item);
    }

    public void clear() {
        lists.clear();
    }

    public int totalCost() {
        int total = 0;
        for (DessertItem item: lists) {
            total += item.getCost();
        }
        return total;
    }

    public int totalTax() {
        return (int) Math.round(totalCost() * taxRate / 100);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DessertShoppe.storeName + "\n");
        sb.append("--------------------" + "\n");
        for (DessertItem item: lists) {
            if (item instanceof Candy) {
                sb.append(((Candy) item).getPound() + " lbs. @ " + DessertShoppe.cents2dollarsAndCents(((Candy) item).getPricePerPound()) + " /lb." + "\n");
                sb.append(item.getName() + "    " + DessertShoppe.cents2dollarsAndCents(item.getCost()) + "\n");
            } else if (item instanceof Cookie) {
                sb.append(((Cookie) item).getNumber() + " @ " + DessertShoppe.cents2dollarsAndCents(((Cookie) item).getPricePerDozen()) + " /dz." + "\n");
                sb.append(item.getName() + "    " + DessertShoppe.cents2dollarsAndCents(item.getCost()) + "\n");
            } else if (item instanceof Sundae){
                sb.append(((Sundae) item).getToppingName() + " Sundae with" + "\n");
                sb.append(item.getName() + "    " + DessertShoppe.cents2dollarsAndCents(item.getCost()) + "\n");
            } else if (item instanceof IceCream) {
                sb.append(item.getName() + "    " + DessertShoppe.cents2dollarsAndCents(item.getCost()) + "\n");
            }
        }
        sb.append("\n");
        sb.append("Tax        " + DessertShoppe.cents2dollarsAndCents(totalTax()) + "\n");
        sb.append("Total Cost        " + DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()) + "\n");
        return new String(sb);
    }
}
