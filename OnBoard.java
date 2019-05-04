import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class OnBoard {
    private boolean first = true;

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
    
    private Image redPiece = null;
    private Image greenPiece = null;

    
    public OnBoard() throws Exception {
        
        redPiece = ImageIO.read(getClass().getResource("redpiece.png"));
        greenPiece = ImageIO.read(getClass().getResource("greenpiece.png"));
        
        JFrame splashFrame = new JFrame();
        splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashFrame.setUndecorated(true);
        
        final JLabel title = new JLabel("Let's Heal The World On Youtube Checkers");


        JPanel pp = new JPanel() {


            @Override
            public void paintComponent(Graphics g) {


                if (first) {
                    Graphics2D g2d = (Graphics2D) g.create();

                    title.setBounds(20,5,280,20);
                    this.removeAll();
                    this.add(title);

                    repaint();

                    Thread thd = new Thread() {


                        public void run() {


                            try {


                                try {

                                    
                                    int xxx=0;
                                    int yyy=120;
                                    int yyy2=100;

                                    
                                    boolean goingDown = false;
                                    boolean goingDown2 = true;

                                    
                                    g2d.setColor(Color.cyan);

                                    
                                    
                                    while (true) {


                                        g2d.fillRect(0, 40, 500, 160);
                                        g2d.drawImage(greenPiece, xxx,yyy,40,40,null);
                                        g2d.drawImage(redPiece, xxx+10,yyy2,40,40,null);
                                        repaint();

                                        xxx+=1;

                                        if (!goingDown) {
                                            if (yyy > 100)
                                                yyy-=1;
                                            else
                                                goingDown = true;
                                        } else {
                                            if (yyy < 130)
                                                yyy+=1;
                                            else
                                                goingDown = false;
                                        }

                                        if (goingDown2) {
                                            if (yyy2 < 130)
                                                yyy2+=1;
                                            else
                                                goingDown2 = false;
                                        } else {
                                            if (yyy2 > 100)
                                                yyy2-=1;
                                            else
                                                goingDown2 = true;
                                        }

                                        Thread.sleep(15);

                                        if (xxx > 400)
                                            break;
                                    }

                                } catch (Exception e) {
                                    
                                }



                                Thread.sleep(2000); // 2 seconds asleep
                                splashFrame.dispose();
                                showReadyToPlayMessage();


                                c = new Checkerz(OnBoard.this);

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

                                
                                

                            } catch( Exception e) {}
                        }
                    };

                    first = false;

                    thd.start();

                }

            }

        };

        splashFrame.setLayout(null);

        splashFrame.setBounds(0,0,500,200);

        pp.setBounds(splashFrame.getBounds());

        splashFrame.add(pp);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        splashFrame.setLocation(dim.width/2-splashFrame.getSize().width/2,
                dim.height/2-splashFrame.getSize().height/2);

        splashFrame.setVisible(true);
    }
    
    private void draw() {


        drawCheckerBoard();


        drawPlayer(1);


        drawPlayer(2);
    }
    
    private void showReadyToPlayMessage() {


        JOptionPane.showMessageDialog(null, "Red player is 1st Player and goes first, OK?!  Ready? Set,, go!...");
    }
    
    private void setReadyMsg() {


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


        g2.setColor(Color.cyan);

        
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 0, SQUARE_LENGTH, SQUARE_LENGTH);
        }

        
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 220, SQUARE_LENGTH, SQUARE_LENGTH);
        }

        
        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 440, SQUARE_LENGTH, SQUARE_LENGTH);
        }


        for (int i=0; i<800; i+=220) {
            g2.fillRect(i, 660, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        
        
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, SQUARE_LENGTH, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        
        
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 330, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        
        
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 550, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        
        
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
            g2.fillRect(i, 770, SQUARE_LENGTH, SQUARE_LENGTH);
        }
        



        
        g2.setColor(Color.black);

        
        
        for (int i=SQUARE_LENGTH; i<800; i+=220) {
        
            g2.fillRect(i, 0, SQUARE_LENGTH, SQUARE_LENGTH);
            
            if (theBoard[i/SQUARE_LENGTH][0][0] == SELECTED_RED){
            
                g2.setColor(Color.green);
                
                g2.drawLine(i+50, 0*SQUARE_LENGTH+50, i+50+10, 0*SQUARE_LENGTH+80);
            
                g2.drawLine(i+50+10, 0*SQUARE_LENGTH+80, i+90+10, 0*SQUARE_LENGTH+20);
                
                g2.setColor(Color.black);
            
            } else if (theBoard[i/SQUARE_LENGTH][0][0] == SELECTED_BLACK){
                
                g2.setColor(Color.red);
                
                g2.drawLine(i+50, 0*SQUARE_LENGTH+50, i+50+10, 0*SQUARE_LENGTH+80);
                
                g2.drawLine(i+50+10, 0*SQUARE_LENGTH+80, i+90+10, 0*SQUARE_LENGTH+20);
                
                g2.setColor(Color.black);
            }
        }


        for (int i=SQUARE_LENGTH; i<800; i+=220) {


            g2.fillRect(i, 220, SQUARE_LENGTH, SQUARE_LENGTH);

            if (theBoard[i/SQUARE_LENGTH][2][0] == SELECTED_RED){

                g2.setColor(Color.green);

                g2.drawLine(i+50, 2*SQUARE_LENGTH+50, i+50+10, 2*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 2*SQUARE_LENGTH+80, i+90+10, 2*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            } else if (theBoard[i/SQUARE_LENGTH][2][0] == SELECTED_BLACK){

                g2.setColor(Color.red);

                g2.drawLine(i+50, 2*SQUARE_LENGTH+50, i+50+10, 2*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 2*SQUARE_LENGTH+80, i+90+10, 2*SQUARE_LENGTH+20);

                g2.setColor(Color.black);
            }
        }

        for (int i=SQUARE_LENGTH; i<800; i+=220) {


            g2.fillRect(i, 440, SQUARE_LENGTH, SQUARE_LENGTH);

            if (theBoard[i/SQUARE_LENGTH][4][0] == SELECTED_RED){

                g2.setColor(Color.green);

                g2.drawLine(i+50, 4*SQUARE_LENGTH+50, i+50+10, 4*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 4*SQUARE_LENGTH+80, i+90+10, 4*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            } else if (theBoard[i/SQUARE_LENGTH][4][0] == SELECTED_BLACK){

                g2.setColor(Color.red);

                g2.drawLine(i+50, 4*SQUARE_LENGTH+50, i+50+10, 4*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 4*SQUARE_LENGTH+80, i+90+10, 4*SQUARE_LENGTH+20);

                g2.setColor(Color.black);
            }
        }

        for (int i=SQUARE_LENGTH; i<800; i+=220) {


            g2.fillRect(i, 660, SQUARE_LENGTH, SQUARE_LENGTH);

            if (theBoard[i/SQUARE_LENGTH][6][0] == SELECTED_RED){

                g2.setColor(Color.green);

                g2.drawLine(i+50, 6*SQUARE_LENGTH+50, i+50+10, 6*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 6*SQUARE_LENGTH+80, i+90+10, 6*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            } else if (theBoard[i/SQUARE_LENGTH][6][0] == SELECTED_BLACK){

                g2.setColor(Color.red);

                g2.drawLine(i+50, 6*SQUARE_LENGTH+50, i+50+10, 6*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 6*SQUARE_LENGTH+80, i+90+10, 6*SQUARE_LENGTH+20);

                g2.setColor(Color.black);
            }
        }


        for (int i=0; i<800; i+=220) {

            g2.fillRect(i, 110, SQUARE_LENGTH, SQUARE_LENGTH);

            if (theBoard[i/SQUARE_LENGTH][1][0] == SELECTED_BLACK){

                g2.setColor(Color.red);

                g2.drawLine(i+50, 1*SQUARE_LENGTH+50, i+50+10, 1*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 1*SQUARE_LENGTH+80, i+90+10, 1*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            } else if (theBoard[i/SQUARE_LENGTH][1][0] == SELECTED_RED){

                g2.setColor(Color.green);

                g2.drawLine(i+50, 1*SQUARE_LENGTH+50, i+50+10, 1*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 1*SQUARE_LENGTH+80, i+90+10, 1*SQUARE_LENGTH+20);

                g2.setColor(Color.black);
            }
        }

        for (int i=0; i<800; i+=220) {

            g2.fillRect(i, 330, SQUARE_LENGTH, SQUARE_LENGTH);

            if (theBoard[i/SQUARE_LENGTH][3][0] == SELECTED_BLACK){

                g2.setColor(Color.red);

                g2.drawLine(i+50, 3*SQUARE_LENGTH+50, i+50+10, 3*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 3*SQUARE_LENGTH+80, i+90+10, 3*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            } else if (theBoard[i/SQUARE_LENGTH][3][0] == SELECTED_RED){

                g2.setColor(Color.green);

                g2.drawLine(i+50, 3*SQUARE_LENGTH+50, i+50+10, 3*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 3*SQUARE_LENGTH+80, i+90+10, 3*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            }
        }

        for (int i=0; i<800; i+=220) {

            g2.fillRect(i, 550, SQUARE_LENGTH, SQUARE_LENGTH);

            if (theBoard[i/SQUARE_LENGTH][5][0] == SELECTED_BLACK){

                g2.setColor(Color.red);

                g2.drawLine(i+50, 5*SQUARE_LENGTH+50, i+50+10, 5*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 5*SQUARE_LENGTH+80, i+90+10, 5*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            } else if (theBoard[i/SQUARE_LENGTH][5][0] == SELECTED_RED){

                g2.setColor(Color.green);

                g2.drawLine(i+50, 5*SQUARE_LENGTH+50, i+50+10, 5*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 5*SQUARE_LENGTH+80, i+90+10, 5*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            }
        }

        for (int i=0; i<800; i+=220) {

            g2.fillRect(i, 770, SQUARE_LENGTH, SQUARE_LENGTH);

            if (theBoard[i/SQUARE_LENGTH][7][0] == SELECTED_BLACK){

                g2.setColor(Color.red);

                g2.drawLine(i+50, 7*SQUARE_LENGTH+50, i+50+10, 7*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 7*SQUARE_LENGTH+80, i+90+10, 7*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            } else if (theBoard[i/SQUARE_LENGTH][7][0] == SELECTED_RED){

                g2.setColor(Color.green);

                g2.drawLine(i+50, 7*SQUARE_LENGTH+50, i+50+10, 7*SQUARE_LENGTH+80);

                g2.drawLine(i+50+10, 7*SQUARE_LENGTH+80, i+90+10, 7*SQUARE_LENGTH+20);

                g2.setColor(Color.black);

            }

        }

    }

    private void drawPlayer(int player) {


        int thePlayer = player == 1 ? 1 : -1;

        if (player == 2)
            thePlayer = -1;

        try {

            g2.setColor(Color.blue);

            for (int i=0;i<8;i++) {

                for (int j=0;j<8;j++) {

                    if (theBoard[i][j][0] == thePlayer){

                        if (player == 1)
                            g2.drawImage(redPiece, i*SQUARE_LENGTH+5, j*SQUARE_LENGTH+5, 100, 100, null);
                        else if (player == 2)
                            g2.drawImage(greenPiece, i*SQUARE_LENGTH+5, j*SQUARE_LENGTH+5, 100, 100, null);

                        if (theBoard[i][j][1] == -1) {
                            g2.drawString("Player " + player + " King", i*SQUARE_LENGTH+20, j*SQUARE_LENGTH+60);
                        }
                    }
                }
            }
            
        } catch (Exception e) {}

    }

}