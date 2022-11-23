package chess.graphics;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import chess.pieces.*;
import chess.pieces.Piece.Team;

/**
 * Class to represent the chess board
 */
public class Board extends JPanel 
{
    // Number of rows and columns on the board
    private static final int BOARD_ROW_NUMBER = 8;
    private static final int BOARD_COLUMN_NUMBER = 8;

    // Store squares that are highlighted
    private ArrayList<Square> currentlyHighlightedSquares;

    /**
     * Constructor that creates the board
     */
    public Board() 
    {
        super();

        this.currentlyHighlightedSquares = new ArrayList<Square>();

        // Board settings
        this.setName("Board panel");
        this.setBackground(Color.GREEN);
        this.setLayout(new GridLayout(BOARD_ROW_NUMBER, BOARD_COLUMN_NUMBER));

        // Create squares and place pieces on the board
        for (int y = 0; y < BOARD_ROW_NUMBER; y++)
        {
            // Set team side
            Team team = null;

            if (y < 2) 
                team = Team.BLACK;
            else if (y >= (BOARD_ROW_NUMBER - 2))
                team = Team.WHITE;

            for (int x = 0; x < BOARD_COLUMN_NUMBER; x++)
            {
                Point pos = new Point(x, y);

                // Pawns line
                if (y == 1 || y == (BOARD_ROW_NUMBER - 2))
                    this.add(new Square(pos, new Pawn(pos, team)));

                // Other pieces line
                else if (y == 0 || y == (BOARD_ROW_NUMBER - 1))
                {
                    // Rooks
                    if (x == 0 || x == (BOARD_COLUMN_NUMBER - 1))
                        this.add(new Square(pos, new Rook(pos, team)));
                    
                    // Knights
                    else if (x == 1 || x == (BOARD_COLUMN_NUMBER - 2))
                        this.add(new Square(pos, new Knight(pos, team)));
                    
                    // Bishops
                    else if (x == 2 || x == (BOARD_COLUMN_NUMBER - 3))
                        this.add(new Square(pos, new Bishop(pos, team)));
                    
                    // Queens
                    else if (x == 3)
                        this.add(new Square(pos, new Queen(pos, team)));
                    
                    // Kings
                    else if (x == 4)
                        this.add(new Square(pos, new King(pos, team)));
                }

                // No pieces line
                else
                    this.add(new Square(pos));
            }
        }
    }

    /**
     * Getter for the number of rows in the board
     *
     * @return Number of rows in the board
     */
    public static int getBoardRowNumber()
    {
        return BOARD_ROW_NUMBER;
    }

    /**
     * Getter for the number of columns in the board
     *
     * @return Number of columns in the board
     */
    public static int getBoardColumnNumber()
    {
        return BOARD_COLUMN_NUMBER;
    }

    /**
     * Getter to know if there are already highlighted squares
     *
     * @return Check if there are already highlighted squares 
     */
    public boolean isCurrentlyHighlightedSquaresEmpty()
    {
        return this.currentlyHighlightedSquares.isEmpty();
    }

    /**
     * Display possible moves for the piece on the board
     *
     * @param p Piece to show possible moves
     */
    public void displayPossibleMoves(Piece p)
    {
        // Retrieve possible moves and change their squares background color
        ArrayList<Point> moves = p.getPossibleMoves(this);
    
        // Change current square background color to see the source of the move possibilities
        Square sourceSquare = (Square) this.getComponent((int) (p.getPosition().getY() * BOARD_COLUMN_NUMBER + p.getPosition().getX()));
        sourceSquare.setBackground(Square.getSourceMoveColor());
        this.currentlyHighlightedSquares.add(sourceSquare);

        // Change background color for the squares which are possible moves
        for (Point move : moves) {
            Square moveSquare = (Square) this.getComponent((int) (move.getY() * BOARD_COLUMN_NUMBER + move.getX()));
            moveSquare.setBackground(Square.getPossibleMoveColor());

            this.currentlyHighlightedSquares.add(moveSquare);
        }
    }

    /**
     * Reset the highlighted squares to their basic color
     */
    public void resetHighlightedSquares()
    {
        // Reset colors
        for (Square square : this.currentlyHighlightedSquares)
            square.resetBackgroundColor();

        // Reset array
        this.currentlyHighlightedSquares.removeAll(this.currentlyHighlightedSquares);
    }

    /**
     * Retrieve the source square for the possible moves currently displayed
     *
     * @return Source square of the current possible moves
     */
    public Square getSourceMoveSquare()
    {
        return this.currentlyHighlightedSquares.get(0);
    }
}