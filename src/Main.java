import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;
    public static void main(String[] args) {
        // My First Java Project (Mortgage Calculator)
        int principal = (int) processInput("Principal: ", 1000, 1_000_000);
        float annualInterestRate = (float) processInput("Annual Interest Rate: ", 1, 30);
        byte years = (byte) processInput("Period (Years): ", 1, 30);

        printMortgage(principal, annualInterestRate, years);
        printPaymentSchedule(principal, annualInterestRate, years);
    }

    private static void printMortgage(int principal, float annualInterestRate, byte years) {
        double mortgage = calculateMortgage(principal, annualInterestRate, years);
        String mortgageResult = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment: " + mortgageResult);
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balanceDue = calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balanceDue));
        }
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

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        short numberOfMonths = (short)(years * MONTHS_IN_YEAR);

        double mortgage;
        mortgage = principal *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
        return mortgage;
    }

    public static double calculateBalance(
            int principal,
            float annualInterestRate,
            byte years,
            short numberOfPaidMortgage) {

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        short numberOfMonths = (short)(years * MONTHS_IN_YEAR);

        double balanceDue;
        balanceDue = principal *
                ((Math.pow(1 + monthlyInterestRate, numberOfMonths))
                        - (Math.pow(1 + monthlyInterestRate, numberOfPaidMortgage)))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
        return balanceDue;
    }
}