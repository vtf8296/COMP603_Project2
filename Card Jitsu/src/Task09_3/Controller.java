package Task09_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {

    public View view;
    public Model model;
    /**
     * Step 4:
     * Assign view and model to attributes in the constructor, and add ActionListener(this) to the instance of View.
     * @param view
     * @param model 
     */
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this); // Add Actionlistener (the instance of this class) to View.
    }

    /**
     * Step 5:
     * Define ActionEvents based on the text displayed on the each button.
     * Note: You must change the property of relating components to public for external access.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand(); // Obtain the text displayed on the component.
        if (buttonText.equals(this.view.loginButton.getText())) {
            System.out.println("Login button");
            String username = this.view.usernameTextField.getText(); // Obtain username.
            String password = this.view.passwordTextField.getText(); // Obtain password.
            this.model.checkName(username, password); // Pass above variables to model. Go to the checkName() of Model.java for step 6.
        } else if (buttonText.equals(this.view.nextButton.getText())) {
            System.out.println("Next button");
            // Step 8:
            // Go to the checkAnswer() and quitGame() of Model.java.
            this.model.checkAnswer(this.view.calcSolution.getText()); // Check user's answer.
        } else if (buttonText.equals(this.view.quitButton.getText())) {
            System.out.println("Quit button");
            this.model.quitGame(); // Record user's current score.
        }
    }

}
