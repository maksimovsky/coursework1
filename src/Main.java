public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Петр Алексеевич", 1, 45000);
        employees[1] = new Employee("Меркулов Сергей Денисович", 3, 76400);
        employees[2] = new Employee("Можайский Александр Васильевич", 2, 108000);
        employees[3] = new Employee("Алексеева Татьяна Николаевна", 4, 86000);
        employees[4] = new Employee("Завьялова Мария Константиновна", 5, 79350);

        // a.
        printEmployeesList(employees);
        System.out.println();

        // b.
        System.out.println("Сумма затрат на зарплаты в месяц: " + getMonthSalaries(employees) + " рублей");
        System.out.println();

        // c.
        System.out.println("Сотрудник с минимальной зарплатой: " +
                getEmployeeWithLowestSalary(employees).getFullName());
        System.out.println();

        // d.
        System.out.println("Сотрудник с максимальной зарплатой: " +
                getEmployeeWithHighestSalary(employees).getFullName());
        System.out.println();

        // e.
        System.out.printf("Среднее значение зарплат: %.2f рублей\n", getAverageSalary(employees));
        System.out.println();

        // f.
        printEmployeesFullName(employees);
    }

    public static void printEmployeesList(Employee[] employees) {
        System.out.println("Список всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static double getMonthSalaries(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static Employee getEmployeeWithLowestSalary(Employee[] employees) {
        int employeeWithLowestSalary = 0;
        double minSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                employeeWithLowestSalary = i;
            }
        }
        return employees[employeeWithLowestSalary];
    }

    public static Employee getEmployeeWithHighestSalary(Employee[] employees) {
        int employeeWithHighestSalary = 0;
        double maxSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                employeeWithHighestSalary = i;
            }
        }
        return employees[employeeWithHighestSalary];
    }

    public static double getAverageSalary(Employee[] employees) {
        return getMonthSalaries(employees) / Employee.getIdCount();
    }

    public static void printEmployeesFullName(Employee[] employees) {
        System.out.println("ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}