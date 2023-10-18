package abstractFactoryDesignPattern;

public class Main {
    public static void main(String[] args) {
        Employee e1 = EmployeeFactory.getEmployee(new DeveloperFactory());
        e1.name();
        Employee e2 = EmployeeFactory.getEmployee(new TesterFactory());
        e2.name();
        Employee e3=EmployeeFactory.getEmployee(new ManagerFactory());
        e3.name();
    }
}
