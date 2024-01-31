package service;

import ra.Department;
import ra.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DePartMentService {
    Scanner scanner = new Scanner(System.in);
    public static List<Department> departmentList = new ArrayList<>();
    int idDepartment = 1;

    public void displayDepartment() {
        for (Department d : departmentList) {
            d.displayData();
        }
    }

    public void departmentAdd() {
        Department department = new Department();
        department.inputData(scanner);
        departmentList.add(department);
        department.setDepartmentId(String.valueOf(idDepartment++));
        department.setTotalMembers(EmployeeService.employeeList.size());
    }

    public void departmentDelete() {
        System.out.println("Nhập id muốn xoá");
        String departmentDeleteId = scanner.nextLine();
        boolean check = true;
        for (Employee e : EmployeeService.employeeList) {
            if (e.getDepartment().getDepartmentId().equals(departmentDeleteId)) {
                check = false;
            }
        }if(check){
            departmentList.remove(findDepartmentById(departmentDeleteId));
        } else {
            System.err.println("Phòng ban có nhân viên");
        }
    }

    public void departmentEdit() {
        System.out.println("Nhập id phòng ban cần chỉnh sửa");
        String departmentEditId = scanner.nextLine();
        for (Department d : departmentList) {
            if (d.getDepartmentId().equals(departmentEditId)) {
                d.inputData(scanner);
            }
        }
    }

    public Department findDepartmentById(String idDepartment) {
        for (Department d : departmentList) {
            if (d.getDepartmentId().equals(idDepartment)) {
                return d;
            }
        }
        return null;
    }
}
