package Exceptions;

public class HandlingExceptions {
    public static void demopray(String message){
        try{
            if(message==null){
                throw new NullPointerException("demo");
            }
        } catch (NullPointerException e){
            throw e; // return the exception
        }
    }

    public static void main(String[] args) {
       try {
           String name = null;
           demopray(name);
       } catch (NullPointerException e) {
            System.out.println("Recaught: "+ e);
        }
    }
}
