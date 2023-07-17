import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // My First Java Project (Mortgage Calculator)
        int principal = (int) processInput("Principal: ", 1000, 1_000_000);
        float annualInterestRate = (float) processInput("Annual Interest Rate: ", 1, 30);
        byte years = (byte) processInput("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, years);

        String mortgageResult = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageResult);
    }
    public static double processInput(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return value;
    }
    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte years) {

        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        short numberOfMonths = (short)(years * MONTHS_IN_YEAR);

        double mortgage;
        mortgage = principal *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
        return mortgage;
    }
}