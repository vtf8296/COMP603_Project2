/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pdc;

import java.util.Scanner;

public class Project1PDC {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! welcome to Card Jitsu!");
        System.out.println("Enter your name: ");
        String user_name = scan.nextLine();
        System.out.println("Prepare yourself " + user_name + ", the battle is about to begin!");
        MainMenu m = new MainMenu();
        
        while(true) {
            int mainMenuSelection = m.mainMenu();
            Battle battle = new Battle();

            // checking user input from the main menu and executing
            if (mainMenuSelection == 1) {
                battle.Battle(user_name, "Robot");
                battle.play();
            } else if (mainMenuSelection == 2) {
                ConsoleIO.printInstructions();
                System.out.println("[1] Battle!");
                System.out.println("[2] Exit");
                Scanner scanned = new Scanner(System.in);
                int user_input = scanned.nextInt();
                if (user_input == 1) {
                    battle.Battle(user_name, "Robot");
                    battle.play();
                } else if (user_input == 2) {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
            } else if (mainMenuSelection == 3) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }
    }
}
