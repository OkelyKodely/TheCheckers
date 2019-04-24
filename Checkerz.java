import javax.swing.JFrame;
import java.awt.event.*;

public class Checkerz implements MouseListener {
    private JFrame panel;

    public JFrame getPanel() {
        return panel;
    }

    public void setPanel(JFrame panel) {
        this.panel = panel;
    }

    public OnBoard getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(OnBoard onBoard) {
        this.onBoard = onBoard;
    }
    
    protected OnBoard onBoard;
    
    public Checkerz(OnBoard deez) {
        super();
        onBoard = deez;
        panel = new JFrame();
        panel.setTitle("Checkers");
        panel.setBounds(0,0,900,920);
        panel.setPreferredSize(panel.getBounds().getSize());
        panel.addMouseListener(this);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.pack();
        panel.setResizable(false);
        panel.setVisible(true);
        //player 2 initial
        for(int i=0;i<8;i+=2)
            onBoard.theBoard[i][0] = -1;
        for(int i=1;i<8;i+=2)
            onBoard.theBoard[i][1] = -1;
        for(int i=0;i<8;i+=2)
            onBoard.theBoard[i][2] = -1;
        //player onE initial
        for(int i=1;i<8;i+=2)
            onBoard.theBoard[i][5] = 1;
        for(int i=0;i<8;i+=2)
            onBoard.theBoard[i][6] = 1;
        for(int i=1;i<8;i+=2)
            onBoard.theBoard[i][7] = 1;
    }
    
    protected void moveTo(int x, int y) {
        int ii=-1,jj=-1;
        if(onBoard.isClicked) {
            if(onBoard.player1Turn) {
                for(int i=0; i<8; i++) {
                    for(int j=0; j<8; j++) {
                        if(onBoard.theCurrentClickBoard[i][j]==1) {
                            onBoard.theBoard[i][j] = 0;
                            ii=i; jj=j;
                            onBoard.theCurrentClickBoard[i][j] = 0;
                        }
                    }
                }
                onBoard.theBoard[x][y] = 1;
                if(x==ii-2&&y==jj-2) {
                    onBoard.theBoard[x+1][y+1] =0;
                }
                if(x==ii+2&&y==jj-2) {
                    onBoard.theBoard[x-1][y+1] =0;
                }
                onBoard.player1Turn = false;
            } else if(!onBoard.player1Turn) {
                for(int i=0; i<8; i++) {
                    for(int j=0; j<8; j++) {
                        if(onBoard.theCurrentClickBoard[i][j]==-1) {
                            onBoard.theBoard[i][j] = 0;
                            ii=i; jj=j;
                            onBoard.theCurrentClickBoard[i][j] = 0;
                        }
                    }
                }
                onBoard.theBoard[x][y] = -1;
                if(x==ii-2&&y==jj+2) {
                    onBoard.theBoard[x+1][y-1] =0;
                }
                if(x==ii+2&&y==jj+2) {
                    onBoard.theBoard[x-1][y-1] =0;
                }
                onBoard.player1Turn = true;
            }
            onBoard.isClicked = false;
        } else if(!onBoard.isClicked) {
            if(onBoard.player1Turn) {
                if(onBoard.theBoard[x][y] != 0){
                    onBoard.theCurrentClickBoard[x][y] = 1;
                    onBoard.theBoard[x][y] = 0;
                    onBoard.isClicked = true;
                }
            } else if(!onBoard.player1Turn) {
                if(onBoard.theBoard[x][y] != 0){
                    onBoard.theCurrentClickBoard[x][y] = -1;
                    onBoard.theBoard[x][y] = 0;
                    onBoard.isClicked = true;
                }
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x=e.getPoint().x/110; int y= e.getPoint().y/110;
        moveTo(x,y);
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}