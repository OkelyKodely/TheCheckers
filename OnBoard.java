import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;

public class OnBoard {
    public static void main(String[] args) {
        new OnBoard();
    }

    protected JPanel p;
    public Checkerz c;
    public boolean player1Turn = true;
    protected int[][] theBoard = new int[8][8];
    public int[][] theCurrentClickBoard = new int[8][8];
    protected boolean isClicked;
    
    public OnBoard() {
        c = new Checkerz(this);
        p = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(Color.black);
                //odd horizontal blacks
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 0, 110, 110);
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 220, 110, 110);
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 440, 110, 110);
                }
                for(int i=0; i<800; i+=220) {
                    g2.fillRect(i, 660, 110, 110);
                }
                //even horizontal blacks
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 110, 110, 110);
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 330, 110, 110);
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 550, 110, 110);
                }
                for(int i=110; i<800; i+=220) {
                    g2.fillRect(i, 770, 110, 110);
                }
                g2.setColor(Color.blue);
                //odd horizontal blues
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
                //even horizontal BLueS
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
                            if(theBoard[i][j] == -1)
                                g2.fillOval(i*110, j*110, 110, 110);
                        }
                    }
                } catch(NullPointerException npe) {
                    npe.printStackTrace();
                }
                //draw_player 1
                g2.setColor(Color.green);
                try {
                    for(int i=0;i<8;i++) {
                        for(int j=0;j<8;j++) {
                            if(theBoard[i][j] == 1)
                                g2.fillOval(i*110, j*110, 110, 110);
                        }
                    }
                } catch(NullPointerException npe) {
                    npe.printStackTrace();
                }
                //whites have no privilege
                repaint();
            }
            public Dimension getPreferredSize() {
                return new Dimension(900,920);
            }
        };
        p.setBounds( c.getPanel().getBounds());
        c.getPanel().add(p);
        c.getPanel().setVisible(true);
    }
}