package abstractFactoryDesignPattern;

public class TesterFactory extends AbstractEmployeeFactory {

    @Override
    public Employee createEmployee() {
        return new Tester();
    }
}
