package app.oop.Citizenship;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Citizens {
    public static Boolean validateEmail(String email){
        String cleanEmail = email.replace(" ", "");
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex);

        return p.matcher(cleanEmail).matches();
    }
    public static Boolean validatePhone(String phone){
        String cleanTel = phone.replace(" ", "");
        String regex = "^((\\+2507[2389]\\d{7})|(07[2389]\\d{7}))$";

        return cleanTel.matches(regex);
    }
    public static Boolean validateName(String name){
        String regex = "^[a-zA-Z ]+$";
        Pattern p = Pattern.compile(regex);

        return p.matcher(name).matches();
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", "alice@example.com", "0781234567"));
        people.add(new Person("Bob", "bob@invalid", "12345"));
        people.add(new Person("Carol", "carol@example.com", "0799876543"));

        Name name = Citizens::validateName;
        Email email = Citizens::validateEmail;
        Telephone phone = Citizens::validatePhone;

        List<Person> validPeople = new ArrayList<>();
        List<Person> invalidPeople = new ArrayList<>();
        people.forEach(person -> {
            if(validateName(person.getName()) &&
                    validateEmail(person.getEmail()) &&
                    validatePhone(person.getTelephone()) ){
                        validPeople.add(person);
                    }else{
                    invalidPeople.add(person);
                }
        });

        System.out.println("List of valid people:");
        validPeople.forEach(System.out::println);
        System.out.println("\nList of invalid people:");
        invalidPeople.forEach(System.out::println);
    }
}
