package ru.ncedu.java.tasks;

public class EmployeeImpl implements Employee {
    private int salary = 1000;
    private String name = "";
    private String surname = "";
    private Employee managerOfEmpl = null;
    private Employee topman = null;

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary = salary + value;
    }

    @Override
    public String getFirstName() {
        return name;
    }

    @Override
    public void setFirstName(String firstName) {
        name = firstName;
    }

    @Override
    public String getLastName() {
        return surname;
    }

    @Override
    public void setLastName(String lastName) {
        surname = lastName;
    }

    @Override
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public void setManager(Employee manager) {
        managerOfEmpl = manager;
    }

    @Override
    public String getManagerName() {
        String res = "No manager";
        if(managerOfEmpl != null){
            res = managerOfEmpl.getFirstName() + " " + managerOfEmpl.getLastName();
        }
        return res;
    }

    @Override
    public Employee getTopManager() {
        if(this.managerOfEmpl == null){
            topman = this;
        } else {
            topman = this.managerOfEmpl.getTopManager();
        }
        return topman;
    }

    public  static void main(String[] Args){
        Employee a = new EmployeeImpl();
        Employee b = new EmployeeImpl();
        Employee c = new EmployeeImpl();
        c.setFirstName("1c");
        c.setLastName("2c");
        b.setFirstName("1b");
        b.setLastName("2b");
        a.setFirstName("1a");
        a.setLastName("2a");
        b.setManager(a);
        a.setManager(c);
        System.out.println(b.getManagerName());
        System.out.println("________________");
        System.out.println(a.getManagerName());
        System.out.println("________________");
        System.out.println(b.getTopManager());
    }
}
