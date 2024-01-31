package ra;

import service.DePartMentService;
import service.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private LocalDate birthday;
    private boolean sex;
    private BigDecimal salary;
    private Employee manager;
    private Department department;

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, BigDecimal salary, Employee manager, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
    }
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
    EmployeeService employeeService = new EmployeeService();

    public void inputData(Scanner scanner){
        System.out.println("Tên nhân viên");
        this.employeeName=scanner.nextLine();
        System.out.println("Ngày tháng năm sinh định dạng dd/MM/yyyy");
        this.birthday = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Giới tính");
        this.sex = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Lương cơ bản");
        this.salary = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Nhập id phòng ban");
        String idDepartment = scanner.nextLine();
        DePartMentService dePartMentService = new DePartMentService();
        this.department = dePartMentService.findDepartmentById(idDepartment);


        this.manager = employeeService.findEmployeeById();
    }
    public void displayData(){
        System.out.printf("Tên nhân viên: %s | Id Nhân viên %s | Ngày sinh : %s | Giới tính : %s | Lương cơ bản : %s | Người quản lý : %s | Phòng ban : %s \n",employeeName,employeeId,birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),sex?"Nam":"Nữ",salary,manager,department);
    }

    @Override
    public String toString() {
        return  employeeName;
    }
}
