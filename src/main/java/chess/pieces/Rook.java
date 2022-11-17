package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to represent a rook piece
 */
public class Rook extends Piece
{
    /**
     * Constructor for a rook piece
     *
     * @param  pos  Position of the piece on the board
     * @param  team Team of the piece
     */
    public Rook(Point pos, Team team)
    {
        super(Type.ROOK,
              pos,
              "src/main/resources/images/pieces/64x64/rook_"  + (team == Team.WHITE ? "white" : "black") +  ".png",
              team);
    }

    @Override
    public ArrayList<Point> getPossibleMoves()
    {
        // TODO

        return null;
    }
}