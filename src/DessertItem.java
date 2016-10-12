/**
 * Created by qiqi on 2016/10/11.
 */
public abstract class DessertItem {
    private String name;
    public DessertItem() {
    }
    public DessertItem(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public abstract int getCost();
}
