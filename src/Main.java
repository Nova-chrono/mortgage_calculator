import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // My First Java Project (Mortgage Calculator)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int p = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float r = annualInterest / 12 / 100;

        System.out.print("Period: ");
        byte period = scanner.nextByte();
        int n = period * 12;

        double mortgage = p * (r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        NumberFormat mortgageCurrency = NumberFormat.getCurrencyInstance();
        String result = mortgageCurrency.format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}