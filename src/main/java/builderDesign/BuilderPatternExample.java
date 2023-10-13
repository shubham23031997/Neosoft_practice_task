package builderDesign;

public class BuilderPatternExample {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .firstName("shubham")
                .lastName("mali")
                .age(25)
                .build();

        System.out.println("First Name: " + person.getFirstName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Age: " + person.getAge());
    }
}

