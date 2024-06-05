import model.Student;
import util.ValidationInfor;

import java.util.ArrayList;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ValidationInfor v = new ValidationInfor();

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Bob"));
        students.add(new Student("Alice"));
        students.add(new Student("Charlie"));

        students.sort(Comparator.comparing(Student::getName));

        students.forEach(System.out::println);

    }
}