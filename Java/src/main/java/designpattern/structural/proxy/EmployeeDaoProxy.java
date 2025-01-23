package designpattern.structural.proxy;

public class EmployeeDaoProxy  implements EmployeeDao {
    private EmployeeDao employeeDao;

    public EmployeeDaoProxy(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void createEmployee(String client, Employee employee) {
        if(!client.equals("admin")) {
            System.out.println("You are not authorized to create employee");
            return;
        }
        System.out.println("Employee created");
    }

    @Override
    public void deleteEmployee(String client, int id) {
        if(!client.equals("admin")) {
            System.out.println("You are not authorized to delete employee");
            return;
        }
        System.out.println("Employee deleted");
    }

    @Override
    public EmployeeDao getEmployee(String client, int id) {
        if (!client.equals("admin") && !client.equals("client")) {
            System.out.println("You are not authorized to fetch employee");
            return null;
        }
        System.out.println("Employee fetched");
        return null;
    }
}
