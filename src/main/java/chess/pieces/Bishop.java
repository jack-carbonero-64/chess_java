package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to represent a bishop piece
 */
public class Bishop extends Piece
{
    /**
     * Constructor for a bishop piece
     *
     * @param  pos  Position of the piece on the board
     * @param  team Team of the piece
     */
    public Bishop(Point pos, Team team)
    {
        super(Type.BISHOP,
              pos,
              "src/main/resources/images/pieces/64x64/bishop_"  + (team == Team.WHITE ? "white" : "black") +  ".png",
              team);
    }

    @Override
    public ArrayList<Point> getPossibleMoves()
    {
        // TODO

        return null;
    }
}