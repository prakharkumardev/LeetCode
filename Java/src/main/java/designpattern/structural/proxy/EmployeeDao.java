package designpattern.structural.proxy;

public interface EmployeeDao {
    public void createEmployee(String client, Employee employee);
    public void deleteEmployee(String client,int id);
    public EmployeeDao getEmployee(String client,int id);

}
