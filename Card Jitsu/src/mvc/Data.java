/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;
import java.util.List;

public class Data {
    boolean loginFlag = false; // Check if the user successfully login the system.
    boolean battleStartedFlag = false; // Check if the battle has started.
    boolean battleWonFlag = false; // Check if the battle has ended.
    boolean quitFlag = false; // Check if the user quit the system.
    
    //Variables set to take reference from View and Model.
    String username = "";
    int wins = 0;
    int losses = 0;
    Player player = null;
    Player robot = new Player("Robot");
    List<Round> rounds = new ArrayList<>();
    String winningTitle = "";
    String winningSet = "";
}
