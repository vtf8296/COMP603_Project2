
package deleteme;

import Task09_3.Data;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ViewTest extends JFrame implements Observer {

    // FRAME
    public JLabel message = new JLabel("Welcome! Please log in", JLabel.CENTER);
    
    // LOGIN PAGE
    public JPanel loginPanel = new JPanel();
    public JLabel usernameLabel = new JLabel("Username: ");
    public JLabel passwordLabel = new JLabel("Password: ");
    public JTextField usernameTextField = new JTextField(10);
    public JTextField passwordTextField = new JTextField(10);
    public JButton loginButton = new JButton("Log in");

    // MENU PAGE
    public JPanel menuPanel = new JPanel();
    
    // BATTLE PAGE
    public JPanel battlePanel = new JPanel();
    
    // CALC PAGE
    public boolean started = false; // To identify if the game part starts.
    public JPanel calcPanel = new JPanel();
    public JLabel firstNumber = new JLabel();
    public JLabel secondNumber = new JLabel();
    public JLabel additionLabel = new JLabel("+");
    public JButton nextButton = new JButton("Next");
    public JButton quitButton = new JButton("Quit");
    public JTextField calcSolution = new JTextField(10);

    /**
     * Step 1: The constructor initializes the frame window as well as the login
     * interface.
     *
     * Note: We need to define the events of ActionListener in the Controller
     * class. Go to Model.java for Step 2.
     */
    public ViewTest() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null); // Make the frame located at the absolute center of the screen.
        this.populateLoginPanel();
        this.add(this.message, BorderLayout.NORTH);
        this.add(loginPanel);
        this.setVisible(true);
    }
    
    private void populateLoginPanel() {
        this.loginPanel.add(this.usernameLabel);
        this.loginPanel.add(this.usernameTextField);
        this.loginPanel.add(this.passwordLabel);
        this.loginPanel.add(this.passwordTextField);
        this.loginPanel.add(this.loginButton);
    }
    
    private void populateBattlePanel() {
//        this.battlePanel.add(null);
    }

    public void startQuiz() {
        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);

        calcPanel.add(calcSolution);
        calcPanel.add(nextButton);
        calcPanel.add(quitButton);

        this.getContentPane().removeAll();
        calcPanel.setVisible(true);
        this.add(calcPanel);
        this.revalidate();
        this.repaint();

    }

    public void setQuestion(int num1, int num2) {
        firstNumber.setText(num1 + "");
        secondNumber.setText(num2 + "=");
        calcSolution.setText("");
        calcPanel.repaint();
    }

    public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.nextButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
    }

    private void quitGame(int score) {
        JPanel quitPanel = new JPanel();
        JLabel scoreLabel = new JLabel("Your score: " + score);
        quitPanel.add(scoreLabel);
        this.getContentPane().removeAll();
        //calcPanel.setVisible(true);
        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }

    /**
     * Step 7: Define the event when model has been modified.
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg; // Obtain the instance of data.
        if (!data.loginFlag) { // If loginFlage is false, then ask the user to input again.
            this.usernameTextField.setText("");
            this.passwordTextField.setText("");
            this.message.setText("Invalid username or password.");
        } else if (!this.started) { // If the game has not started, then start the game.
            this.startQuiz(); // Change the interface of the frame.
            this.started = true;
            this.setQuestion(data.num1, data.num2); // Show the question on the interface.
            /**
             * You need to define ActionEvent for the next and the quit buttons
             * in the Controller.java. Back to Controller.java for Step 8.
             *
             * After you finish Step 9, complete last two conditions.
             */
        } else if (data.quitFlag) { // If user quits the game, display user's current score.
            this.quitGame(data.currentScore);
        } else { // Otherwise, update a new question for the user.
            this.setQuestion(data.num1, data.num2);
        }
    }

}
