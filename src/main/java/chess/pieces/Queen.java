package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to represent a queen piece
 */
public class Queen extends Piece
{
    /**
     * Constructor for a queen piece
     *
     * @param  pos  Position of the piece on the board
     * @param  team Team of the piece
     */
    public Queen(Point pos, Team team)
    {
        super(Type.QUEEN,
              pos,
              "src/main/resources/images/pieces/64x64/queen_"  + (team == Team.WHITE ? "white" : "black") +  ".png",
              team);
    }

    @Override
    public ArrayList<Point> getPossibleMoves()
    {
        // TODO

        return null;
    }
}