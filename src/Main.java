public class Main {
    public static void main(String[] args) {

        EmployeeBook employees = new EmployeeBook();

        employees.addEmployee("Иванов Петр Алексеевич", 1, 45000);
        employees.addEmployee("Меркулов Сергей Денисович", 3, 76400);
        employees.addEmployee("Можайский Александр Васильевич", 2, 108000);
        employees.addEmployee("Алексеева Татьяна Николаевна", 4, 86000);
        employees.addEmployee("Завьялова Мария Константиновна", 5, 79350);
        employees.addEmployee("Березин Юрий Сергеевич", 5, 89800);
        employees.addEmployee("Кондратьев Лев Леонидович", 5, 68500);

        // a.
        System.out.println(employees);
        System.out.println();

        // b.
        System.out.println("Сумма затрат на зарплаты в месяц: " + employees.getMonthSalaries() + " рублей");
        System.out.println();

        // c.
        System.out.println("Сотрудник с минимальной зарплатой: " +
                employees.getEmployeeWithLowestSalary().getFullName());
        System.out.println();

        // d.
        System.out.println("Сотрудник с максимальной зарплатой: " +
                employees.getEmployeeWithHighestSalary().getFullName());
        System.out.println();

        // e.
        System.out.printf("Среднее значение зарплат: %.2f рублей\n", employees.getAverageSalary());
        System.out.println();

        // f.
        employees.printEmployeesFullName();
        System.out.println();

        //////////// Hard lvl ////////////

        // 1.
        employees.indexSalaries(7);
        System.out.println(employees);
        System.out.println();

        // 2a.
        int department = 5;
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + ": " +
                employees.getEmployeeWithLowestSalaryInDepartment(department).getFullName());
        System.out.println();

        // 2b.
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + ": " +
                employees.getEmployeeWithHighestSalaryInDepartment(department).getFullName());
        System.out.println();

        // 2c.
        System.out.println("Сумма затрат на зарплаты в месяц в отделе " + department + ": " +
                employees.getMonthSalariesInDepartment(department) + " рублей");
        System.out.println();

        // 2d.
        System.out.printf("Среднее значение зарплат в отделе " + department + ": %.2f рублей\n",
                employees.getAverageSalaryInDepartment(department));
        System.out.println();

        // 2e.
        employees.indexSalariesInDepartment(department, 5);

        // 2f.
        employees.printEmployeesInDepartment(department);
        System.out.println();

        // 3a.
        employees.printEmployeesWithSalaryLessThan(90000);
        System.out.println();

        // 3b.
        employees.printEmployeesWithSalaryMoreThan(85000);
        System.out.println();

        //////////// Very hard lvl ////////////

        // 4b.
        employees.deleteEmployee("Меркулов Сергей Денисович");
        employees.deleteEmployee(3);
        System.out.println(employees);
        System.out.println();

        // 5a.
        employees.changeSalary("Алексеева Татьяна Николаевна", 89900);
        System.out.println(employees);
        System.out.println();

        // 5b.
        employees.changeDepartment("Алексеева Татьяна Николаевна", 3);
        System.out.println(employees);
        System.out.println();

        // 6.
        employees.printEmployeesInDepartments();
    }
}