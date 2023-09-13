public class Main {
    public static void main(String[] args) {
        // My First Java Project (Mortgage Calculator)
        int principal = (int) Console.processInput("Principal: ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.processInput("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.processInput("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculate(principal, annualInterestRate, years);
        var display = new MortgageDisplay(calculator);
        display.printMortgage();
        display.printPaymentSchedule();
    }
}
