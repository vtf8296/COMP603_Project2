package deleteme;

import javax.swing.JFrame;

public class TestView extends JFrame {
    
    // BATTLE
    private javax.swing.JPanel batlePanel;
    private javax.swing.JButton card1Button;
    private javax.swing.JLabel card1Label;
    private javax.swing.JButton card2Button;
    private javax.swing.JLabel card2Label;
    private javax.swing.JButton card3Button;
    private javax.swing.JLabel card3Label;
    private javax.swing.JButton card4Button;
    private javax.swing.JLabel card4Label;
    private javax.swing.JButton card5Button;
    private javax.swing.JLabel card5Label;
    private javax.swing.JPanel handPanel;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel playerFireWinningCardsLabel;
    private javax.swing.JLabel playerIceWinningCardsLabel;
    private javax.swing.JLabel playerWaterWinningCardsLabel;
    private javax.swing.JPanel playerWinningCardsPanel;
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel robotFireWinningCardsLabel;
    private javax.swing.JLabel robotIceWinningCardsLabel;
    private javax.swing.JLabel robotWaterWinningCardsLabel;
    private javax.swing.JPanel robotWinningCardsPanel;
    private javax.swing.JLabel roundMessageLabel;
    private javax.swing.JLabel roundNumberLabel;
    
    public TestView() {        
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
        card1Button = new javax.swing.JButton();
        card2Button = new javax.swing.JButton();
        card3Button = new javax.swing.JButton();
        card4Button = new javax.swing.JButton();
        card5Button = new javax.swing.JButton();
        card1Label = new javax.swing.JLabel();
        card2Label = new javax.swing.JLabel();
        card3Label = new javax.swing.JLabel();
        card4Label = new javax.swing.JLabel();
        card5Label = new javax.swing.JLabel();
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

        card1Button.setText("Card 1");

        card2Button.setText("Card 2");

        card3Button.setText("Card 3");

        card4Button.setText("Card 4");

        card5Button.setText("Card 5");

        card1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card1Label.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        card1Label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        card2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card2Label.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        card2Label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        card3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card3Label.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        card3Label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        card4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card4Label.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        card4Label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        card5Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card5Label.setText("<html>\n<h4>12</h4>\nMagenta\n<br/>\nWater\n</html>");
        card5Label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout handPanelLayout = new javax.swing.GroupLayout(handPanel);
        handPanel.setLayout(handPanelLayout);
        handPanelLayout.setHorizontalGroup(
            handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card1Label)
                    .addComponent(card1Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(handPanelLayout.createSequentialGroup()
                        .addComponent(card2Button)
                        .addGap(18, 18, 18)
                        .addComponent(card3Button))
                    .addGroup(handPanelLayout.createSequentialGroup()
                        .addComponent(card2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card3Label)))
                .addGap(18, 18, 18)
                .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card4Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card4Label))
                .addGap(18, 18, 18)
                .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card5Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card5Label))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        handPanelLayout.setVerticalGroup(
            handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, handPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1Label, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(card2Label)
                    .addComponent(card3Label, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(card4Label)
                    .addComponent(card5Label, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(card1Button)
                    .addComponent(card2Button)
                    .addComponent(card3Button)
                    .addComponent(card4Button)
                    .addComponent(card5Button))
                .addContainerGap())
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
                    .addComponent(roundMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }
    
    public static void main(String[] args) {
        TestView view = new TestView();
    }

}
