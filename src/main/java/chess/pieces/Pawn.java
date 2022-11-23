package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

import chess.graphics.*;

/**
 * Class to represent a pawn piece
 */
public class Pawn extends Piece
{
    /**
     * Constructor for a pawn piece
     *
     * @param  pos  Position of the piece on the board
     * @param  team Team of the piece
     */
    public Pawn(Point pos, Team team)
    {
        super(Type.PAWN,
              pos,
              "src/main/resources/images/pieces/64x64/pawn_"  + (team == Team.WHITE ? "white" : "black") +  ".png",
              team);
    }

    @Override
    public ArrayList<Point> getPossibleMoves(Board b)
    {
        // TODO

        return null;
    }
}