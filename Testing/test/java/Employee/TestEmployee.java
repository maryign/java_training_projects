package Testing.test.java.Employee;

import Testing.main.java.Employee.EmployeeImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Mari on 26.09.2016.
 */
public class TestEmployee {

    EmployeeImpl e1 = new EmployeeImpl();
    int sal = 1000;
    EmployeeImpl manager = new EmployeeImpl();
    EmployeeImpl topmanager = new EmployeeImpl();

    @Test
    public void testGetSalary() {
        assertTrue(e1.getSalary() == sal);
    }

    @Test
    public void testIncreaseSalary() {

//        e1.increaseSalary(sal);
//        assertTrue(e1.getSalary() == 1000 + sal);
//        e1.increaseSalary(-sal);
//        assertTrue(e1.getSalary() == 1000 - sal);
        sal = 0;
        e1.increaseSalary(-sal);
        assertTrue(e1.getSalary() == 1000 + sal);
    }

    @Test
    public void testGetSetNames() {
        e1.setFirstName("Ivan");
//        e1.setFirstName(null);
//        assertTrue("False1", e1.getFirstName().equals(null));
        e1.setLastName("Ivanov");
        assertTrue("False1", e1.getFirstName().equals("Ivan"));
        assertTrue("False2", e1.getLastName().equals("Ivanov"));
        assertTrue("False3", e1.getFullName().equals("Ivan Ivanov"));
    }

    @Test
    public void testManager() {
        e1.setFirstName("Ivan");
        e1.setLastName("Ivanov");
        assertTrue((e1.getManagerName()).equals("No manager"));
        manager.setFirstName("Petr");
        manager.setLastName("Petrov");
        e1.setManager(manager);
        assertTrue("False1", e1.getManagerName().equals(manager.getFullName()));
    }

    @Test
    public void testTopManager() {
        e1.setFirstName("Ivan");
        e1.setLastName("Ivanov");
        manager.setFirstName("Petr");
        manager.setLastName("Petrov");
        topmanager.setFirstName("Dmitrii");
        topmanager.setLastName("Dmitiev");
        e1.setManager(manager);
        manager.setManager(topmanager);
        assertTrue("False1", (e1.getTopManager().getFullName()).equals(topmanager.getFullName()));
    }
}
