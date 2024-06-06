package BattleShip_1;
import java.awt.*;
import java.lang.reflect.Array;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BattleShipApp {

	public static void main(String[] args) {

		
        // Main frame
        JFrame game = new JFrame("BattleShip");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(980, 800);
        game.setLocationRelativeTo(null);
        game.setLayout(new BorderLayout());

        // 
        ImageIcon battleShipIcon = new ImageIcon("battleApplogo.png");
        game.setIconImage(battleShipIcon.getImage());

        // 
        game.getContentPane().setBackground(Color.white);

        //setting player1 Avatar
        ImageIcon player1Image = new ImageIcon("player1.png");
        JLabel player1Avatar = new JLabel();
        player1Avatar.setIcon(player1Image);
        player1Avatar.setText("Player1");
        player1Avatar.setFont(new Font("Arial", Font.PLAIN, 15));
        player1Avatar.setHorizontalTextPosition(JLabel.CENTER);
        player1Avatar.setVerticalTextPosition(JLabel.BOTTOM);
        player1Avatar.setBorder(new EmptyBorder(0,20,20,20));
        player1Avatar.setPreferredSize(new Dimension(200,100));
        
        //setting player2 Avatar
        JLabel player2Avatar = new JLabel();
        player2Avatar.setIcon(player1Image);
        player2Avatar.setText("Player2");
        player2Avatar.setFont(new Font("Arial", Font.PLAIN, 15));
        player2Avatar.setHorizontalTextPosition(JLabel.CENTER);
        player2Avatar.setVerticalTextPosition(JLabel.BOTTOM);
        player2Avatar.setBorder(new EmptyBorder(0,20,20,20));
        player2Avatar.setPreferredSize(new Dimension(200,100));
        //setting a JPanel
        //Setting Game Name label
        JLabel gameName = new JLabel();
        gameName.setText("Battle SHIP");
        gameName.setFont(new Font("Arial",Font.ITALIC,25));
        gameName.setHorizontalAlignment(JLabel.CENTER);
        gameName.setVerticalAlignment(JLabel.TOP);
        gameName.setHorizontalTextPosition(JLabel.CENTER);
        //gameName.setPreferredSize(new Dimension(200,23));
        gameName.setVerticalTextPosition(JLabel.CENTER);
        gameName.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
        //Game Progress Bar
        JProgressBar timeProgressBar = new JProgressBar(0,60);
        timeProgressBar.setValue(60);
        timeProgressBar.setStringPainted(true);
        timeProgressBar.setPreferredSize(new Dimension(200,10));
        
        //Generate empty label for GridLayout
        JLabel[] emptyLabel= new JLabel[3];
        for(int i = 0;i < 3;i++) {
        	
        	emptyLabel[i] = new JLabel();
        }
        //Add gameName and timeProgressBar to centerPanel
        JPanel centerPanel = new JPanel(new GridLayout(5,0));
        centerPanel.add(gameName);
        centerPanel.add(emptyLabel[0]);
        centerPanel.add(timeProgressBar,BorderLayout.CENTER);

        
        //Adding player1 label to leftPanel
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(player1Avatar,BorderLayout.CENTER);
        //Adding player2 label to rightPanel        
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(player2Avatar,BorderLayout.CENTER);
        
        //Adding Left,right, centerPanel to gameNorthPanel layout
        JPanel gameNorthPanel = new JPanel(new BorderLayout());
        gameNorthPanel.add(leftPanel,BorderLayout.WEST);
        gameNorthPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        gameNorthPanel.add(rightPanel,BorderLayout.EAST);
        //gameNorthPanel.add(gameName);
        gameNorthPanel.add(centerPanel,BorderLayout.CENTER);
        gameNorthPanel.setPreferredSize(new Dimension(200,180));
        
//      //Adding gammeNorthPanel to the game layout
//        game.add(gameNorthPanel,BorderLayout.NORTH);
        
        //Creating BattleShipLable and DamageStatus bar.
        //Player1
        JLabel[] playerBattleShip = new JLabel[5];       
        JProgressBar[] damageStatus = new JProgressBar[5];

        JPanel Player1BattleShipInfo= new JPanel(new GridLayout(22,0));
        Player1BattleShipInfo.setPreferredSize(new Dimension(200,100));
        for(int i = 0; i < damageStatus.length;i++) {
        	
        	playerBattleShip[i] = new JLabel("Battle Ship:"+(i+1));
        	playerBattleShip[i].setHorizontalAlignment(JLabel.CENTER);
        	//playerBattleShip[i].setBorder(new EmptyBorder(0, 0, 0, 0));
        	Player1BattleShipInfo.add(playerBattleShip[i]);
        	damageStatus[i] = new JProgressBar(0,100);
        	damageStatus[i].setValue(100);
        	damageStatus[i].setStringPainted(true);
        
        	damageStatus[i].setBorder(new EmptyBorder(0, 10, 10, 10));
        	Player1BattleShipInfo.add(damageStatus[i]);
        }
        JPanel Player2BattleShipInfo= new JPanel(new GridLayout(22,0));
        Player2BattleShipInfo.setPreferredSize(new Dimension(200,100));
        
        //Player2
        JLabel[] player2BattleShip = new JLabel[5];        
        JProgressBar[] damageStatus2 = new JProgressBar[5];
        for(int i = 0; i < damageStatus.length;i++) {
        	
        	player2BattleShip[i] = new JLabel("Battle Ship:"+(i+1));
        	player2BattleShip[i].setHorizontalAlignment(JLabel.CENTER);
        	//Adding to Player2BattleShipInfo JPanel;
        	Player2BattleShipInfo.add(player2BattleShip[i]);
        	damageStatus2[i] = new JProgressBar(0,100);
        	damageStatus2[i].setValue(100);
        	damageStatus2[i].setStringPainted(true);
        	//damageStatus[i].setPreferredSize(new Dimension(100,20));
        	damageStatus2[i].setBorder(new EmptyBorder(0, 10, 10, 10));
        	//Adding to Player2BattleShipInfo JPanel;
        	Player2BattleShipInfo.add(damageStatus2[i]);
        }
        
        //Map Area Buttons
        JPanel gameCenterPanel = new JPanel(new BorderLayout());
        JButton[] button = new JButton[100];
        //Create MapPanel using GridLayout
        JPanel map = new JPanel(new GridLayout(10,10));
        map.setPreferredSize(new Dimension(300,280));
        for(int i = 0;i<button.length;i++) {
        	button[i] = new JButton();
        	//Adding 100 buttons to Map panel
        	map.add(button[i]);
        }
        //Addint to CenterPanel
        gameCenterPanel.add(map,BorderLayout.CENTER);
        
        //Creating SouthPanel
        JPanel gameSouthPanel = new JPanel(new BorderLayout());
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        JTextField chatInput = new JTextField();
        
        
        JLabel j1 = new JLabel("");
        JLabel j2 = new JLabel("");
        JLabel j3 = new JLabel("");
        JLabel j4 = new JLabel("");
        JLabel j5 = new JLabel("");
        JLabel j6 = new JLabel("");
        JLabel j7 = new JLabel("");
        JLabel j8 = new JLabel("");
        JLabel j9 = new JLabel("");
        JLabel j10 = new JLabel("");
        JLabel j11 = new JLabel("");
        JLabel j12 = new JLabel("");
//        JLabel j13 = new JLabel("s");
//        JPanel gameSouthCenterChatPanel = new JPanel(new GridLayout(2,0));
        JPanel gameSouthCenterChatPanel = new JPanel(new BorderLayout());
        gameSouthCenterChatPanel.add(chatScrollPane,BorderLayout.CENTER);
        gameSouthCenterChatPanel.add(chatInput,BorderLayout.SOUTH);

        //Creating setting,swap,send,buttons and add it to gameSettingButtonPanel
        JButton swapButton = new JButton("Swap Map");
        JButton settingButton = new JButton("Setting");
        JButton send = new JButton("Send");
        JPanel gameSettingButtonPanel = new JPanel(new GridLayout(5,0));
        gameSettingButtonPanel.add(j1);
        gameSettingButtonPanel.add(swapButton);
        gameSettingButtonPanel.add(j2);
        gameSettingButtonPanel.add(j3);
        gameSettingButtonPanel.add(j4);
        gameSettingButtonPanel.add(settingButton);     
        gameSettingButtonPanel.add(j5);
        gameSettingButtonPanel.add(j6);
        gameSettingButtonPanel.add(send);
        
        //Creating buttonsPanel
        JPanel buttonsPanel = new JPanel(new GridLayout(5,0));
        JButton one = new JButton("one           ");
        JButton two = new JButton("two");
        JButton three = new JButton("three");
        buttonsPanel.add(one);
        buttonsPanel.add(j7);
        buttonsPanel.add(j8);
        buttonsPanel.add(j9);
        buttonsPanel.add(two);
        buttonsPanel.add(j10);
        buttonsPanel.add(j11);
        buttonsPanel.add(j12);
        buttonsPanel.add(three);
        
        
        gameSouthPanel.add(gameSouthCenterChatPanel,BorderLayout.CENTER);
        gameSouthPanel.add(buttonsPanel,BorderLayout.WEST);
        gameSouthPanel.add(gameSettingButtonPanel,BorderLayout.EAST);
        
        game.add(Player1BattleShipInfo,BorderLayout.WEST);
        game.add(Player2BattleShipInfo,BorderLayout.EAST);
        game.add(gameCenterPanel,BorderLayout.CENTER);
        game.add(gameSouthPanel,BorderLayout.SOUTH);
        game.add(gameNorthPanel,BorderLayout.NORTH);
        
        
        
        game.setVisible(true);
		
	}

}
