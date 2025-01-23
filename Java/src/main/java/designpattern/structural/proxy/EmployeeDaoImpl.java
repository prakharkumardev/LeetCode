package designpattern.structural.proxy;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void createEmployee(String client, Employee employee) {
        System.out.println("Employee created");
    }

    @Override
    public void deleteEmployee(String client, int id) {
        System.out.println("Employee deleted");
    }

    @Override
    public EmployeeDao getEmployee(String client, int id) {
        System.out.println("Employee fetched");
        return null;
    }
}
