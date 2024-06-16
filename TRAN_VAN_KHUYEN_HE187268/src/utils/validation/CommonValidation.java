package utils.validation;

import view.ConsoleView;

import java.util.Scanner;

public class CommonValidation {
    ConsoleView view = new ConsoleView();
    Scanner scanner = new Scanner(System.in);
    public boolean isContinue (String message) {
        while(true) {
            view.displayMessage(message);
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("y")) {
                return true;
            }
            if(choice.equalsIgnoreCase("n")) {
                return false;
            }
            view.displayMessage("Enter a valid choice (Y/N)");
        }
    }
}

