package IHM.rpg.ui;

import IHM.rpg.game.GameInputs;
import IHM.rpg.game.PlayerCast;
import IHM.rpg.game.WeaponStore;
import IHM.rpg.game.Weapons;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuStartPanel extends JPanel {

    private GameInputs gameInputs;
    private JLabel title;

    private JLabel pseudoLabel;
    private JTextField pseudoField;
    private JRadioButton radioMage;
    private JRadioButton radioWarrior;
    private JRadioButton radioElf;

    private ArrayList<JRadioButton> weaponButtons = new ArrayList<>();

    private WeaponStore weaponStore;

    public MenuStartPanel(GameInputs gameInputs) {
        this.gameInputs = gameInputs;
        this.weaponStore = this.gameInputs.getWeaponStore();
        initComponents();
    }

    private void setPlayerName(String name) {
        this.gameInputs.setPlayerName(name);
    }

    private void setPlayerCast() {
        PlayerCast playerClass = null;
        if (this.radioMage.isSelected()) {
            playerClass = PlayerCast.MAGE;
        } else if (this.radioElf.isSelected()) {
            playerClass = PlayerCast.ELF;
        } else if (this.radioWarrior.isSelected()){
            playerClass = PlayerCast.WARRIOR;
        }
        this.gameInputs.setPlayerCast(playerClass);

    }

    private void setPlayerWeapon() {
        for (int i = 0; i < weaponButtons.size(); i++) {
            JRadioButton weaponButton = weaponButtons.get(i);
            if (weaponButton.isSelected()) {
                Weapons weapon = this.weaponStore.getWeapons(i);
                this.gameInputs.addWeapon(weapon);
                break;
            }
        }
    }

    private void initComponents() {
        // define components
        this.title = new JLabel("WELCOME TO MY RPG");
        this.pseudoLabel = new JLabel("Choose your name : ");
        this.pseudoField = new JTextField();

        this.radioMage = new JRadioButton("MAGE");
        this.radioWarrior = new JRadioButton("WARRIOR");
        this.radioElf = new JRadioButton("ELF");



        // define panel layout
        this.setBorder(new EmptyBorder(50, 50, 50, 50));
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        /* GridBagConstraints parameters :
            int gridx,
            int gridy,
            int gridwidth,
            int gridheight,
            double weightx,
            double weighty,
            int anchor,
            int fill,
            java.awt.Insets insets,
            int ipadx,
            int ipady
         */
        this.setLayout(gridbag);
        gbc.fill = GridBagConstraints.BOTH;

        // add components to panel
        // title
        this.title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        gbc.gridwidth =  3;  // 3 columns wide
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(this.title, gbc);
        this.add(this.title);


        // player classes radio buttons
        // mage
        this.radioMage.setSelected(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioMage, gbc);
        // elf
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioElf, gbc);

        // warrior
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioWarrior, gbc);

        ButtonGroup group = new ButtonGroup();
        group.add(this.radioMage);
        group.add(this.radioElf);
        group.add(this.radioWarrior);
        this.add(this.radioMage);
        this.add(this.radioElf);
        this.add(this.radioWarrior);


    // Add title "Weaponstore"
    JLabel weaponStoreTitle = new JLabel("Weaponstore");
    this.add(weaponStoreTitle,
            new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(50, 0, 30, 0), 0, 0));

    // Add radio buttons for each weapon in the WeaponStore
    ButtonGroup weaponGroup = new ButtonGroup();
    for (int i = 0; i < this.weaponStore.getWeaponsList().size(); i++) {
        Weapons weapon = this.weaponStore.getWeapons(i);
        JRadioButton weaponButton = new JRadioButton(weapon.toString());
        weaponGroup.add(weaponButton);
        weaponButtons.add(weaponButton);
        this.add(weaponButton,
                new GridBagConstraints(0, 3 + i, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(10, 0, 10, 0), 0, 0));
    }

    // pseudo of the player
    this.add(this.pseudoLabel,
            new GridBagConstraints(0, 3 + this.weaponStore.getWeaponsList().size(), 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(50, 0, 30, 0), 0, 0));
    this.pseudoField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                JTextField textField = (JTextField) e.getSource();
                System.out.println(textField.getText());
                setPlayerName(textField.getText());
                setPlayerCast();
                setPlayerWeapon();

            }
        }
    });
    this.add(this.pseudoField,
            new GridBagConstraints(1, 3 + this.weaponStore.getWeaponsList().size(), 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(50, 0, 30, 0), 0, 0));

    // ... existing code ...
}
}
