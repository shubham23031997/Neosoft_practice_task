package builderDesign;

import lombok.Getter;

@Getter
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    // Constructor is made private to enforce the use of the builder.
    private Person() {}

       public static class Builder {
        private final Person person = new Person();

        public Builder firstName(String firstName) {
            person.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            person.age = age;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}
