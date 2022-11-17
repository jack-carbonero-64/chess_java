package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to represent a knight piece
 */
public class Knight extends Piece
{
    /**
     * Constructor for a knight piece
     *
     * @param  pos  Position of the piece on the board
     * @param  team Team of the piece
     */
    public Knight(Point pos, Team team)
    {
        super(Type.KNIGHT,
              pos,
              "src/main/resources/images/pieces/64x64/knight_"  + (team == Team.WHITE ? "white" : "black") +  ".png",
              team);
    }

    @Override
    public ArrayList<Point> getPossibleMoves()
    {
        // TODO

        return null;
    }
}