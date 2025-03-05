package Taxation;

public class TaxCalculator2024 extends AbstractTaxCalculator {
    private double income;

    public TaxCalculator2024(double income) {
        this.income = income;
    }

    @Override
    public double calculateTax(){
        return income * 0.05;
    }
}
