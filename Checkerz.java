import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.event.*;

public class Checkerz implements MouseListener {

    protected OnBoard onBoard;

    final int SQUARE_LENGTH = 110;
    
    private JFrame panel= null;
    
    private int fromX, fromY = -1;
    
    boolean a = false;
    boolean b = false;
    boolean c = false;
    
    public Checkerz(OnBoard deezKnuts) {

        super();

        onBoard = deezKnuts;

        initializeBoardPieces();

        panel = new JFrame();
        panel.setTitle("Checkers");
        panel.setBounds(0,0,900,920);
        panel.setPreferredSize(panel.getBounds().getSize());
        panel.addMouseListener(this);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setResizable(false);
        panel.pack();
    }
    
    private void initializeBoardPieces()
    {
        for(int i=0;i<8;i+=2)
            onBoard.theBoard[i][0][0] = -1;

        for(int i=1;i<8;i+=2)
            onBoard.theBoard[i][1][0] = -1;

        for(int i=0;i<8;i+=2)
            onBoard.theBoard[i][2][0] = -1;

        for(int i=1;i<8;i+=2)
            onBoard.theBoard[i][5][0] = 1;

        for(int i=0;i<8;i+=2)
            onBoard.theBoard[i][6][0] = 1;

        for(int i=1;i<8;i+=2)
            onBoard.theBoard[i][7][0] = 1;
    }
    
    private int[] getIiJjPosOne() {
        int ii=-1,jj=-1;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(onBoard.theCurrentClickBoard[i][j]==1) {
                    onBoard.theBoard[i][j][0] = 0;
                    ii=i; jj=j;
                    onBoard.theCurrentClickBoard[i][j] = 100;
                }
            }
        }
        int[] iijj = new int[2];
        iijj[0] = ii;
        iijj[1] = jj;
        return iijj;
    }
    
    private int[] getIiJjNegOne() {
        int ii=-1,jj=-1;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(onBoard.theCurrentClickBoard[i][j]==-1) {
                    onBoard.theBoard[i][j][0] = 0;
                    ii=i; jj=j;
                    onBoard.theCurrentClickBoard[i][j] = 200;
                }
            }
        }
        int[] iijj = new int[2];
        iijj[0] = ii;
        iijj[1] = jj;
        return iijj;
    }
    
    private void continue1CheckPlayerOne(int x, int y) {
        try {
            if((onBoard.theBoard[x+2][y-2][0] != 0) && (onBoard.theBoard[x-2][y-2][0] != 0)) {
                onBoard.player1Turn = false;
                onBoard.isClicked = false;
            } else if(c) {
                if(onBoard.theBoard[x+1][y-1][0] != 0 || onBoard.theBoard[x-1][y-1][0] != 0) {
                    this.fromX = x; this.fromY = y;
                    onBoard.theCurrentClickBoard[x][y] =1;
                    a = true;
                    onBoard.player1Turn = true;
                    onBoard.isClicked = true;
                } else {
                onBoard.player1Turn = false;
                onBoard.isClicked = false;
                }
            } else {
                onBoard.player1Turn = false;
                onBoard.isClicked = false;
            }
        } catch(Exception e1nottouse) {
            try {
                if(x-2 < 0 || x+2 > 7 || y-2 < 0) {
                    onBoard.player1Turn = false;
                    onBoard.isClicked = false;
                } else if(c) {
                    if(onBoard.theBoard[x+1][y-1][0] != 0 || onBoard.theBoard[x-1][y-1][0] != 0) {
                    this.fromX = x; this.fromY = y;
                    onBoard.theCurrentClickBoard[x][y] =1;
                    a = true;
                    onBoard.player1Turn = true;
                    onBoard.isClicked = true;
                    } else {
                    onBoard.player1Turn = false;
                    onBoard.isClicked = false;
                    }
                } else {
                    onBoard.player1Turn = false;
                    onBoard.isClicked = false;
                }
            } catch (Exception e2nottouse) {
                if(c) {
                    if(onBoard.theBoard[x+1][y-1][0] != 0 || onBoard.theBoard[x-1][y-1][0] != 0) {
                        this.fromX = x; this.fromY = y;
                        onBoard.theCurrentClickBoard[x][y] =1;
                        a = true;
                        onBoard.player1Turn = true;
                        onBoard.isClicked = true;
                    } else {
                        onBoard.player1Turn = false;
                        onBoard.isClicked = false;
                    }
                }
            }
        }
    }
    
    private void continueCheckPlayerOne(int x, int y) {
        try {
            if((onBoard.theBoard[x+2][y+2][0] != 0) && (onBoard.theBoard[x-2][y+2][0] != 0)) {
                onBoard.player1Turn = false;
                onBoard.isClicked = false;
            } else if(c) {
                if(onBoard.theBoard[x+1][y+1][0] != 0 || onBoard.theBoard[x-1][y+1][0] != 0) {
                    this.fromX = x; this.fromY = y;
                    onBoard.theCurrentClickBoard[x][y] =1;
                    a = true;
                    onBoard.player1Turn = true;
                    onBoard.isClicked = true;
                } else {
                onBoard.player1Turn = false;
                onBoard.isClicked = false;
                }
            } else {
                onBoard.player1Turn = false;
                onBoard.isClicked = false;
            }
        } catch(Exception e1nottouse) {
            try {
                if(x-2 < 0 || x+2 > 7 || y+2 > 7) {
                    onBoard.player1Turn = false;
                    onBoard.isClicked = false;
                } else if(c) {
                    if(onBoard.theBoard[x+1][y+1][0] != 0 || onBoard.theBoard[x-1][y+1][0] != 0) {
                    this.fromX = x; this.fromY = y;
                    onBoard.theCurrentClickBoard[x][y] =1;
                    a = true;
                    onBoard.player1Turn = true;
                    onBoard.isClicked = true;
                    } else {
                    onBoard.player1Turn = false;
                    onBoard.isClicked = false;
                    }
                } else {
                    onBoard.player1Turn = false;
                    onBoard.isClicked = false;
                }
            } catch (Exception e2nottouse) {
                if(c) {
                    if(onBoard.theBoard[x+1][y+1][0] != 0 || onBoard.theBoard[x-1][y+1][0] != 0) {
                        this.fromX = x; this.fromY = y;
                        onBoard.theCurrentClickBoard[x][y] =1;
                        a = true;
                        onBoard.player1Turn = true;
                        onBoard.isClicked = true;
                    } else {
                        onBoard.player1Turn = false;
                        onBoard.isClicked = false;
                    }
                }
            }
        }
    }

    protected void moveTo(int fromX, int fromY, int x, int y) {
        int ii=-1,jj=-1;
        if(onBoard.isClicked) {
            if(!squareIsEmpty(x, y))
                return;
            if(onBoard.player1Turn) {
                if(a) {
                    a = false;
                    b = false;
                    int[] iijj = new int[2];
                    iijj = getIiJjPosOne();
                    ii = iijj[0];
                    jj = iijj[1];
                    if((fromX+1 == x || fromX-1 == x) && fromY-1 == y) {
                        onBoard.theBoard[x][y][0] = 1;
                        if(fromY!=-1)
                            onBoard.theBoard[fromX][fromY][0] =0;
                    }
                    else if((fromX+2 == x || fromX-2 == x) && fromY-2 == y) {
                        if(fromX+2 == x) {
                            if(onBoard.theBoard[x-1][y+1][0] == -1) {
                                onBoard.theBoard[x][y][0] = 1;
                                if(fromY!=-1)
                                    onBoard.theBoard[fromX][fromY][0] =0;
                            } else {
                                onBoard.theBoard[fromX][fromY][0] = 1;
                                this.fromX = x; this.fromY = y;
                                onBoard.isClicked = false;
                                a = true;
                                b = false;
                                onBoard.player1Turn = true;
                                return;
                            }
                        } else if(fromX-2 == x) {
                            if(onBoard.theBoard[x+1][y+1][0] == -1) {
                                onBoard.theBoard[x][y][0] = 1;
                                if(fromY!=-1)
                                    onBoard.theBoard[fromX][fromY][0] =0;
                            } else {
                                onBoard.theBoard[fromX][fromY][0] = 1;
                                this.fromX = x; this.fromY = y;
                                onBoard.isClicked = false;
                                a = true;
                                b = false;
                                onBoard.player1Turn = true;
                                return;
                            }
                        }
                    }
                    else if((fromX+1 == x || fromX-1 == x) && fromY+1 == y) {
                        onBoard.theBoard[x][y][0] = 1;
                        if(fromY!=-1)
                            onBoard.theBoard[fromX][fromY][0] =0;
                    }
                    else if((fromX+2 == x || fromX-2 == x) && fromY+2 == y) {
                        if(fromX+2 == x) {
                            if(onBoard.theBoard[x-1][y-1][0] == -1) {
                                onBoard.theBoard[x][y][0] = 1;
                                if(fromY!=-1)
                                    onBoard.theBoard[fromX][fromY][0] =0;
                            } else {
                                onBoard.theBoard[fromX][fromY][0] = 1;
                                this.fromX = x; this.fromY = y;
                                onBoard.isClicked = false;
                                a = true;
                                b = false;
                                onBoard.player1Turn = true;
                                return;
                            }
                        } else if(fromX-2 == x) {
                            if(onBoard.theBoard[x+1][y-1][0] == -1) {
                                onBoard.theBoard[x][y][0] = 1;
                                if(fromY!=-1)
                                    onBoard.theBoard[fromX][fromY][0] =0;
                            } else {
                                onBoard.theBoard[fromX][fromY][0] = 1;
                                this.fromX = x; this.fromY = y;
                                onBoard.isClicked = false;
                                a = true;
                                b = false;
                                onBoard.player1Turn = true;
                                return;
                            }
                        }
                    }
                    else {
                        if(onBoard.theCurrentClickBoard[fromX][fromY] == 100){
                            onBoard.theBoard[fromX][fromY][0] = 1;
                            this.fromX = x; this.fromY = y;
                            onBoard.isClicked = false;
                            a = true;
                            b = false;
                            onBoard.player1Turn = true;
                            return;
                        }
                    }
                    if(onBoard.theBoard[fromX][fromY][1] == -1) {
                        onBoard.theBoard[x][y][1] = -1;
                    }
                    if(y==0) {
                        onBoard.theBoard[x][y][1] = -1;
                    }
                    if(onBoard.theBoard[x][y][1] == -1) {
                        if(x==ii-2&&y==jj+2) {
                            onBoard.theBoard[x+1][y-1][0] =0;
                            c = true;
                        } else {
                            c = false;
                        }
                        if(x==ii+2&&y==jj+2) {
                            onBoard.theBoard[x-1][y-1][0] =0;
                            c = true;
                        } else if(x!=ii-2||y!=jj+2) {
                            c = false;
                        }
                        continueCheckPlayerOne(x, y);
                    }
                    if(x==ii-2&&y==jj-2) {
                        onBoard.theBoard[x+1][y+1][0] =0;
                        c = true;
                    } else {
                        c = false;
                    }
                    if(x==ii+2&&y==jj-2) {
                        onBoard.theBoard[x-1][y+1][0] =0;
                        c = true;
                    } else if(x!=ii-2||y!=jj-2) {
                        c = false;
                    }
                    if(x==ii-2&&y==jj+2) {
                        onBoard.theBoard[x+1][y-1][0] =0;
                        c = true;
                    }
                    if(x==ii+2&&y==jj+2) {
                        onBoard.theBoard[x-1][y-1][0] =0;
                        c = true;
                    }
                    continue1CheckPlayerOne(x, y);
                }
            } else if(!onBoard.player1Turn) {
                if(b) {
                    b = false;
                    a = false;
                    int[] iijj = new int[2];
                    iijj = getIiJjNegOne();
                    ii = iijj[0];
                    jj = iijj[1];
                    if((fromX+1 == x || fromX-1 == x) && fromY-1 == y) {
                        onBoard.theBoard[x][y][0] = -1;
                        if(fromY!=-1)
                            onBoard.theBoard[fromX][fromY][0] =0;
                    }
                    else if((fromX+2 == x || fromX-2 == x) && fromY-2 == y) {
                        if(fromX+2 == x) {
                            if(onBoard.theBoard[x-1][y+1][0] == 1) {
                                onBoard.theBoard[x][y][0] = -1;
                                if(fromY!=-1)
                                    onBoard.theBoard[fromX][fromY][0] =0;
                            } else {
                                onBoard.theBoard[fromX][fromY][0] = -1;
                                this.fromX = x; this.fromY = y;
                                onBoard.isClicked = false;
                                a = false;
                                b = true;
                                onBoard.player1Turn = false;
                                return;
                            }
                        } else if(fromX-2 == x) {
                            if(onBoard.theBoard[x+1][y+1][0] == 1) {
                                onBoard.theBoard[x][y][0] = -1;
                                if(fromY!=-1)
                                    onBoard.theBoard[fromX][fromY][0] =0;
                            } else {
                                onBoard.theBoard[fromX][fromY][0] = -1;
                                this.fromX = x; this.fromY = y;
                                onBoard.isClicked = false;
                                a = false;
                                b = true;
                                onBoard.player1Turn = false;
                                return;
                            }
                        }
                    }
                    else if((fromX+1 == x || fromX-1 == x) && fromY+1 == y) {
                        onBoard.theBoard[x][y][0] = -1;
                        if(fromY!=-1)
                            onBoard.theBoard[fromX][fromY][0] =0;
                    }
                    else if((fromX+2 == x || fromX-2 == x) && fromY+2 == y) {
                        if(fromX+2 == x) {
                            if(onBoard.theBoard[x-1][y-1][0] == 1) {
                                onBoard.theBoard[x][y][0] = -1;
                                if(fromY!=-1)
                                    onBoard.theBoard[fromX][fromY][0] =0;
                            } else {
                                onBoard.theBoard[fromX][fromY][0] = -1;
                                this.fromX = x; this.fromY = y;
                                onBoard.isClicked = false;
                                a = false;
                                b = true;
                                onBoard.player1Turn = false;
                                return;
                            }
                        } else if(fromX-2 == x) {
                            if(onBoard.theBoard[x+1][y-1][0] == 1) {
                                onBoard.theBoard[x][y][0] = -1;
                                if(fromY!=-1)
                                    onBoard.theBoard[fromX][fromY][0] =0;
                            } else {
                                onBoard.theBoard[fromX][fromY][0] = -1;
                                this.fromX = x; this.fromY = y;
                                onBoard.isClicked = false;
                                a = false;
                                b = true;
                                onBoard.player1Turn = false;
                                return;
                            }
                        }
                    }
                    else {
                        if(onBoard.theCurrentClickBoard[fromX][fromY] == 200){
                            onBoard.theBoard[fromX][fromY][0] = -1;
                            this.fromX = x; this.fromY = y;
                            onBoard.isClicked = false;
                            a = false;
                            b = true;
                            onBoard.player1Turn = false;
                            return;
                        }
                    }
                    if(onBoard.theBoard[fromX][fromY][1] == -1) {
                        onBoard.theBoard[x][y][1] = -1;
                    }
                    if(y==7) {
                        onBoard.theBoard[x][y][1] = -1;
                    }
                    if(onBoard.theBoard[x][y][1] == -1) {
                        if(x==ii-2&&y==jj-2) {
                            onBoard.theBoard[x+1][y+1][0] =0;
                            c = true;
                        }
                        else {
                            c = false;
                        }
                        if(x==ii+2&&y==jj-2) {
                            onBoard.theBoard[x-1][y+1][0] =0;
                            c = true;
                        }
                        else if(x!=ii-2||y!=jj-2) {
                            c = false;
                        }
                        continueCheckPlayerTwo(x, y);
                    }
                    if(x==ii-2&&y==jj+2) {
                        onBoard.theBoard[x+1][y-1][0] =0;
                        c = true;
                    }
                    else {
                        c = false;
                    }
                    if(x==ii+2&&y==jj+2) {
                        onBoard.theBoard[x-1][y-1][0] =0;
                        c = true;
                    }
                    else if(x!=ii-2||y!=jj+2) {
                        c = false;
                    }
                    if(x==ii-2&&y==jj-2) {
                        onBoard.theBoard[x+1][y+1][0] =0;
                        c = true;
                    }
                    if(x==ii+2&&y==jj-2) {
                        onBoard.theBoard[x-1][y+1][0] =0;
                        c = true;
                    }
                    continue1CheckPlayerTwo(x, y);
                }
            }
        } else if(!onBoard.isClicked) {
            if(onBoard.player1Turn) {
                if(onBoard.theBoard[x][y][0] == 1){
                    onBoard.theCurrentClickBoard[x][y] = 1;
                    onBoard.theBoard[x][y][0] = 1000;
                    this.fromX = x; this.fromY = y;
                    onBoard.isClicked = true;
                    a = true;
                    b = false;
                }
            } else if(!onBoard.player1Turn) {
                if(onBoard.theBoard[x][y][0] == -1){
                    onBoard.theCurrentClickBoard[x][y] = -1;
                    onBoard.theBoard[x][y][0] = 1001;
                    this.fromX = x; this.fromY = y;
                    onBoard.isClicked = true;
                    b = true;
                    a = false;
                }
            }
        }
    }
    
    private boolean checksOutToValidSquareType(int x, int y) {
        boolean isValidMove = false;
        int resultModX = x % 2;
        int resultModY = y % 2;
        boolean evenEvenOrOddOdd = false;
        if(resultModX == 0 && resultModY == 0)
            evenEvenOrOddOdd = true;
        if(resultModX != 0 && resultModY != 0)
            evenEvenOrOddOdd = true;
        if(!(evenEvenOrOddOdd)) {
            isValidMove = false;
        } else {
            isValidMove = true;
        }
        return isValidMove;
    }

    private boolean squareIsEmpty(int x, int y) {
        boolean isValidMove = true;
        if(onBoard.theBoard[x][y][0] != 0) {
            isValidMove = false;
        }
        return isValidMove;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getPoint().x/SQUARE_LENGTH;
        int y = e.getPoint().y/SQUARE_LENGTH;
        if(checksOutToValidSquareType(x, y)) {
            moveTo(fromX, fromY, x, y);
        }
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

    private void continue1CheckPlayerTwo(int x, int y) {
        try {
            if((onBoard.theBoard[x+2][y+2][0] != 0) && (onBoard.theBoard[x-2][y+2][0] != 0)) {
                onBoard.player1Turn = true;
                onBoard.isClicked = false;
            } else if(c) {
                if(onBoard.theBoard[x+1][y+1][0] != 0 || onBoard.theBoard[x-1][y+1][0] != 0) {
                    this.fromX = x; this.fromY = y;
                    onBoard.theCurrentClickBoard[x][y] =-1;
                    b = true;
                    onBoard.player1Turn = false;
                    onBoard.isClicked = true;
                } else {
                    onBoard.player1Turn = true;
                    onBoard.isClicked = false;
                }
            } else {
                onBoard.player1Turn = true;
                onBoard.isClicked = false;
            }
        } catch(Exception e3twonotuse) {
            try {
                if(x-2 < 0 || x+2 > 7 || y+2 > 7) {
                    onBoard.player1Turn = true;
                    onBoard.isClicked = false;
                } else if(c) {
                    if(onBoard.theBoard[x+1][y+1][0] != 0 || onBoard.theBoard[x-1][y+1][0] != 0) {
                        this.fromX = x; this.fromY = y;
                        onBoard.theCurrentClickBoard[x][y] =-1;
                        b = true;
                        onBoard.player1Turn = false;
                        onBoard.isClicked = true;
                    } else {
                        onBoard.player1Turn = true;
                        onBoard.isClicked = false;
                    }
                } else {
                    onBoard.player1Turn = true;
                    onBoard.isClicked = false;
                }
            } catch (Exception e4toonotuse) {
                if(c) {
                    if(onBoard.theBoard[x+1][y+1][0] != 0 || onBoard.theBoard[x-1][y+1][0] != 0) {
                        this.fromX = x; this.fromY = y;
                        onBoard.theCurrentClickBoard[x][y] =-1;
                        b = true;
                        onBoard.player1Turn = false;
                        onBoard.isClicked = true;
                    } else {
                        onBoard.player1Turn = true;
                        onBoard.isClicked = false;
                    }
                }
            }
        }
    }

    private void continueCheckPlayerTwo(int x, int y) {
        try {
            if((onBoard.theBoard[x+2][y-2][0] != 0) && (onBoard.theBoard[x-2][y-2][0] != 0)) {
                onBoard.player1Turn = true;
                onBoard.isClicked = false;
            } else if(c) {
                if(onBoard.theBoard[x+1][y-1][0] != 0 || onBoard.theBoard[x-1][y-1][0] != 0) {
                    this.fromX = x; this.fromY = y;
                    onBoard.theCurrentClickBoard[x][y] =-1;
                    b = true;
                    onBoard.player1Turn = false;
                    onBoard.isClicked = true;
                } else {
                    onBoard.player1Turn = true;
                    onBoard.isClicked = false;
                }
            } else {
                onBoard.player1Turn = true;
                onBoard.isClicked = false;
            }
        } catch(Exception e32notuse) {
            try {
                if(x-2 < 0 || x+2 > 7 || y-2 < 0) {
                    onBoard.player1Turn = true;
                    onBoard.isClicked = false;
                } else if(c) {
                    if(onBoard.theBoard[x+1][y-1][0] != 0 || onBoard.theBoard[x-1][y-1][0] != 0) {
                        this.fromX = x; this.fromY = y;
                        onBoard.theCurrentClickBoard[x][y] =-1;
                        b = true;
                        onBoard.player1Turn = false;
                        onBoard.isClicked = true;
                    } else {
                        onBoard.player1Turn = true;
                        onBoard.isClicked = false;
                    }
                } else {
                    onBoard.player1Turn = true;
                    onBoard.isClicked = false;
                }
            } catch (Exception e4tonotuse) {
                if(c) {
                    if(onBoard.theBoard[x+1][y-1][0] != 0 || onBoard.theBoard[x-1][y-1][0] != 0) {
                        this.fromX = x; this.fromY = y;
                        onBoard.theCurrentClickBoard[x][y] =-1;
                        b = true;
                        onBoard.player1Turn = false;
                        onBoard.isClicked = true;
                    } else {
                        onBoard.player1Turn = true;
                        onBoard.isClicked = false;
                    }
                }
            }
        }
    }
}