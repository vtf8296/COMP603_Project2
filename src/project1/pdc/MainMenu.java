/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pdc;

import java.util.Scanner;

/**
 *
 * @author abdulh
 */
public class MainMenu {
   
    public int mainMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n----------MAIN MENU----------");
        System.out.println("Enter the specified number to enter desired menu");
        System.out.println("[1] Battle!");
        System.out.println("[2] Instructions");
        System.out.println("[3] Exit");
        boolean isValid = false;
        int user_input = 0;
        
        // validating input for main menu
        do {
            int user_inputed = scan.nextInt();
            user_input = user_inputed;
            
            if (user_inputed == 1) {
                isValid = true;
                return user_inputed;
            }
            if (user_inputed == 2) {
                isValid = true;
                return user_inputed;
            }
            if (user_inputed == 3) {
                isValid = true;
                return user_inputed;
            }
            else if (user_inputed != 1 && user_inputed != 2 && user_inputed != 3) {
                System.out.println("Wrong input, Enter a number from 1 to 3");  
            }
        } while (!isValid);
        
        // returning the input of MainMenu back to main
        return user_input;
    }
}
