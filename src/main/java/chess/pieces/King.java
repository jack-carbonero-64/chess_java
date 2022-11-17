package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to represent a king piece
 */
public class King extends Piece
{
    /**
     * Constructor for a king piece
     *
     * @param  pos  Position of the piece on the board
     * @param  team Team of the piece
     */
    public King(Point pos, Team team)
    {
        super(Type.KING,
              pos,
              "src/main/resources/images/pieces/64x64/king_"  + (team == Team.WHITE ? "white" : "black") +  ".png",
              team);
    }

    @Override
    public ArrayList<Point> getPossibleMoves()
    {
        // TODO
        
        return null;
    }
}