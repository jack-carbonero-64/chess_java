package chess.pieces;

import java.awt.*;
import java.util.ArrayList;

import chess.graphics.Board;

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
        ArrayList<Point> positions = new ArrayList<Point>();

        // Possible directions for this piece
        Point[] directions = {new Point(1, 1), new Point(-1, -1), new Point(-1, 1), new Point(1, -1)};

        // Number of rows and columns in the board
        int boardRowNumber = Board.getBoardRowNumber();
        int boardColumnNumber = Board.getBoardColumnNumber();

        // Current position to try in the board
        int x, y;

        // Search for possible moves
        for (Point direction : directions) {
            x = (int) (this.position.getX() + direction.getX());
            y = (int) (this.position.getY() + direction.getY());

            // TODO : Check if there are already pieces
            while (x >= 0 && x < boardColumnNumber && y >= 0 && y < boardRowNumber)
            {
                positions.add(new Point(x, y));

                x += direction.getX();
                y += direction.getY();
            }
        }

        return positions;
    }
}