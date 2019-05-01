import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class OnBoard {

    private JPanel p = null;

    private Graphics2D g2 = null;

    private Checkerz c = null;

    private boolean graphicsCreated = false;

    public boolean isClicked = false;
    public boolean player1Turn = true;

    public int[][][] theBoard = new int[8][8][2];

    public int[][] theCurrentClickBoard = new int[8][8];

    private final int GAME_WIDTH = 900;
    private final int GAME_HEIGHT = 920;
    private final int SQUARE_LENGTH = 110;
    private final int SELECTED_RED = 1001;
    private final int SELECTED_BLACK = 1000;

    public OnBoard() {

        c = new Checkerz(this);

        p = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                if (!graphicsCreated) {
                    g2 = (Graphics2D) g.create();
                    graphicsCreated = true;
                }

                draw();

                repaint();
            }

            public Dimension getPreferredSize() {
                return new Dimension(GAME_WIDTH, GAME_HEIGHT);
            }
        };

        setFrame();
    }
    
    private void draw() {
        drawCheckerBoard();
        drawPlayer(1);
        drawPlayer(2);
    }
    
    private void showReadyToPlayMessage() {
        JOptionPane.showMessageDialog(c.getPanel(), "Ready?");
    }
    
    protected void setReadyMsg() {
        showReadyToPlayMessage();
    }
    
    private void setFrame() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        Rectangle rect = c.getPanel().getBounds();
        p.setBounds(rect);

        c.getPanel().add(p);

        c.getPanel().setLocation(dim.width/2-c.getPanel().getSize().width/2,
                dim.height/2-c.getPanel().getSize().height/2);
        c.getPanel().setVisible(true);
    }
    
    private void drawCheckerBoard() {
        g2.setColor(Color.DARK_GRAY);
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 0, SQUARE_LENGTH, SQUARE_LENGTH);
            if (theBoard[i/SQUARE_LENGTH][0][0] == SELECTED_RED){
                g2.setColor(Color.RED);
                g2.drawLine(i+50, 0*SQUARE_LENGTH+50, i+50+10, 0*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 0*SQUARE_LENGTH+80, i+90+10, 0*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            } else if (theBoard[i/SQUARE_LENGTH][0][0] == SELECTED_BLACK){
                g2.setColor(Color.GREEN);
                g2.drawLine(i+50, 0*SQUARE_LENGTH+50, i+50+10, 0*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 0*SQUARE_LENGTH+80, i+90+10, 0*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            }
        }
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 220, SQUARE_LENGTH, SQUARE_LENGTH);
            if (theBoard[i/SQUARE_LENGTH][2][0] == SELECTED_RED){
                g2.setColor(Color.RED);
                g2.drawLine(i+50, 2*SQUARE_LENGTH+50, i+50+10, 2*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 2*SQUARE_LENGTH+80, i+90+10, 2*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            } else if (theBoard[i/SQUARE_LENGTH][2][0] == SELECTED_BLACK){
                g2.setColor(Color.GREEN);
                g2.drawLine(i+50, 2*SQUARE_LENGTH+50, i+50+10, 2*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 2*SQUARE_LENGTH+80, i+90+10, 2*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            }
        }
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 440, SQUARE_LENGTH, SQUARE_LENGTH);
            if (theBoard[i/SQUARE_LENGTH][4][0] == SELECTED_RED){
                g2.setColor(Color.RED);
                g2.drawLine(i+50, 4*SQUARE_LENGTH+50, i+50+10, 4*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 4*SQUARE_LENGTH+80, i+90+10, 4*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            } else if (theBoard[i/SQUARE_LENGTH][4][0] == SELECTED_BLACK){
                g2.setColor(Color.GREEN);
                g2.drawLine(i+50, 4*SQUARE_LENGTH+50, i+50+10, 4*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 4*SQUARE_LENGTH+80, i+90+10, 4*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            }
        }
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 660, SQUARE_LENGTH, SQUARE_LENGTH);
            if (theBoard[i/SQUARE_LENGTH][6][0] == SELECTED_RED){
                g2.setColor(Color.RED);
                g2.drawLine(i+50, 6*SQUARE_LENGTH+50, i+50+10, 6*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 6*SQUARE_LENGTH+80, i+90+10, 6*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            } else if (theBoard[i/SQUARE_LENGTH][6][0] == SELECTED_BLACK){
                g2.setColor(Color.GREEN);
                g2.drawLine(i+50, 6*SQUARE_LENGTH+50, i+50+10, 6*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 6*SQUARE_LENGTH+80, i+90+10, 6*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            }
        }
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, SQUARE_LENGTH, SQUARE_LENGTH, SQUARE_LENGTH);
            if (theBoard[i/SQUARE_LENGTH][1][0] == SELECTED_BLACK){
                g2.setColor(Color.GREEN);
                g2.drawLine(i+50, 1*SQUARE_LENGTH+50, i+50+10, 1*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 1*SQUARE_LENGTH+80, i+90+10, 1*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            } else if (theBoard[i/SQUARE_LENGTH][1][0] == SELECTED_RED){
                g2.setColor(Color.RED);
                g2.drawLine(i+50, 1*SQUARE_LENGTH+50, i+50+10, 1*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 1*SQUARE_LENGTH+80, i+90+10, 1*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            }
        }
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 330, SQUARE_LENGTH, SQUARE_LENGTH);
            if (theBoard[i/SQUARE_LENGTH][3][0] == SELECTED_BLACK){
                g2.setColor(Color.GREEN);
                g2.drawLine(i+50, 3*SQUARE_LENGTH+50, i+50+10, 3*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 3*SQUARE_LENGTH+80, i+90+10, 3*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            } else if (theBoard[i/SQUARE_LENGTH][3][0] == SELECTED_RED){
                g2.setColor(Color.RED);
                g2.drawLine(i+50, 3*SQUARE_LENGTH+50, i+50+10, 3*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 3*SQUARE_LENGTH+80, i+90+10, 3*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            }
        }
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 550, SQUARE_LENGTH, SQUARE_LENGTH);
            if (theBoard[i/SQUARE_LENGTH][5][0] == SELECTED_BLACK){
                g2.setColor(Color.GREEN);
                g2.drawLine(i+50, 5*SQUARE_LENGTH+50, i+50+10, 5*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 5*SQUARE_LENGTH+80, i+90+10, 5*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            } else if (theBoard[i/SQUARE_LENGTH][5][0] == SELECTED_RED){
                g2.setColor(Color.RED);
                g2.drawLine(i+50, 5*SQUARE_LENGTH+50, i+50+10, 5*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 5*SQUARE_LENGTH+80, i+90+10, 5*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            }
        }
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 770, SQUARE_LENGTH, SQUARE_LENGTH);
            if (theBoard[i/SQUARE_LENGTH][7][0] == SELECTED_BLACK){
                g2.setColor(Color.GREEN);
                g2.drawLine(i+50, 7*SQUARE_LENGTH+50, i+50+10, 7*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 7*SQUARE_LENGTH+80, i+90+10, 7*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            } else if (theBoard[i/SQUARE_LENGTH][7][0] == SELECTED_RED){
                g2.setColor(Color.RED);
                g2.drawLine(i+50, 7*SQUARE_LENGTH+50, i+50+10, 7*SQUARE_LENGTH+80);
                g2.drawLine(i+50+10, 7*SQUARE_LENGTH+80, i+90+10, 7*SQUARE_LENGTH+20);
                g2.setColor(Color.DARK_GRAY);
            }
        }
        g2.setColor(Color.LIGHT_GRAY);
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 0, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 220, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 440, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 660, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        //even horizontal YELLOws
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, SQUARE_LENGTH, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 330, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 550, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 770, SQUARE_LENGTH, SQUARE_LENGTH);
        }
    }

    private void drawPlayer(int player) {
        int thePlayer = player == 1 ? 1 : -1;
        if (player == 2)
            thePlayer = -1;
        if (player == 1)
            g2.setColor(Color.red);
        else if (player == 2)
            g2.setColor(Color.green);
        try {
            for (int i=0;i<8;i++) {
                for (int j=0;j<8;j++) {
                    if (theBoard[i][j][0] == thePlayer){
                        g2.fillOval(i*SQUARE_LENGTH+5, j*SQUARE_LENGTH+5, 100, 100);
                        if (theBoard[i][j][1] == -1) {
                            g2.setColor(Color.blue);
                            g2.drawString("Player " + player + " King", i*SQUARE_LENGTH+20, j*SQUARE_LENGTH+60);
                        }
                    }
                    if (player == 1)
                        g2.setColor(Color.red);
                    else if (player == 2)
                        g2.setColor(Color.green);
                }
            }
        } catch(Exception e) {}
    }
}