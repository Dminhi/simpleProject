package run;

import ra.Department;
import service.DePartMentService;

import java.util.Scanner;

public class DepartmentRun {
    public static void main(String[] args) {
        DePartMentService dePartMentService = new DePartMentService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=======================MENU======================");
            System.out.println("1. Hiên thị danh sách ");
            System.out.println("2. Thêm mới");
            System.out.println("3. Sửa thông tin");
            System.out.println("4. Tìm kiếm theo Id");
            System.out.println("5. Xóa theo id");
            System.out.println("6. Quay lại");
            System.out.println("Nhập lựa chọn");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    dePartMentService.displayDepartment();
                    break;
                case 2:
                    dePartMentService.departmentAdd();
                    break;
                case 3:
                    dePartMentService.departmentEdit();
                    break;
                case 4:
                    System.out.println("Nhập id tìm kiếm");
                    String findId = scanner.nextLine();
                    System.out.println(dePartMentService.findDepartmentById(findId));
                    break;
                case 5:
                    dePartMentService.departmentDelete();
                    break;
                case 6:
                    return;
            }
        }
    }
}