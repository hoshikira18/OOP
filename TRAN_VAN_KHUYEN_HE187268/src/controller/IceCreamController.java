package controller;

import model.avltree.AVLTree;
import model.dao.IceCreamDAO;
import model.entities.Employee;
import model.entities.IceCream;
import utils.IDGenerator;
import view.ConsoleView;
import view.ice_cream.IceCreamView;

import java.util.ArrayList;
import java.util.Scanner;

public class IceCreamController {
    Scanner scanner = new Scanner(System.in);
    IDGenerator idGenerator = new IDGenerator();
    ConsoleView mainView = new ConsoleView();
    IceCreamView view = new IceCreamView();

    public IceCreamDAO iceCreamDAO;
    public AVLTree<IceCream> iceCreamTree;

    public IceCreamController() {
        this.iceCreamDAO = new IceCreamDAO();
        this.iceCreamTree = iceCreamDAO.getAllIceCreams();
    }

    public void start() {
        while (true) {
            view.displayIceCreamMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    this.addIceCream();
                    break;
                case 2:
                    this.search();
                    break;
                case 3:
                    this.updateIceCream();
                    break;
                case 4:
                    this.deleteIceCream();
                    break;
                case 5:
                    return;
                case 6:
                    this.display();
                    break;
                default:
                    System.out.println("Chose from 1 - 5");
            }
        }
    }

    public void addIceCream() {
        String id = idGenerator.generateIceCreamID();
        mainView.displayInputMessage("IceCream Name");
        String name = scanner.nextLine();
        mainView.displayInputMessage("Price");
        double price = Double.parseDouble(scanner.nextLine());

        IceCream newIC = new IceCream(id, name, price);

        iceCreamTree.insert(newIC);
        iceCreamDAO.addIceCream(newIC);
    }

    public void updateIceCream () {
        ArrayList<IceCream> searchingResults = searchIceCreamByName();
        view.displaySearchingResults(searchingResults);

        if(searchingResults.isEmpty()) {
            mainView.displayMessage("Ice Cream not founded!");
            return;
        }

        mainView.displayMessage("Chose a record to update");
        mainView.displayInputMessage("record (Enter index)");
        int recordIndex = Integer.parseInt(scanner.nextLine());

        IceCream chosenIceCream = iceCreamDAO.getIceCream(searchingResults.get(recordIndex).getIceCreamId());

        iceCreamTree.deleteNode(chosenIceCream);

        while(true) {
            view.displayIceCreamUpdateMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    mainView.displayInputMessage("new name");
                    String newName = scanner.nextLine();
                    chosenIceCream.setIceCreamName(newName);
                    break;
                case 2:
                    mainView.displayInputMessage("new price");
                    double newPrice = Double.parseDouble(scanner.nextLine());
                    chosenIceCream.setIceCreamPrice(newPrice);
                    break;
                case 3:
                    iceCreamTree.insert(chosenIceCream);
                    iceCreamDAO.addIceCream(chosenIceCream);
                    return;
                default:
                    System.out.println("Chose from 1 - 3");
            }
        }
    }

    public void search() {
        ArrayList<IceCream> searchingResults = searchIceCreamByName();
        if (searchingResults.isEmpty()) {
            mainView.displayMessage("Ice Cream not founded!");
            return;
        }
        view.displaySearchingResults(searchingResults);
    }

    public ArrayList<IceCream> searchIceCreamByName() {
        mainView.displayInputMessage("keyword (Ice Cream Name)");
        String keyword = scanner.nextLine();
        ArrayList<IceCream> searchingResults = new ArrayList<>();
        iceCreamTree.searchIceCreamByName(iceCreamTree.root, keyword, searchingResults);
        return searchingResults;
    }

    public void deleteIceCream() {
        ArrayList<IceCream> searchingResults = searchIceCreamByName();
        view.displaySearchingResults(searchingResults);

        if (searchingResults.isEmpty()) {
            mainView.displayMessage("Ice Cream not founded!");
            return;
        }

        mainView.displayMessage("Chose a record to delete");
        mainView.displayInputMessage("record (Enter index)");
        int recordIndex = Integer.parseInt(scanner.nextLine());

        IceCream chosenIC = iceCreamDAO.getIceCream(searchingResults.get(recordIndex).getIceCreamId());

        iceCreamTree.deleteNode(chosenIC);
        iceCreamDAO.deleteIceCream(chosenIC.getIceCreamId());
    }

    public void display() {
        view.displayAllIceCream(this.iceCreamTree);
    }

    public ArrayList<IceCream> getAllIceCream () {
        return iceCreamDAO.getIceCreamsArray(iceCreamTree);
    }

}
