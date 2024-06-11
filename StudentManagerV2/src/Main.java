import controller.StudentController;
import view.StudentView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        StudentView view = new StudentView();
//        controller.addSample();

        while (true) {
            int choice = view.viewMenu();
            switch (choice) {
                case 1:
                    controller.addMultipleStudents();
                    break;
                case 2:
                    controller.searchStudentByName();
                    break;
                case 3:
                    controller.handleUpdateAndDelete();
                    break;
                case 4:
                    controller.reportStudentsInformation();
                    break;
                case 5:
                    return;
                case 6:
                    System.out.println(controller.studentsList.size());
                default:
                    view.displayMessage("Chose from 1 - 5.");
            }
        }
    }
}