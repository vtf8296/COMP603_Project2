/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task09_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author abdulh
 */
public class BattleHistoryWriter {
    private String filename;
    
    public BattleHistoryWriter(String battleName) {
        this.filename = "src\\project1\\pdc\\matchHistory\\" + battleName + ".txt";
    }
    
    // method to add the history of the match to a text file
    public void appendHistory(String history) {
        try {
            FileWriter fw = new FileWriter(this.filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            // Removing ANSI colour codes
            // https://stackoverflow.com/questions/14652538/remove-ascii-color-codes
            history = history.replaceAll("\u001B\\[[;\\d]*m", "");
            bw.write(history);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
