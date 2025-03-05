package CAT;

public class Calculation {
    int addition(){
        int a=5; int b=10;
        return a+b;
    }
    int addition(int a, int b){
        return a+b;
    }
    int addition(int a, int b, int c){
        return a+b+c;
    }
    double addition(double d, double e){
        return d+e;
    }

    public static void main(String[] args){
        Calculation cal = new Calculation();
        System.out.println(cal.addition(10.5,30.0));
    }
}
