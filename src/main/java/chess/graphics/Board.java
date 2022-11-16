package chess.graphics;

import java.awt.*;
import javax.swing.*;

/**
 * Class to represent the chess board
 */
public class Board extends JPanel 
{
    // Number of rows and columns on the board
    private final int BOARD_ROW_NUMBER = 8;
    private final int BOARD_COLUMN_NUMBER = 8;

    /**
     * Constructor that creates the board's squares
     */
    public Board() 
    {
        super();

        // Board settings
        this.setName("Board panel");
        this.setBackground(Color.GREEN);
        this.setLayout(new GridLayout(this.BOARD_ROW_NUMBER, this.BOARD_COLUMN_NUMBER));

        // Create squares
        for (int y = 0; y < this.BOARD_ROW_NUMBER; y++)
            for (int x = 0; x < this.BOARD_COLUMN_NUMBER; x++)
                this.add(new Square(x, y));
    }
}