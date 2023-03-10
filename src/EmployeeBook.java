import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Arrays.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Список всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                out.append("\n").append(employee);
            }
        }
        return out.toString();
    }

    public void addEmployee(String fullName, int department, double salary) {
        Employee employee = new Employee(fullName, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            } else if (i == employees.length - 1) {
                System.out.println("\nМесто в книге кончилось!\n");
            }
        }
    }

    public void deleteEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
                break;
            } else if (i == employees.length - 1) {
                System.out.println("\nСотрудник не найден!\n");
            }
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                break;
            } else if (i == employees.length - 1) {
                System.out.println("\nСотрудник не найден!\n");
            }
        }
    }

    public void changeSalary(String fullName, double newSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i].setSalary(newSalary);
                break;
            } else if (i == employees.length - 1) {
                System.out.println("\nСотрудник не найден!\n");
            }
        }
    }

    public void changeDepartment(String fullName, int newDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i].setDepartment(newDepartment);
                break;
            } else if (i == employees.length - 1) {
                System.out.println("\nСотрудник не найден!\n");
            }
        }
    }

    public void printEmployeesInDepartments() {
        for (int i = 1; i <= 5; i++) {
            printEmployeesInDepartment(i);
        }
    }

    public double getMonthSalaries() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee getEmployeeWithLowestSalary() {
        int employeeWithLowestSalary = 0;
        double minSalary = 99_999_999;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                employeeWithLowestSalary = i;
            }
        }
        return employees[employeeWithLowestSalary];
    }

    public Employee getEmployeeWithHighestSalary() {
        int employeeWithHighestSalary = 0;
        double maxSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                employeeWithHighestSalary = i;
            }
        }
        return employees[employeeWithHighestSalary];
    }

    public double getAverageSalary() {
        return getMonthSalaries() / Employee.getIdCount();
    }

    public void printEmployeesFullName() {
        System.out.println("ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void indexSalaries(double percents) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + percents / 100));
            }
        }
    }

    public Employee getEmployeeWithLowestSalaryInDepartment(int department) {
        int employeeWithLowestSalary = 0;
        double minSalary = 99_999_999;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department &&
                    employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                employeeWithLowestSalary = i;
            }
        }
        return employees[employeeWithLowestSalary];
    }

    public Employee getEmployeeWithHighestSalaryInDepartment(int department) {
        int employeeWithHighestSalary = 0;
        double maxSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department &&
                    employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                employeeWithHighestSalary = i;
            }
        }
        return employees[employeeWithHighestSalary];
    }

    public double getMonthSalariesInDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double getAverageSalaryInDepartment(int department) {
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employeesCount++;
            }
        }
        return getMonthSalariesInDepartment(department) / employeesCount;
    }

    public void indexSalariesInDepartment(int department, double percents) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * (1 + percents / 100));
            }
        }
    }

    public void printEmployeesInDepartment(int department) {
        System.out.println("Список сотрудников отдела " + department + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id сотрудника: " + employee.getId() + ", ФИО: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() + " рублей");
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(double salary) {
        System.out.println("Сотрудники с зарплатой меньше " + salary + " рублей:");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("id сотрудника: " + employee.getId() + ", ФИО: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() + " рублей");
            }
        }
    }

    public void printEmployeesWithSalaryMoreThan(double salary) {
        System.out.println("Сотрудники с зарплатой больше " + salary + " рублей:");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("id сотрудника: " + employee.getId() + ", ФИО: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() + " рублей");
            }
        }
    }
}
