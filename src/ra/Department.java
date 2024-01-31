package ra;

import service.EmployeeService;

import java.util.Objects;
import java.util.Scanner;

public class Department {
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department() {
    }

    public Department(String departmentId, String departmentName, int totalMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
    public void inputData(Scanner scanner){
        EmployeeService employeeService = new EmployeeService();
        System.out.println("Hãy điền tên phòng ban");
        this.departmentName = scanner.nextLine();
        this.totalMembers = 0;
    }
    public void displayData(){
        System.out.printf("Tên phòng ban : %s | Id phòng ban: %s | Tổng số nhân viên : %s \n",departmentName,departmentId,totalMembers);
    }

    @Override
    public String toString() {
        return  departmentName;
    }
}
