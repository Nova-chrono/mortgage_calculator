import java.text.NumberFormat;

public class MortgageDisplay {

    private MortgageCalculate calculator;

    public MortgageDisplay(MortgageCalculate calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(double balance : calculator.getBalances())
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageResult = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment: " + mortgageResult);
    }
}
