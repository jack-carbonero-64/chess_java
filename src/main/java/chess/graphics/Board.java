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
    private final int BOARD_ROW_NUMBER = 8;
    private final int BOARD_COLUMN_NUMBER = 8;

    /**
     * Constructor that creates the board
     */
    public Board() 
    {
        super();

        // Board settings
        this.setName("Board panel");
        this.setBackground(Color.GREEN);
        this.setLayout(new GridLayout(this.BOARD_ROW_NUMBER, this.BOARD_COLUMN_NUMBER));

        // Create squares and place pieces on the board
        for (int y = 0; y < this.BOARD_ROW_NUMBER; y++)
        {
            // Set team side
            Team team = null;

            if (y < 2) 
                team = Team.BLACK;
            else if (y >= (this.BOARD_ROW_NUMBER - 2))
                team = Team.WHITE;

            for (int x = 0; x < this.BOARD_COLUMN_NUMBER; x++)
            {
                Point pos = new Point(x, y);

                // Pawns line
                if (y == 1 || y == (this.BOARD_ROW_NUMBER - 2))
                    this.add(new Square(pos, new Pawn(pos, team)));

                // Other pieces line
                else if (y == 0 || y == (this.BOARD_ROW_NUMBER - 1))
                {
                    // Rooks
                    if (x == 0 || x == (this.BOARD_COLUMN_NUMBER - 1))
                        this.add(new Square(pos, new Rook(pos, team)));
                    
                    // Knights
                    else if (x == 1 || x == (this.BOARD_COLUMN_NUMBER - 2))
                        this.add(new Square(pos, new Knight(pos, team)));
                    
                    // Bishops
                    else if (x == 2 || x == (this.BOARD_COLUMN_NUMBER - 3))
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
}