package view;

public class ConsoleView {
    public void displayMessage (String message) {
        System.out.println(message.toUpperCase());
    }

    public void displayInputMessage (String inputType) {
        System.out.print("Enter " + inputType.toUpperCase() + ": ");
    }

    public void displayMenu () {
        System.out.println("");
        System.out.println("====== MIXUE =======");
        System.out.println("1. Employee");
        System.out.println("2. IceCream");
        System.out.println("3. Create new Invoice");
        System.out.println("4. Exit");
        System.out.println("Enter your choice (1-4): ");
    }

}
