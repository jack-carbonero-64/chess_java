package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

import chess.graphics.*;

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
    public ArrayList<Point> getPossibleMoves(Board b)
    {
        ArrayList<Point> positions = new ArrayList<Point>();

        // Possible directions for this piece
        Point[] directions = {new Point(1, 0), new Point(0, 1), new Point(-1, 0), new Point(0, -1),
                              new Point(1, 1), new Point(-1, -1), new Point(-1, 1), new Point(1, -1)};

        // Number of rows and columns in the board
        int boardRowNumber = Board.getBoardRowNumber();
        int boardColumnNumber = Board.getBoardColumnNumber();

        // Current position to try in the board
        int x, y;

        // Search for possible moves
        for (Point direction : directions) {
            x = (int) (this.position.getX() + direction.getX());
            y = (int) (this.position.getY() + direction.getY());

            while (x >= 0 && x < boardColumnNumber && y >= 0 && y < boardRowNumber)
            {
                Square s = (Square) b.getComponent(y * boardColumnNumber + x);

                if (s.getPiece() != null && s.getPiece().team == this.team)
                    break;

                positions.add(new Point(x, y));

                x += direction.getX();
                y += direction.getY();
            }
        }

        return positions;
    }
}