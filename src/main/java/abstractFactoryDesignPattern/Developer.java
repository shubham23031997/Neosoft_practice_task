package abstractFactoryDesignPattern;

public class Developer implements Employee {

    @Override
    public int salary() {
        return 5000;
    }

    @Override
    public String name() {
        System.out.println("I'm a java web developer");
        return "webDeveloper";
    }
}
