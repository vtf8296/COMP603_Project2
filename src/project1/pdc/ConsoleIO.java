/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pdc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author abdulh
 */
public class ConsoleIO {
    private BattleHistoryWriter battleHistoryWriter;
    
    public ConsoleIO(String battleName) {
        this.battleHistoryWriter = new BattleHistoryWriter(battleName);
    }
    
    // method prints the round number and displays the opponent's winning cards
    public void printRoundStart(int roundNumber, Player opponent) {
        String message = "\n*** ROUND #" + roundNumber + ":";
        message = message + "\n" + opponent.getName() + " WINNING CARDS: " + opponent.getWinningCards();
        printAndSave(message);
    }
    
    // method prompts the user to select a card from his hand to play
    public int selectCard(Player player) {
        Scanner scan = new Scanner(System.in);
        String message = player.toString();  
        printAndSave(message);
        int userInput = 0;
        while (true) {
            try {
                System.out.print("Input number [1-" + Player.HAND_SIZE + "] to select card: ");
                userInput = scan.nextInt();
                if( userInput >= 1 && userInput <= Player.HAND_SIZE) {
                    break;
                }
                System.out.println("Out of range.");
 
            } catch (InputMismatchException e) {
                System.out.println("You did not enter a Integer.");
                scan.nextLine();
            }
        }
        return userInput - 1;
    }
    
    // method prints the text to show the winner of the round.
    public void printRoundWinner(String player1Name, String player2Name, Card player1Card, Card player2Card, Optional<Player> winner) {
        String message = player1Name + ": " + player1Card + "\tvs\t" + player2Name + ": " + player2Card;
        if(winner.isPresent()) {
            message = message + "\n" + winner.get().getName()  + " won round!";
        } else {
            message = message + "\n" + "Round tied!";
        }
        printAndSave(message);
    }
    
    // method shows that the player won the game with the condition of winning with the same element and unique colours
    public void printBattleWinnerSameElement(String winnerName, Map<Element, Set<Colour>> winningMap, Element winningElement) {
        String message = "\n" + winnerName + " wins with the same element and unique colours!";
        List<String> winningList = new ArrayList<String>();
        for(Colour colour : winningMap.get(winningElement)) {
            winningList.add(colour.appendColourCode(colour.name()+"_"+winningElement.name()));
        }
        message = message + "\n" + winningList;
        printAndSave(message);
    }
    
    // method shows that the player won the game with the condition of winning with all elements and unique colours
    public void printBattleWinnerEveryElement(String winnerName, Colour fireColour, Colour iceColour, Colour waterColour) {
        String message = "\n" + winnerName + " wins with every element and unique colours!";
        List<String> winningList = new ArrayList<String>();
        winningList.add(fireColour.appendColourCode(fireColour.name()+"_"+Element.FIRE.name()));
        winningList.add(iceColour.appendColourCode(iceColour.name()+"_"+Element.ICE.name()));
        winningList.add(waterColour.appendColourCode(waterColour.name()+"_"+Element.WATER.name()));
        message = message + "\n" + winningList;
        printAndSave(message);
    }
    
    // method prints out the instructions of the game
    public static void printInstructions() {
        System.out.println("In Card Jitsu you will have a hand of 5 cards with different levels and colours to choose from.");
        System.out.println("The elements each card have are Fire, Water and Ice. Fire beats Ice, Ice beats Water and Water beats Fire");
        System.out.println("These elements will have a level next to them as well that include a number of 1 till 12");
        System.out.println("in the start of each round you will pick one of the 5 cards provided in your hand to be put in play");
        System.out.println("The card u pick will be faced against an opponent who will also choose an card");
        System.out.println("To win each round, your card must beat the opponents card. If both elements are the same then the winning point goes to the higher level");
        System.out.println("If both cards have the same element and level then the round ends in a draw and no points are awarded");
        System.out.println("The first to win 3 rounds with unique elements eg Fire Water and Ice and each card having a unique colour, wins the game");
        System.out.println("Alternatively the first one to win 3 rounds with the same element and unique colours will win the game.");
    }
    
    // method used to print out text to the console and to a text file.
    private void printAndSave(String message) {
        this.battleHistoryWriter.appendHistory(message);
        System.out.println(message);
    }
}
