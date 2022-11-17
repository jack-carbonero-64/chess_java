package chess.graphics;

import java.awt.*;
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

    /**
     * Constructor that creates the board
     */
    public Board() 
    {
        super();

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
}