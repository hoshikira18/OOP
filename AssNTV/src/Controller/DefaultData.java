/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Invoice;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author VIET
 */
public class DefaultData {
    public void writeFile(String string) throws IOException {
        FileWriter writer = new FileWriter("D:\\02.LearningDocument\\SE III\\CSD201\\Assignment1\\test.txt", true);
        try (BufferedWriter bfw = new BufferedWriter(writer)) {
            bfw.write(string);
        }
    }
    
    public void setNewInvoice() throws IOException {
        
        
        
        int age = 20;
        String id = "he123";
        String message = "Name: " + " ID: " + id+" Age: "+age    ;
        File file = new File("D:\\02.LearningDocument\\SE III\\CSD201\\Assignment1\\test.txt");
        Scanner scanner1 = new Scanner(file);
        if (file.createNewFile()) {
//            writeFile(message + "\n");
            //viet vao 2 file.
            System.out.println("Student is created.");
        } else {
            System.out.println("Student already exists.");
                         
                while (scanner1.hasNext()) {                
                    System.out.println(scanner1.nextLine());
            }
            
        }
    }
}
