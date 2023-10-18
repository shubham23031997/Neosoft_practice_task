package abstractFactoryDesignPattern;

public class EmployeeFactory {
    public static Employee getEmployee(AbstractEmployeeFactory abstractEmployeeFactory) {
        return abstractEmployeeFactory.createEmployee();
    }
}
