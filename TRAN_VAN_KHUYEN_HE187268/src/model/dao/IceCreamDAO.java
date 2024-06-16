package model.dao;

import model.avltree.AVLNode;
import model.avltree.AVLTree;
import model.entities.IceCream;
import model.storage.IceCreamStorage;

import java.util.ArrayList;

public class IceCreamDAO {
    IceCreamStorage iceCreamStorage;
    ArrayList<IceCream> iceCreamsArray = new ArrayList<>();

    public IceCreamDAO() {
        this.iceCreamStorage = new IceCreamStorage();
    }

    public void addIceCream (IceCream iceCream) {
        iceCreamStorage.saveIceCream(iceCream);
    }

    public AVLTree<IceCream> getAllIceCreams () {
        return iceCreamStorage.getAllIceCreams();
    }

    public void deleteIceCream (String id) {
        iceCreamStorage.deleteIceCream(id);
    }

    public IceCream getIceCream (String id) {
        return iceCreamStorage.getIceCream(id);
    }

    public ArrayList<IceCream> getIceCreamsArray(AVLTree<IceCream> iceCreams) {
        getIceCream(iceCreams.root);
        return this.iceCreamsArray;
    }

    public void getIceCream(AVLNode<IceCream> root) {
        if(root == null) {
            return;
        }
        getIceCream(root.left);
        iceCreamsArray.add(root.data);
        getIceCream(root.right);
    }
}
