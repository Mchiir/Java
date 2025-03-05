package Interfaces;

import java.text.NumberFormat;
import java.util.Locale;

public class TaxReport {

//    private CanCalculateTax canCalculateTax;
//
//    public TaxReport(CanCalculateTax taxCalculator) {// cons dep injection
//        this.canCalculateTax = taxCalculator;
//    }

    public void show(CanCalculateTax calculator){ // method inj
        NumberFormat formatter = NumberFormat.getInstance(Locale.US); // Ensures #,### format
        System.out.println("Your tax is "+ formatter.format(calculator.calculateTax()));
    }

//    public void setCanCalculateTax(CanCalculateTax canCalculateTax) { // set inj
//        this.canCalculateTax = canCalculateTax;
//    }
}
