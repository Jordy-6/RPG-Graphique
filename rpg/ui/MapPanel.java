package IHM.rpg.ui;


import IHM.rpg.game.Map;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MapPanel extends JPanel {

    static final int cellSize = 24;

    private String[][] mapGrid;

    private Image playerImage;

    public MapPanel(Map map) {
        this.mapGrid = map.getMap();
        //TODO: CHANGE PATH TO IMAGE
        ImageIcon img = new ImageIcon("C://Users//jper2//OneDrive//Documents//Licence pro//Java//Java test//src//IHM//rpg//ui//link.png");
        this.playerImage = img.getImage();
    }
    
    public Image getPlayerImage() {
        return this.playerImage;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int CoordX = 200;
        int CoordY = 50;

        for (int row = 0; row < this.mapGrid.length; row++) {
            for (int col = 0; col < this.mapGrid[0].length; col++) {
                Color color;
                switch (this.mapGrid[row][col]) {
                    case "D" : color = Color.BLACK; break;
                    case "P" : color = Color.CYAN; break;
                    case "S" : color = Color.GREEN; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
                if ("P".equals(this.mapGrid[row][col])) {
                    g.drawImage(this.getPlayerImage(), CoordX + cellSize * col, CoordY + cellSize * row, null);
                }
                g.setColor(Color.BLACK); // contours
                g.drawRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
            }
        }
        this.requestFocusInWindow();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }

    public void goUp() {
        int[] playerCoord = this.getPlayerCoord();
        int x = playerCoord[0];
        int y = playerCoord[1];
        if (x > 0 && !this.mapGrid[x-1][y].equals("D")) {
            this.mapGrid[x][y] = "";
            if("S".equals(this.mapGrid[x-1][y])) {
                JDialog dialog = new JDialog();
                dialog.setTitle("EXIT");
                dialog.setSize(200, 200);
                dialog.setLayout(new BorderLayout());
                JLabel label = new JLabel("Congratulations, you won", SwingConstants.CENTER);
                dialog.add(label, BorderLayout.CENTER);
                dialog.setLocationRelativeTo(null); // Center the dialog on the screen
                dialog.setVisible(true);
            }
            else{
                this.mapGrid[x-1][y] = "P";
            }
        }
        this.repaint();
    }

    public void goDown() {
        int[] playerCoord = this.getPlayerCoord();
        int x = playerCoord[0];
        int y = playerCoord[1];
        if (x < this.mapGrid.length-1 && !this.mapGrid[x+1][y].equals("D")) {
            this.mapGrid[x][y] = "";
            if("S".equals(this.mapGrid[x+1][y])) {
                JDialog dialog = new JDialog();
                dialog.setTitle("EXIT");
                dialog.setSize(200, 200);
                dialog.setLayout(new BorderLayout());
                JLabel label = new JLabel("Congratulations, you won", SwingConstants.CENTER);
                dialog.add(label, BorderLayout.CENTER);
                dialog.setLocationRelativeTo(null); // Center the dialog on the screen
                dialog.setVisible(true);
            }
            else{
                this.mapGrid[x+1][y] = "P";
            }

        }
        this.repaint();

    }

    public void goLeft() {
        int[] playerCoord = this.getPlayerCoord();
        int x = playerCoord[0];
        int y = playerCoord[1];
        if (y > 0 && !this.mapGrid[x][y-1].equals("D")) {
            this.mapGrid[x][y] = "";
            if("S".equals(this.mapGrid[x][y-1])) {
                JDialog dialog = new JDialog();
                dialog.setTitle("EXIT");
                dialog.setSize(200, 200);
                dialog.setLayout(new BorderLayout());
                JLabel label = new JLabel("Congratulations, you won", SwingConstants.CENTER);
                dialog.add(label, BorderLayout.CENTER);
                dialog.setLocationRelativeTo(null); // Center the dialog on the screen
                dialog.setVisible(true);
            }
            else{
                this.mapGrid[x][y-1] = "P";
            }
        }
        this.repaint();

    }

    public void goRight() {
        int[] playerCoord = this.getPlayerCoord();
        int x = playerCoord[0];
        int y = playerCoord[1];
        if (y < this.mapGrid[0].length-1 && !this.mapGrid[x][y+1].equals("D")) {
            this.mapGrid[x][y] = "";
            if("S".equals(this.mapGrid[x][y+1])) {
                JDialog dialog = new JDialog();
                dialog.setTitle("EXIT");
                dialog.setSize(200, 200);
                dialog.setLayout(new BorderLayout());
                JLabel label = new JLabel("Congratulations, you won", SwingConstants.CENTER);
                dialog.add(label, BorderLayout.CENTER);
                dialog.setLocationRelativeTo(null); // Center the dialog on the screen
                dialog.setVisible(true);
            }
            else{
                this.mapGrid[x][y+1] = "P";
            }

        }
        this.repaint();

    }

    private int[] getPlayerCoord() {
        int[] coord = new int[2];
        for (int row = 0; row < this.mapGrid.length; row++) {
            for (int col = 0; col < this.mapGrid[0].length; col++) {
                if (Objects.equals(this.mapGrid[row][col], "P")) {
                    coord[0] = row;
                    coord[1] = col;
                }
            }
        }
        return coord;
    }
}
