package gameplay;

import piece.Pawn;
import piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60; //60 frames per second for the game
    Thread gameThread; //We will be using multi-thread
    Board board = new Board();

    //pieces
    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> copyPieces = new ArrayList<>();

    //player
    public static final int firstPlayer = 0; //white starts first, this can be named "white"
    public static final int secondPlayer = 1;
    int currentColor = firstPlayer;


    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        setPieces();
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start(); //this calls "run" method below
    }

    public void setPieces(){
        //White team pawn
        for(int i = 0; i < Board.MAX_COL; i++){
            pieces.add(new Pawn(firstPlayer, i, 6));
        }

        //black team pawn
        for(int i = 0; i < Board.MAX_COL; i++){
            pieces.add(new Pawn(secondPlayer, i, 1));
        }
    }
    //TO-DO copy "copyPiece" arraylist to "piece" arraylsist
    private void copyPieces(){

    }
    @Override //
    public void run() {
        //our game loop goes here
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){ //so basically, we are repainting the game 60 times per second
                update();
                repaint(); //this will call paintcomponent method
                delta--;
            }
        }
    }
    private void update(){

    }

    //for drawing pieces and stuff
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        board.draw(g2d);

        //pieces
        for(Piece piece : pieces){
            piece.draw(g2d);
        }
    }


}
