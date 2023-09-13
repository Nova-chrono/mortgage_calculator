public class MortgageCalculate {
    private final static byte PERCENT = 100;
    private final static byte MONTHS_IN_YEAR = 12;

    private int principal;
    private float annualInterestRate;
    private byte years;

    public MortgageCalculate(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfMonths = getNumberOfMonths();

        double mortgage;
        mortgage = principal *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);

        return mortgage;
    }

    private double calculateBalance(short numberOfPaidMortgage) {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfMonths = getNumberOfMonths();

        double balanceDue;
        balanceDue = principal *
                ((Math.pow(1 + monthlyInterestRate, numberOfMonths))
                        - (Math.pow(1 + monthlyInterestRate, numberOfPaidMortgage)))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
        return balanceDue;
    }

    public double[] getBalances() {
        var balance = new double[getNumberOfMonths()];
        for (short month = 1; month <= getNumberOfMonths(); month++)
            balance[month - 1] = calculateBalance(month);
        return balance;
    }

    private short getNumberOfMonths() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / MONTHS_IN_YEAR / PERCENT;
    }
}
