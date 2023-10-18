package abstractFactoryDesignPattern;

public class DeveloperFactory extends AbstractEmployeeFactory {

    @Override
    public Employee createEmployee() {
        return new Developer();
    }
}
