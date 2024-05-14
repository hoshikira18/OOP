import controller.StudentController;
import view.StudentView;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController();
        studentController.addSampleStudents();

        int option = 0;
        while (option != 8) {
            studentView.showMenu();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    studentController.addMultipleStudents();
                    studentController.showAllStudents();
                    break;
                case 2:
                    studentController.showSearchingResult();
                    break;
                case 3:
                    studentController.handleUpdateDeleteStudent();
                    break;
                case 4:
                    studentController.report();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter valid option! (1-5)");
                    break;
            }
        }

    }
}