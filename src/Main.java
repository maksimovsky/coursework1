public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Петр Алексеевич", 1, 45000);
        employees[1] = new Employee("Меркулов Сергей Денисович", 3, 76400);
        employees[2] = new Employee("Можайский Александр Васильевич", 2, 108000);
        employees[3] = new Employee("Алексеева Татьяна Николаевна", 4, 86000);
        employees[4] = new Employee("Завьялова Мария Константиновна", 5, 79350);
        employees[5] = new Employee("Березин Юрий Сергеевич", 5, 89800);
        employees[6] = new Employee("Кондратьев Лев Леонидович", 5, 68500);

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
        System.out.println();

        //////////// Hard lvl ////////////

        // 1.
        indexSalaries(employees, 7);
        printEmployeesList(employees);
        System.out.println();

        // 2a.
        int department = 5;
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + ": " +
                getEmployeeWithLowestSalaryInDepartment(employees, department).getFullName());
        System.out.println();

        // 2b.
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + ": " +
                getEmployeeWithHighestSalaryInDepartment(employees, department).getFullName());
        System.out.println();

        // 2c.
        System.out.println("Сумма затрат на зарплаты в месяц в отделе " + department + ": " +
                getMonthSalariesInDepartment(employees, department) + " рублей");
        System.out.println();

        // 2d.
        System.out.printf("Среднее значение зарплат в отделе " + department + ": %.2f рублей\n",
                getAverageSalaryInDepartment(employees, department));
        System.out.println();

        // 2e.
        indexSalariesInDepartment(employees, department, 5);

        // 2f.
        printEmployeesInDepartment(employees, department);
        System.out.println();

        // 3a.
        printEmployeesWithSalaryLessThan(employees, 90000);
        System.out.println();

        // 3b.
        printEmployeesWithSalaryMoreThan(employees, 85000);
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
        double minSalary = 99_999_999;
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
        double maxSalary = 0;
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

    public static void indexSalaries(Employee[] employees, double percents) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + percents / 100));
            }
        }
    }

    public static Employee getEmployeeWithLowestSalaryInDepartment(Employee[] employees, int department) {
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

    public static Employee getEmployeeWithHighestSalaryInDepartment(Employee[] employees, int department) {
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

    public static double getMonthSalariesInDepartment(Employee[] employees, int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static double getAverageSalaryInDepartment(Employee[] employees, int department) {
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employeesCount++;
            }
        }
        return getMonthSalariesInDepartment(employees, department) / employeesCount;
    }

    public static void indexSalariesInDepartment(Employee[] employees, int department, double percents) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * (1 + percents / 100));
            }
        }
    }

    public static void printEmployeesInDepartment(Employee[] employees, int department) {
        System.out.println("Список сотрудников отдела " + department + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id сотрудника: " + employee.getId() + ", ФИО: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() + " рублей");
            }
        }
    }

    public static void printEmployeesWithSalaryLessThan(Employee[] employees, double salary) {
        System.out.println("Сотрудники с зарплатой меньше " + salary + " рублей:");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("id сотрудника: " + employee.getId() + ", ФИО: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() + " рублей");
            }
        }
    }

    public static void printEmployeesWithSalaryMoreThan(Employee[] employees, double salary) {
        System.out.println("Сотрудники с зарплатой больше " + salary + " рублей:");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("id сотрудника: " + employee.getId() + ", ФИО: " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() + " рублей");
            }
        }
    }
}