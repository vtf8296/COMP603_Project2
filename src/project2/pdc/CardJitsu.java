/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pdc;

import project2.pdc.gui.MainMenuGUI;
import project2.pdc.model.MainMenu;

public class CardJitsu {
    
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        MainMenuGUI mainMenuGui = new MainMenuGUI(mainMenu);
        mainMenuGui.setVisible(true);
    }
    
}
