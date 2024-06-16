package model.storage;

import model.avltree.AVLTree;
import model.entities.Employee;
import model.entities.IceCream;
import view.ConsoleView;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IceCreamStorage {
    final String ICE_CREAM_STORAGE_PATH = "src/data/ice_cream/";

    ConsoleView view = new ConsoleView();

    public void saveIceCream(IceCream iceCream) {
        try {
            Path directoryPath = Paths.get(ICE_CREAM_STORAGE_PATH);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create file path
        String filePath = ICE_CREAM_STORAGE_PATH + iceCream.getIceCreamId() + ".dat";
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(iceCream);
            fileOutputStream.close();
            view.displayMessage("IceCream saved successfully to: " + filePath);
        } catch (IOException e) {
            view.displayMessage("Error while saving iceCream: " + filePath);
        }
    }

    public AVLTree<IceCream> getAllIceCreams() {
        AVLTree<IceCream> iceCreamTree = new AVLTree<>();

        Path directoryPath = Paths.get(ICE_CREAM_STORAGE_PATH);
        if (!Files.exists(directoryPath)) {
            view.displayMessage("No iceCream found in " + directoryPath);
            return iceCreamTree;
        }

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath, "ice_*.dat")) {
            for (Path filePath : directoryStream) {
                try (
                        FileInputStream fileInputStream = new FileInputStream(filePath.toFile());
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ) {
                    IceCream iceCream = (IceCream) objectInputStream.readObject();
                    fileInputStream.close();
                    iceCreamTree.insert(iceCream);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return iceCreamTree;
    }

    public IceCream getIceCream(String id) {

        Path directoryPath = Paths.get(ICE_CREAM_STORAGE_PATH);
        if (!Files.exists(directoryPath)) {
            view.displayMessage("No ice cream found in " + directoryPath);
            return null;
        }

        String filePath = ICE_CREAM_STORAGE_PATH + id + ".dat";
        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            IceCream iceCream = (IceCream) objectInputStream.readObject();
            fileInputStream.close();
            return iceCream;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteIceCream(String id) {
        String filePath = ICE_CREAM_STORAGE_PATH + id + ".dat";
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                System.out.println("File not found: " + id + ".dat");
                return;
            }

            // Delete the file
            if (file.delete()) {
                System.out.println("File deleted successfully: " + id + ".dat");
            } else {
                System.out.println("Failed to delete the file: " + id + ".dat");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: Unable to delete the file");
        }
    }
}
