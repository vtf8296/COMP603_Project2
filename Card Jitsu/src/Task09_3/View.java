package Task09_3;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;
import javax.swing.JFrame;

public class View extends JFrame implements Observer {

    // BATTLE
    private List<javax.swing.JButton> cardButtons;
    
    private javax.swing.JPanel batlePanel;
    public javax.swing.JButton cardButton1;
    public javax.swing.JButton cardButton2;
    public javax.swing.JButton cardButton3;
    public javax.swing.JButton cardButton4;
    public javax.swing.JButton cardButton5;
    private javax.swing.JPanel handPanel;
    public javax.swing.JButton helpButton;
    private javax.swing.JLabel playerFireWinningCardsLabel;
    private javax.swing.JLabel playerIceWinningCardsLabel;
    private javax.swing.JLabel playerWaterWinningCardsLabel;
    private javax.swing.JPanel playerWinningCardsPanel;
    public javax.swing.JButton quitButton;
    private javax.swing.JLabel robotFireWinningCardsLabel;
    private javax.swing.JLabel robotIceWinningCardsLabel;
    private javax.swing.JLabel robotWaterWinningCardsLabel;
    private javax.swing.JPanel robotWinningCardsPanel;
    private javax.swing.JLabel roundMessageLabel;
    private javax.swing.JLabel roundNumberLabel;
    
    public View() {        
        initComponents();
        setVisible(true);
    }
    
    private void initComponents() {

        batlePanel = new javax.swing.JPanel();
        roundMessageLabel = new javax.swing.JLabel();
        roundNumberLabel = new javax.swing.JLabel();
        playerWinningCardsPanel = new javax.swing.JPanel();
        playerIceWinningCardsLabel = new javax.swing.JLabel();
        playerFireWinningCardsLabel = new javax.swing.JLabel();
        playerWaterWinningCardsLabel = new javax.swing.JLabel();
        robotWinningCardsPanel = new javax.swing.JPanel();
        robotIceWinningCardsLabel = new javax.swing.JLabel();
        robotFireWinningCardsLabel = new javax.swing.JLabel();
        robotWaterWinningCardsLabel = new javax.swing.JLabel();
        handPanel = new javax.swing.JPanel();
        cardButton1 = new javax.swing.JButton();
        cardButton2 = new javax.swing.JButton();
        cardButton3 = new javax.swing.JButton();
        cardButton4 = new javax.swing.JButton();
        cardButton5 = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Card Jitsu");
        setMinimumSize(new java.awt.Dimension(550, 550));
        setPreferredSize(new java.awt.Dimension(550, 550));
        setResizable(false);

        roundMessageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roundMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundMessageLabel.setText("Player's magenta water [12] beat Robot's magenta water [12]");

        roundNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        roundNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundNumberLabel.setText("ROUND 10");

        playerWinningCardsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Player's Winning Cards"));

        playerIceWinningCardsLabel.setText("ICE: ");

        playerFireWinningCardsLabel.setText("FIRE: ");

        playerWaterWinningCardsLabel.setText("WATER:");

        javax.swing.GroupLayout playerWinningCardsPanelLayout = new javax.swing.GroupLayout(playerWinningCardsPanel);
        playerWinningCardsPanel.setLayout(playerWinningCardsPanelLayout);
        playerWinningCardsPanelLayout.setHorizontalGroup(
            playerWinningCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerWinningCardsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerWinningCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerIceWinningCardsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerFireWinningCardsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerWaterWinningCardsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        playerWinningCardsPanelLayout.setVerticalGroup(
            playerWinningCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerWinningCardsPanelLayout.createSequentialGroup()
                .addComponent(playerIceWinningCardsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerFireWinningCardsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerWaterWinningCardsLabel))
        );

        robotWinningCardsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Robot's Winning Cards"));

        robotIceWinningCardsLabel.setText("ICE: ");

        robotFireWinningCardsLabel.setText("FIRE: ");

        robotWaterWinningCardsLabel.setText("WATER:");

        javax.swing.GroupLayout robotWinningCardsPanelLayout = new javax.swing.GroupLayout(robotWinningCardsPanel);
        robotWinningCardsPanel.setLayout(robotWinningCardsPanelLayout);
        robotWinningCardsPanelLayout.setHorizontalGroup(
            robotWinningCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(robotWinningCardsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(robotWinningCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(robotIceWinningCardsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(robotFireWinningCardsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(robotWaterWinningCardsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        robotWinningCardsPanelLayout.setVerticalGroup(
            robotWinningCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(robotWinningCardsPanelLayout.createSequentialGroup()
                .addComponent(robotIceWinningCardsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(robotFireWinningCardsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(robotWaterWinningCardsLabel))
        );

        handPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Hand of Cards"));

        cardButton1.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        cardButton1.setActionCommand("Card 1");
        cardButton1.setMaximumSize(new java.awt.Dimension(75, 125));
        cardButton1.setMinimumSize(new java.awt.Dimension(75, 125));
        cardButton1.setPreferredSize(new java.awt.Dimension(75, 125));

        cardButton2.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        cardButton2.setActionCommand("Card 2");
        cardButton2.setMaximumSize(new java.awt.Dimension(75, 125));
        cardButton2.setMinimumSize(new java.awt.Dimension(75, 125));
        cardButton2.setPreferredSize(new java.awt.Dimension(75, 125));

        cardButton3.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        cardButton3.setActionCommand("Card 3");
        cardButton3.setMaximumSize(new java.awt.Dimension(75, 125));
        cardButton3.setMinimumSize(new java.awt.Dimension(75, 125));
        cardButton3.setPreferredSize(new java.awt.Dimension(75, 125));

        cardButton4.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        cardButton4.setActionCommand("Card 4");
        cardButton4.setMaximumSize(new java.awt.Dimension(75, 125));
        cardButton4.setMinimumSize(new java.awt.Dimension(75, 125));
        cardButton4.setPreferredSize(new java.awt.Dimension(75, 125));

        cardButton5.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        cardButton5.setActionCommand("Card 5");
        cardButton5.setMaximumSize(new java.awt.Dimension(75, 125));
        cardButton5.setMinimumSize(new java.awt.Dimension(75, 125));
        cardButton5.setPreferredSize(new java.awt.Dimension(75, 125));

        javax.swing.GroupLayout handPanelLayout = new javax.swing.GroupLayout(handPanel);
        handPanel.setLayout(handPanelLayout);
        handPanelLayout.setHorizontalGroup(
            handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cardButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cardButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cardButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(cardButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        handPanelLayout.setVerticalGroup(
            handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handPanelLayout.createSequentialGroup()
                .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        helpButton.setText("Help");

        quitButton.setText("Quit");

        javax.swing.GroupLayout batlePanelLayout = new javax.swing.GroupLayout(batlePanel);
        batlePanel.setLayout(batlePanelLayout);
        batlePanelLayout.setHorizontalGroup(
            batlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(batlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(batlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(playerWinningCardsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(robotWinningCardsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(handPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(batlePanelLayout.createSequentialGroup()
                        .addComponent(helpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quitButton)))
                .addContainerGap())
        );
        batlePanelLayout.setVerticalGroup(
            batlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(batlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerWinningCardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(robotWinningCardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(handPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(batlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton)
                    .addComponent(quitButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(batlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(batlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        
        this.cardButtons = Arrays.asList(this.cardButton1, this.cardButton2, this.cardButton3, this.cardButton4, this.cardButton5);
    }// </editor-fold>                        

    private void updateBattleView(List<Round> rounds) {
        Round round = rounds.get(rounds.size() - 1);
        for(int i = 0; i < Player.HAND_SIZE; i++) {
            javax.swing.JButton cardButton = this.cardButtons.get(i);
            Card card = round.getPlayer().getHand().get(i);
            cardButton.setBackground(card.getColour().value);
            cardButton.setText("<html>" +
                    "<h4>" + card.getLevel() + "</h4>" +
                    card.getColour() +
                    "<br/>" +
                    card.getElement() +
                    "</html>");
        }
        
        if(round.getWinner().isPresent()) {
            if(round.getWinner().get() == round.getPlayer()) {
                this.roundMessageLabel.setText("Player's " + round.getPlayerSelectedCard() + " beat Robot's " + round.getRobotSelectedCard());
            } else {
                this.roundMessageLabel.setText("Robot's " + round.getRobotSelectedCard() + " beat Player's " + round.getPlayerSelectedCard());
            }
        } else {
            this.roundMessageLabel.setText("Player's " + round.getPlayerSelectedCard() + " tied with Robot's " + round.getRobotSelectedCard());
        }
        this.roundNumberLabel.setText("Round " +rounds.size());
        
        this.playerFireWinningCardsLabel.setText("FIRE: " + round.getPlayer().getWinningCards().stream().filter(card -> card.getElement().equals(Element.FIRE)).collect(Collectors.toList()));
        this.playerWaterWinningCardsLabel.setText("WATER: " + round.getPlayer().getWinningCards().stream().filter(card -> card.getElement().equals(Element.WATER)).collect(Collectors.toList()));
        this.playerIceWinningCardsLabel.setText("ICE: " + round.getPlayer().getWinningCards().stream().filter(card -> card.getElement().equals(Element.ICE)).collect(Collectors.toList()));
        this.robotFireWinningCardsLabel.setText("FIRE: " + round.getRobot().getWinningCards().stream().filter(card -> card.getElement().equals(Element.FIRE)).collect(Collectors.toList()));
        this.robotWaterWinningCardsLabel.setText("WATER: " + round.getRobot().getWinningCards().stream().filter(card -> card.getElement().equals(Element.WATER)).collect(Collectors.toList()));
        this.robotIceWinningCardsLabel.setText("ICE: " + round.getRobot().getWinningCards().stream().filter(card -> card.getElement().equals(Element.ICE)).collect(Collectors.toList()));
    }
    
    public void addActionListener(ActionListener listener) {
        this.cardButton1.addActionListener(listener);
        this.cardButton2.addActionListener(listener);
        this.cardButton3.addActionListener(listener);
        this.cardButton4.addActionListener(listener);
        this.cardButton5.addActionListener(listener);
        this.helpButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        updateBattleView(data.rounds);
    }

}
