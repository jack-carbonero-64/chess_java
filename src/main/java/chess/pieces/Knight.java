package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

import chess.graphics.*;

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
    public ArrayList<Point> getPossibleMoves(Board b)
    {
        ArrayList<Point> positions = new ArrayList<Point>();

        // Possible directions for this piece
        Point[] directions = {new Point(1, 2), new Point(2, 1), new Point(2, -1), new Point(1, -2),
                              new Point(-1, -2), new Point(-2, -1), new Point(-2, 1), new Point(-1, 2)};

        // Number of rows and columns in the board
        int boardRowNumber = Board.getBoardRowNumber();
        int boardColumnNumber = Board.getBoardColumnNumber();

        // Current position to try in the board
        int x, y;

        // Search for possible moves
        for (Point direction : directions) {
            x = (int) (this.position.getX() + direction.getX());
            y = (int) (this.position.getY() + direction.getY());

            if (x >= 0 && x < boardColumnNumber && y >= 0 && y < boardRowNumber)
            { 
                Square s = (Square) b.getComponent(y * boardColumnNumber + x);

                if (s.getPiece() == null || s.getPiece().team != this.team)
                    positions.add(new Point(x, y));
            }
        }

        return positions;
    }
}