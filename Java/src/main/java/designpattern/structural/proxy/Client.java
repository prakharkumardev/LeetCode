package designpattern.structural.proxy;

public class Client {
    public static void main(String[] args) {
        EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
        EmployeeDao employeeDao = new EmployeeDaoProxy(employeeDaoImpl);
        employeeDao.createEmployee("client", new Employee("John", 1, 25));
        employeeDao.deleteEmployee("client", 1);
        employeeDao.getEmployee("client", 1);

        employeeDao.createEmployee("admin", new Employee("John", 1, 25));
        employeeDao.createEmployee("admin", new Employee("Mars", 2, 23));
        employeeDao.deleteEmployee("admin", 2);
        employeeDao.getEmployee("admin", 1);
        employeeDao.getEmployee("client", 1);

    }
}
