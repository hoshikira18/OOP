import model.Student;
import util.ValidationInfor;

import java.util.ArrayList;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ValidationInfor v = new ValidationInfor();

        if(v.validateEmail("khuyen@fpt.edu.vn")) {
            System.out.println("True");
        }
        else{
            System.out.println("false");
        }

    }
}