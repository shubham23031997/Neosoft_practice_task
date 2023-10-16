package factoryDesignPattern.employee;

public class DeveloperClient {
    public static void main(String[] args) {
//        Employee employee=new AndroidDeveloper();
    //this is tightly coupled to resolve this problem we need factory design pattern
        Employee employee1=EmployeeFactory.getEmployee("android developer");

        System.out.println("salary :"+employee1.salary());

        Employee employee2=EmployeeFactory.getEmployee("web developer");

        System.out.println("salary :"+employee2.salary());


    }
}
