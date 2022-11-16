package chess.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Class to represent a square on the chess board
 */
public class Square extends JPanel
{
    /**
     * Constructor that sets the background color depending on X and Y
     * 
     * @param x X axis position of the square on the board
     * @param y Y axis position of the square on the board
     */
    public Square(int x, int y)
    {
        super();

        // Set background color
        if ((y % 2) == (x % 2))
           this.setBackground(Color.WHITE);
       else
           this.setBackground(new Color(174, 207, 130));
    }
}