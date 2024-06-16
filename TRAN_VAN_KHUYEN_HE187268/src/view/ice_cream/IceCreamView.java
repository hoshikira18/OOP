package view.ice_cream;

import model.avltree.AVLNode;
import model.avltree.AVLTree;
import model.entities.Employee;
import model.entities.IceCream;

import java.util.ArrayList;

public class IceCreamView {
    public void displayIceCreamMenu () {
        System.out.println("");
        System.out.println("====== MIXUE ICECREAM =======");
        System.out.println("1. Add new ice cream");
        System.out.println("2. Search ice cream by name");
        System.out.println("3. Update ice cream details");
        System.out.println("4. Delete ice cream");
        System.out.println("5. Exit");
        System.out.println("Enter your choice (1-5): ");
    }

    public void displayIceCreamUpdateMenu() {
        System.out.println("");
        System.out.println("====== MIXUE UPDATE ICE CREAM =======");
        System.out.println("1. Ice cream name");
        System.out.println("2. Ice cream price");
        System.out.println("3. Exit");
        System.out.println("Enter your choice (1-3): ");
    }


    public void displayAllIceCream(AVLTree<IceCream> iceCreams) {
        displayIceCream(iceCreams.root);
    }

    public void displayIceCream(AVLNode<IceCream> root) {
        if(root == null) {
            return;
        }
        displayIceCream(root.left);
        System.out.println(root.data.toString());
        displayIceCream(root.right);
    }

    public void displaySearchingResults (ArrayList<IceCream> searchingResults) {
        for(IceCream e : searchingResults) {
            System.out.println(searchingResults.indexOf(e) + ". " + e.toString());
        }
    }

    public void displayIceCreamArray (ArrayList<IceCream> iceCreams) {
        for(IceCream e : iceCreams) {
            System.out.println(iceCreams.indexOf(e) + ". " + e.toString());
        }
    }
}
