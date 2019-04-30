import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Toolkit;

public class OnBoard {

    protected JPanel p;

    public Checkerz c;

    public boolean player1Turn = true;

    protected int[][][] theBoard = new int[8][8][2];

    public int[][] theCurrentClickBoard = new int[8][8];

    protected boolean isClicked;

    public boolean bestMove;
    
    public OnBoard() {

        super();

        c = new Checkerz(this);

        p = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(Color.CYAN);
                //odd horizontal cyan
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 0, 110, 110);
                    if(theBoard[i/110][0][0] == 1001){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 0*110+50, i+50+10, 0*110+80);
                        g2.drawLine(i+50+10, 0*110+80, i+90+10, 0*110+0);
                        g2.setColor(Color.CYAN);
                    } else if(theBoard[i/110][0][0] == 1000){
                        g2.setColor(Color.BLACK);
                        g2.drawLine(i+50, 0*110+50, i+50+10, 0*110+80);
                        g2.drawLine(i+50+10, 0*110+80, i+90+10, 0*110+0);
                        g2.setColor(Color.CYAN);
                    }
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 220, 110, 110);
                    if(theBoard[i/110][2][0] == 1001){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 2*110+50, i+50+10, 2*110+80);
                        g2.drawLine(i+50+10, 2*110+80, i+90+10, 2*110+0);
                        g2.setColor(Color.CYAN);
                    } else if(theBoard[i/110][2][0] == 1000){
                        g2.setColor(Color.BLACK);
                        g2.drawLine(i+50, 2*110+50, i+50+10, 2*110+80);
                        g2.drawLine(i+50+10, 2*110+80, i+90+10, 2*110+0);
                        g2.setColor(Color.CYAN);
                    }
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 440, 110, 110);
                    if(theBoard[i/110][4][0] == 1001){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 4*110+50, i+50+10, 4*110+80);
                        g2.drawLine(i+50+10, 4*110+80, i+90+10, 4*110+0);
                        g2.setColor(Color.CYAN);
                    } else if(theBoard[i/110][4][0] == 1000){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 4*110+50, i+50+10, 4*110+80);
                        g2.drawLine(i+50+10, 4*110+80, i+90+10, 4*110+0);
                        g2.setColor(Color.CYAN);
                    }
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 660, 110, 110);
                    if(theBoard[i/110][6][0] == 1001){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 6*110+50, i+50+10, 6*110+80);
                        g2.drawLine(i+50+10, 6*110+80, i+90+10, 6*110+0);
                        g2.setColor(Color.CYAN);
                    } else if(theBoard[i/110][6][0] == 1000){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 6*110+50, i+50+10, 6*110+80);
                        g2.drawLine(i+50+10, 6*110+80, i+90+10, 6*110+0);
                        g2.setColor(Color.CYAN);
                    }
                }
                //even horizontal cyAn
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 110, 110, 110);
                    if(theBoard[i/110][1][0] == 1000){
                        g2.setColor(Color.BLACK);
                        g2.drawLine(i+50, 1*110+50, i+50+10, 1*110+80);
                        g2.drawLine(i+50+10, 1*110+80, i+90+10, 1*110+0);
                        g2.setColor(Color.CYAN);
                    } else if(theBoard[i/110][1][0] == 1001){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 1*110+50, i+50+10, 1*110+80);
                        g2.drawLine(i+50+10, 1*110+80, i+90+10, 1*110+0);
                        g2.setColor(Color.CYAN);
                    }
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 330, 110, 110);
                    if(theBoard[i/110][3][0] == 1000){
                        g2.setColor(Color.BLACK);
                        g2.drawLine(i+50, 3*110+50, i+50+10, 3*110+80);
                        g2.drawLine(i+50+10, 3*110+80, i+90+10, 3*110+0);
                        g2.setColor(Color.CYAN);
                    } else if(theBoard[i/110][3][0] == 1001){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 3*110+50, i+50+10, 3*110+80);
                        g2.drawLine(i+50+10, 3*110+80, i+90+10, 3*110+0);
                        g2.setColor(Color.CYAN);
                    }
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 550, 110, 110);
                    if(theBoard[i/110][5][0] == 1000){
                        g2.setColor(Color.BLACK);
                        g2.drawLine(i+50, 5*110+50, i+50+10, 5*110+80);
                        g2.drawLine(i+50+10, 5*110+80, i+90+10, 5*110+0);
                        g2.setColor(Color.CYAN);
                    } else if(theBoard[i/110][5][0] == 1001){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 5*110+50, i+50+10, 5*110+80);
                        g2.drawLine(i+50+10, 5*110+80, i+90+10, 5*110+0);
                        g2.setColor(Color.CYAN);
                    }
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 770, 110, 110);
                    if(theBoard[i/110][7][0] == 1000){
                        g2.setColor(Color.BLACK);
                        g2.drawLine(i+50, 7*110+50, i+50+10, 7*110+80);
                        g2.drawLine(i+50+10, 7*110+80, i+90+10, 7*110+0);
                        g2.setColor(Color.CYAN);
                    } else if(theBoard[i/110][7][0] == 1001){
                        g2.setColor(Color.RED);
                        g2.drawLine(i+50, 7*110+50, i+50+10, 7*110+80);
                        g2.drawLine(i+50+10, 7*110+80, i+90+10, 7*110+0);
                        g2.setColor(Color.CYAN);
                    }
                }
                g2.setColor(Color.yellow);
                //odd horizontal yellow
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 0, 110, 110);
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 220, 110, 110);
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 440, 110, 110);
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 660, 110, 110);
                }
                //even horizontal YELLOws
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 110, 110, 110);
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 330, 110, 110);
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 550, 110, 110);
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 770, 110, 110);
                }
                //drawPlayer 2
                g2.setColor(Color.red);
                try {
                    for(int i=0;i<8;i++) {
                        for(int j=0;j<8;j++) {
                            if(theBoard[i][j][0] == -1){
                                g2.fillOval(i*110+5, j*110+5, 100, 100);
                                if(theBoard[i][j][1] == -1) {
                                    g2.setColor(Color.blue);
                                    g2.drawString("Player 2 King", i*110+20, j*110+60);
                                }
                            }
                            g2.setColor(Color.red);
                        }
                    }
                } catch(NullPointerException npe) {}
                //draw_player 1
                g2.setColor(Color.green);
                try {
                    for(int i=0;i<8;i++) {
                        for(int j=0;j<8;j++) {
                            if(theBoard[i][j][0] == 1) {
                                g2.fillOval(i*110+5, j*110+5, 100, 100);
                                if(theBoard[i][j][1] == -1) {
                                    g2.setColor(Color.blue);
                                    g2.drawString("Player 1 King", i*110+20, j*110+60);
                                }
                            }
                            g2.setColor(Color.green);
                        }
                    }
                } catch(NullPointerException npe) {}
                repaint();
            }
            public Dimension getPreferredSize() {
                return new Dimension(900,920);
            }
        };
        p.setBounds(c.getPanel().getBounds());
        c.getPanel().add(p);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        c.getPanel().setLocation(dim.width/2-c.getPanel().getSize().width/2, dim.height/2-c.getPanel().getSize().height/2);
        c.getPanel().setVisible(true);
    }

    public static void main(String[] args) {
        new OnBoard();
    }
}