package Taxation;

public class Main {
    public static void main(String[] args) {
        var tax1 = new TaxCalculator2018(100_000, 85000);
        var ReportTax = new TaxReport();
        ReportTax.show(tax1);

//        ReportTax.setCalculator(new TaxCalculator2025());
//        ReportTax.show(new TaxCalculator2025());
    }
}
