package gameplay;

import java.awt.*;

public class Board {
    static final int MAX_COL = 8;
    static final int MAX_ROW = 8;
    public static final int SQUARE_SIZE = 100; //size of each square
    public static final int HALF_SIZE = SQUARE_SIZE / 2;

    public void draw(Graphics2D g) {
        int c = 0;
        for(int row = 0; row < MAX_ROW; row++) {
            for(int col = 0; col < MAX_COL; col++) {

                if(c == 0){
                    g.setColor(Color.BLACK); //we will change the color later
                    c = 1;
                }
                else{
                    g.setColor(Color.WHITE);
                    c = 0;
                }
                g.fillRect(col*SQUARE_SIZE, row*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE); //drawing the board
            }

            if(c == 0){
                c = 1;
            }
            else c = 0;
        }
    }
}
