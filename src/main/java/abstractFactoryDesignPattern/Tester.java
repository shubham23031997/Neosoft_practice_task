package abstractFactoryDesignPattern;

public class Tester implements Employee {

    @Override
    public int salary() {
        return 6000;
    }

    @Override
    public String name() {
        System.out.println("hey QA tester");
        return "QATester";
    }
}
