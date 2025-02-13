package piece;

import gameplay.GamePanel;

import java.awt.*;

public class Pawn extends Piece {

    //int color OR int player
    public Pawn(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.firstPlayer){
            image = getImage("/piece/black_ICE_FIRE/Pawn");
        }
        else if(color == GamePanel.secondPlayer){
            image = getImage("/piece/white_ICE_FIRE/Pawn");
        }


    }
}
