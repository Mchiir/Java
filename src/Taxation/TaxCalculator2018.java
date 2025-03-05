package Taxation;

public class TaxCalculator2018 extends AbstractTaxCalculator {
    private double taxableIncome;
    private double income;
    private double expenses;

    public TaxCalculator2018(double income, double expenses) {
        this.income = income;
        this.expenses = expenses;
    }

    @Override
    public double calculateTax() {
        this.taxableIncome =  getTaxableIncome(this.income, this.expenses);
        return this.taxableIncome * 0.3;
    }
}
