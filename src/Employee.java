import java.util.Objects;

public class Employee {
    private final String fullName;
    private int department;
    private double salary;
    private final int id;
    private static int idCount;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        idCount++;
        id = idCount;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getIdCount() {
        return idCount;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department);
    }

    @Override
    public String toString() {
        return "ФИО сотрудника: " + fullName + ", отдел: " + department + ", зарплата: " + salary + " рублей";
    }
}
