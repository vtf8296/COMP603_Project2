
package Task09_3;

import java.util.Observable;
import java.util.Random;


public class Model extends Observable {

    public Database db;
    public Data data;
    public int answer = 0;
    public String username; // To store the user name for later use.
    
    /**
     * Step 2:
     * Initialize the instance of Database in the constructor,
     * and build the connection between the program and the database.
     * 
     * Go to Database.java for Step 3.
     */
    public Model() {
        this.db = new Database();
        this.db.dbsetup();
    }
    
    /**
     * Step 6:
     * 
     * @param username
     * @param password 
     */
    public void checkName(String username, String password) {
        this.username = username;
        this.data = this.db.checkName(username, password);
//        if (data.loginFlag) {
//            this.newQuestion();
//        }
        
        this.setChanged();
        this.notifyObservers(this.data); 
    }
    
    public void newQuestion() {
        this.data.num1 = getNumber();
        this.data.num2 = getNumber();
        this.answer = this.data.num1 + this.data.num2; // Store the correct answer.
    }

    public int getNumber() {
        Random generator = new Random();
        int i = generator.nextInt(100);
        return i;
    }
    
    /**
     * Step 9:
     * Define checkAnswer() and quitGame()
     * 
     * After that, back to update() of View to complete remaining part.
     * @param answer 
     */
    public void checkAnswer(String answer) {
        if (answer.equals(this.answer + "")) {
            data.currentScore += 10;
        } else {
            data.currentScore -= 10;
        }
        this.newQuestion(); // Generate a new question for user.
        this.setChanged(); 
        this.notifyObservers(this.data);
    }

    public void quitGame() {
        /**
         * Update data in the database. Go to quitGame() of Database.java for a fast check.
         */
        this.db.quitGame(this.data.currentScore, this.username); 
        this.data.quitFlag = true; // Mark quitFlag as false.
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void playRound(int index) {
        this.data.rounds.get(this.data.rounds.size() - 1).play(index);
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void lol() {
        this.setChanged(); 
        this.notifyObservers(this.data);
    }
}
