/**
 * Created by qiqi on 2016/10/11.
 */
public class DessertShoppe {
    protected static final double TAX_RATE = 6.5;
    public static final String storeName = "M & M Dessert Shoppe";
    public int maximumSizeOfItemName = 50;
    public int widthOfCost = 8;

    public static String cents2dollarsAndCents(int cent) {
        StringBuilder sb = new StringBuilder();
        int numberBeforeDecimal = cent / 100;
        int numberAfterDecimal = cent % 100;
        sb.append(numberBeforeDecimal <= 0? "" : numberBeforeDecimal);
        sb.append(".");
        sb.append(numberAfterDecimal < 10? "0" + numberAfterDecimal: numberAfterDecimal);
        return new String(sb);
    }
}
