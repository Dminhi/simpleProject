package run;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1 Deparment");
            System.out.println("2 Employee");
            System.out.println("3 Exit");
            System.out.println("------------------------");
            System.out.println("Mời nhập lựa chọn");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    DepartmentRun.main(args);
                    break;
                case 2:
                    EmployeeRun.main(args);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
