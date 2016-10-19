import java.util.Vector;

/**
 * Created by qiqi on 2016/10/11.
 */
public class Checkout {
    private Vector<DessertItem> lists;
    private final double taxRate;

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
        int width = 30;
        for (int i = 0; i < (width - DessertShoppe.storeName.length()) / 2; i++) sb.append(" ");
        sb.append(DessertShoppe.storeName + "\n");
        for (int i = 0; i < (width - DessertShoppe.storeName.length()) / 2; i++) sb.append(" ");
        sb.append("--------------------" + "\n");
        StringBuilder eachItem = new StringBuilder();
        for (DessertItem item: lists) {
            if (item instanceof Candy) {
                eachItem.append(((Candy) item).getPound() + " lbs. @ " + DessertShoppe.cents2dollarsAndCents(((Candy) item).getPricePerPound()) + " /lb." + "\n");
                eachItem.append(item.getName());
                String dollar = DessertShoppe.cents2dollarsAndCents(item.getCost());
                for (int i = 0; i < width - item.getName().length() - dollar.length(); i++) eachItem.append(" ");
                eachItem.append(dollar + "\n");
            } else if (item instanceof Cookie) {
                eachItem.append(((Cookie) item).getNumber() + " @ " + DessertShoppe.cents2dollarsAndCents(((Cookie) item).getPricePerDozen()) + " /dz." + "\n");
                eachItem.append(item.getName());
                String dollar = DessertShoppe.cents2dollarsAndCents(item.getCost());
                for (int i = 0; i < width - item.getName().length() - dollar.length(); i++) eachItem.append(" ");
                eachItem.append(dollar + "\n");
            } else if (item instanceof Sundae){
                sb.append(((Sundae) item).getToppingName() + " Sundae with" + "\n");
                sb.append(item.getName());
                String dollar = DessertShoppe.cents2dollarsAndCents(item.getCost());
                for (int i = 0; i < width - item.getName().length() - dollar.length(); i++) eachItem.append(" ");
                eachItem.append(dollar + "\n");
            } else if (item instanceof IceCream) {
                sb.append(item.getName());
                String dollar = DessertShoppe.cents2dollarsAndCents(item.getCost());
                for (int i = 0; i < width - item.getName().length() - dollar.length(); i++) eachItem.append(" ");
                eachItem.append(dollar + "\n");
            }
            sb.append(eachItem);
            eachItem = new StringBuilder();
        }
        sb.append("\n");
        sb.append("Tax" );
        String tax = DessertShoppe.cents2dollarsAndCents(totalTax());
        for (int i = 0; i < width - 3 - tax.length(); i++) sb.append(" ");
        sb.append(tax + "\n"+ "Total Cost");
        String cost = DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax());
        for (int i = 0; i < width - 10 - cost.length(); i++) sb.append(" ");
        sb.append(cost);
        return new String(sb);
    }
}
