/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task09_3;

import java.util.ArrayList;
import java.util.List;


public class Data {
    boolean loginFlag = false; // Check if the user successfully login the system.
    boolean quitFlag = false; // Check if the user quit the system.
    int currentScore = 0; // Store user's cumulative scores.
    int num1 = 0; // The first and second numbers of the question.
    int num2 = 0;
    
    String username = "";
    int wins = 0;
    int loss = 0;
    List<Round> rounds = new ArrayList<>();
}
