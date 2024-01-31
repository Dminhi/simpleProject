package service;

import ra.Department;
import ra.Employee;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class EmployeeService {
    DePartMentService dePartMentService = new DePartMentService();
    Scanner scanner = new Scanner(System.in);
    public static List<Employee> employeeList = new ArrayList<>();
    int idEmployee = 1;

    public void addEmployee() {
        Employee employee = new Employee();
        employee.inputData(scanner);
        employeeList.add(employee);
        employee.setEmployeeId(String.valueOf(idEmployee++));
        System.out.println("Thêm mới nhân viên thành công");
        Department department = employee.getDepartment();
        department.setTotalMembers(department.getTotalMembers() + 1);
    }

    public void displayEmployee() {
        employeeList.stream().forEach(Employee::displayData);
    }

    public void deleteEmployee(Scanner scanner) {
        System.out.println("Id nhân viên cần xoá");
        String deleteId = scanner.nextLine();
        Employee employee = null;
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(deleteId)) {
                employee = e;
            }
        }
        if (employee != null) {
            employeeList.remove(employee);
        } else {
            System.err.println("không tìm thấy");
        }
    }

    public void editEmployee() {
        System.out.println("Id nhân viên cần sửa");
        String editId = scanner.nextLine();
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(editId)) {
                e.inputData(scanner);
            }
        }
    }

    public Employee findEmployeeById() {
        System.out.println("Id nhân viên cần tìm");
        String findId = scanner.nextLine();
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(findId)) {
                e.displayData();
                return e;
            }
        } return null;
    }

    public void avgEmployeeInDepartment() {
        System.out.println(employeeList.size() / DePartMentService.departmentList.size());
    }

    public void findDepartmentMostEmployee() {
        DePartMentService.departmentList.sort((a, b) -> b.getTotalMembers() - a.getTotalMembers());
        if (DePartMentService.departmentList.size() > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.println(DePartMentService.departmentList.get(i).toString());
            }
        } else {
            for (int i = 0; i < DePartMentService.departmentList.size(); i++) {
                System.out.println(DePartMentService.departmentList.get(i).toString());
            }

        }
    }

    public void findMostSalaryEmloyee() {
        if (employeeList.size() > 5) {
            employeeList.sort(Comparator.comparing(Employee::getSalary));
            for (int i = 0; i < 5; i++) {
                System.out.println(employeeList.get(i).toString());
            }
        } else {
            employeeList.sort(Comparator.comparing(Employee::getSalary));
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println(employeeList.get(i).toString());
            }
        }
    }

    public void findMostAgeEmployee() {
        if (employeeList.size() > 5) {
            employeeList.sort((a, b) -> b.getBirthday().compareTo(a.getBirthday()));
            for (int i = 0; i < 5; i++) {
                System.out.println(employeeList.get(i).toString());
            }
        } else {
            employeeList.sort((a, b) -> b.getBirthday().compareTo(a.getBirthday()));
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println(employeeList.get(i).toString());
            }
        }
    }
    public void findMostManagerOfEmployee(){
        Map <Employee,Integer> integerMap = new HashMap<>();
        for (Employee e : employeeList) {
            if(e.getManager()!=null){
                integerMap.put(e.getManager(),integerMap.getOrDefault(e.getManager(),0)+1);
            }
        }
        Employee mostEmloyee = null;
        Integer count = 0;
        for (Map.Entry<Employee, Integer> employeeIntegerEntry : integerMap.entrySet()) {
            if(employeeIntegerEntry.getValue()>count){
                mostEmloyee = employeeIntegerEntry.getKey();
                count = employeeIntegerEntry.getValue();
            }
        }
        System.out.println(mostEmloyee);
    }
}