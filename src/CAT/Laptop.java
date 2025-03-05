package CAT;

public class Laptop{
    public void start(){
        try{
            System.out.print("Starting up ");
            throw new Exception();
        } catch(Exception e){
            System.out.print(e.getMessage() == null ? "" : e.getMessage());
            System.exit(1);
        } finally{
            System.out.print("Shutting down ");
        }
    }

    public static void main(String[] args) {
        new Laptop().start();
    }
}
