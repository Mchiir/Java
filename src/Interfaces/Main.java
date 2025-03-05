package Interfaces;

public class Main {
    public static void main(String[] args) {
//        var taxCalc = new TaxCalculator2020(100_000);
//        var taxReport = new TaxReport(taxCalc);
//        taxReport.show();
//        var taxCalc2 = new TaxCalculator2022(100_000);
//        taxReport.setCanCalculateTax(taxCalc2);
//        taxReport.show();

        var taxReport = new TaxReport();
        var taxCalc = new TaxCalculator2020(100_000);
        taxReport.show(taxCalc);
        taxReport.show(new TaxCalculator2022(100_000));
    }
}