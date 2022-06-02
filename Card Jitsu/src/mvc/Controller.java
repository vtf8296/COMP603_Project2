package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Controller implements ActionListener {

    public View view;
    public Model model;
    
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this); // Add Actionlistener (the instance of this class) to View.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand(); // Obtain the text displayed on the component.
        if (actionCommand.equals(this.view.loginButton.getActionCommand())) {
            this.model.checkName(this.view.loginUsernameField.getText(), Arrays.toString(this.view.loginPasswordField.getPassword()));
        } else if (actionCommand.equals(this.view.cardButton1.getActionCommand())) {
            this.model.playRound(0);
        } else if (actionCommand.equals(this.view.cardButton2.getActionCommand())) {
            this.model.playRound(1);
        } else if (actionCommand.equals(this.view.cardButton3.getActionCommand())) {
            this.model.playRound(2);
        } else if (actionCommand.equals(this.view.cardButton4.getActionCommand())) {
            this.model.playRound(3);
        } else if (actionCommand.equals(this.view.cardButton5.getActionCommand())) {
            this.model.playRound(4);
        } else if (actionCommand.equals(this.view.quitButton.getActionCommand())) {
            this.model.quitGame();
        }
    }

}
