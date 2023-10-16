package factoryDesignPattern.employee;

public class AndroidDeveloper implements Employee{

    @Override
    public int salary() {
        System.out.println("getting android developer salary");
        return 50000;
    }
}
