package Testing.main.java.Employee;

/**
 * Created by Mari on 26.02.2016.
 */
public class EmployeeImpl implements Employee {

    private String FirstName;
    private String LastName;
    private int Salary = 1000;
    Employee manager;


    public EmployeeImpl() {
    }


    @Override
    public int getSalary() {
        return Salary;
    }

    @Override
    public void increaseSalary(int value) {
        Salary = getSalary() + value;

    }

    @Override
    public String getFirstName() {
        return FirstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    @Override
    public String getLastName() {
        return LastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    @Override
    public String getFullName() {
        return FirstName + " " + LastName;
    }

    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String getManagerName() {
        if (this.manager == null) {
            return "No manager";
        } else
            return this.manager.getFullName();
    }

    @Override
    public Employee getTopManager() {
        if (this.manager != null)
            return manager.getTopManager();
        else
            return this;
    }


    public static void main(String[] args) {
        EmployeeImpl emp = new EmployeeImpl();
        emp.FirstName = "Ivan";
        emp.LastName = "Smirnov";
        EmployeeImpl manag = new EmployeeImpl();
        manag.FirstName = "Anna";
        manag.LastName = "Smirnova";
        EmployeeImpl top = new EmployeeImpl();
        top.FirstName = "Mari";
        top.LastName = "Ivanova";
        System.out.println(emp.getFullName());
        System.out.println(emp.getSalary());
        emp.increaseSalary(1300);
        System.out.println(emp.getSalary());
        emp.setManager(manag);
        manag.setManager(top);
        System.out.println(emp.getManagerName());
        System.out.println(emp.getTopManager().getFullName());

    }
}
