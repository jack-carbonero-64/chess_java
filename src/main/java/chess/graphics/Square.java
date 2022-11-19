package chess.graphics;

import javax.swing.*;
import java.awt.*;

import chess.pieces.*;
import chess.events.SquareEvents;

/**
 * Class to represent a square on the chess board
 */
public class Square extends JPanel
{
    // Colors to use
    private static final Color LIGHT_COLOR = Color.WHITE;
    private static final Color DARK_COLOR = new Color(174, 207, 130);
    private static final Color SOURCE_MOVE_COLOR = new Color(200, 15, 15);
    private static final Color POSSIBLE_MOVE_COLOR = new Color(255, 0, 0);

    // Chess piece currently on the square
    private Piece piece;    
    
    // Background base color
    private Color baseColor;

    /**
     * Constructor that sets the background color
     * 
     * @param pos Position of the square on the board
     */
    public Square(Point pos)
    {
        super();

        this.setName("Square_" + ((int) pos.getX()) + "_" + ((int) pos.getY()));

        this.piece = null;

        // Set background color
        if ((pos.getY() % 2) == (pos.getX() % 2))
            this.baseColor = LIGHT_COLOR;
        else
            this.baseColor = DARK_COLOR;

        this.setBackground(this.baseColor);
    }

    /**
     * Constructor that sets background color and current piece
     *
     * @param  pos   Position of the square on the board
     * @param  piece Current piece on the square
     */
    public Square(Point pos, Piece piece)
    {
        super();

        this.setName("Square_" + ((int) pos.getX()) + "_" + ((int) pos.getY()));

        this.piece = piece;

        // Set background color
        if ((pos.getY() % 2) == (pos.getX() % 2))
            this.baseColor = LIGHT_COLOR;
        else
            this.baseColor = DARK_COLOR;

        this.setBackground(this.baseColor);

        // Detect mouse events on this square
        this.addMouseListener(new SquareEvents());
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Draw the current piece if there is one on the square
        if (this.piece != null)
            g.drawImage(this.piece.getImage(), 0, 0, this);    
    }

    /**
     * Getter for the piece on this square
     *
     * @return Piece on this square
     */
    public Piece getPiece()
    {
        return this.piece;
    }

    /**
     * Reset this square background color
     */
    public void resetBackgroundColor()
    {
        this.setBackground(this.baseColor);
    }

    /**
     * Getter for the light color
     *
     * @return Light color
     */
    public static Color getLightColor()
    {
        return LIGHT_COLOR;
    }

    /**
     * Getter for the dark color
     *
     * @return Dark color
     */
    public static Color getDarkColor()
    {
        return DARK_COLOR;
    }

    /**
     * Getter for the source move color
     *
     * @return Source move color
     */
    public static Color getSourceMoveColor()
    {
        return SOURCE_MOVE_COLOR;
    }

    /**
     * Getter for the possible move color
     *
     * @return Possible move color
     */
    public static Color getPossibleMoveColor()
    {
        return POSSIBLE_MOVE_COLOR;
    }
}