package abstractFactoryDesignPattern;

public class Manager implements Employee{

    @Override
    public int salary() {
        return 10000;
    }

    @Override
    public String name() {
        System.out.println("I'm a manager");
        return "manager";
    }
}
