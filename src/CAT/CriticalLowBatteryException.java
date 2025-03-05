package CAT;

public class CriticalLowBatteryException extends Exception {
    public CriticalLowBatteryException(String message) {
        super(message);
    }
    public CriticalLowBatteryException() {
//        super();
        System.out.println("Your machine is in critical low battery!");
    }
}
