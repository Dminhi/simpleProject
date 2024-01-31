package run;

import ra.Employee;
import service.EmployeeService;

import java.util.Scanner;

public class EmployeeRun {
    private static EmployeeService employeeService = new EmployeeService();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=======================MENU======================");
            System.out.println("1. Hiên thị danh sách nhân viên ");
            System.out.println("2. Tìm kiếm theo Id");
            System.out.println("3. Thêm mới nhân viên");
            System.out.println("4. Sửa thông tin");
            System.out.println("5. Xóa theo id");
            System.out.println("6. Số lượng nhân viên trung bình mỗi phòng");
            System.out.println("7. Tìm ra 5 phòng có số lượng nhân viên đông nhất");
            System.out.println("8. Tìm ra người quản lý nhiều  nhân viên nhất");
            System.out.println("9. Tìm ra 5 nhân viên có tuổi cao nhất công ty");
            System.out.println("10. Tìm ra 5 nhân viên hưởng lương cao nhất");
            System.out.println("11. Quay lại");
            System.out.println("0. Thoát");
            System.out.println("-------------------------------------------------");
            System.out.println("Nhập lựa chọn");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice){
                case 1:
                    employeeService.displayEmployee();
                    break;
                case 2:
                    employeeService.findEmployeeById();
                    break;
                case 3:
                    employeeService.addEmployee();
                    break;
                case 4:
                    employeeService.editEmployee();
                    break;
                case 5:
                    employeeService.deleteEmployee(scanner);
                    break;
                case 6:
                    employeeService.avgEmployeeInDepartment();
                    break;
                case 7:
                    employeeService.findDepartmentMostEmployee();
                    break;
                case 8:
                    employeeService.findMostManagerOfEmployee();
                    break;
                case 9:
                    employeeService.findMostAgeEmployee();
                    break;
                case 10:
                    employeeService.findMostSalaryEmloyee();
                    break;
                case 11:
                    return;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("Nhập không hợp lệ");
            }

        }
    }
}

