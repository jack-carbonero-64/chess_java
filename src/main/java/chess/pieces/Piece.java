package chess.pieces;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Class to represent a chess piece
 */
abstract public class Piece
{
    // Enumeration for the types of pieces
    public static enum Type
    {
        KING,
        QUEEN,
        PAWN,
        BISHOP,
        KNIGHT,
        ROOK
    };

    // Enumeration for the teams
    public static enum Team
    {
        WHITE,
        BLACK
    };

    protected Type pieceType;
    protected Team team;

    // Piece position on the board
    protected Point position;

    // Piece image to display
    protected Image image;

    /**
     * Constructor for a chess piece
     *
     * @param  type      Type of the piece
     * @param  pos       Position of the piece on the board
     * @param  imagePath Path of the image that represent the piece
     * @param  team      Team of the piece
     * 
     * @exception IOException Can't load given image
     */
    public Piece(Type type, Point pos, String imagePath, Team team)
    {
        this.pieceType = type;
        this.position = pos;
        this.team = team;

        try
        {
            this.image = (Image) ImageIO.read(new File(imagePath));
        }
        catch (IOException e)
        {
            System.out.println("Erreur - Lecture de l'image - " + imagePath);
            System.exit(0);
        }
    }

    /**
     * Move the piece to another position
     *
     * @param p New position
     */
    public void moveTo(Point p)
    {
        // TODO : Square object as parameter instead of Point one ? 
    }

    /**
     * Retrieve possible moves for this piece depending of its position
     *
     * @return List of points where the piece can move to
     */
    abstract public ArrayList<Point> getPossibleMoves();
    // TODO : Square object as parameter instead of Point one ? 

    /**
     * Getter for the piece image
     *
     * @return Piece image
     */
    public Image getImage()
    {
        return this.image;
    }

    /**
     * Getter for the piece position
     *
     * @return Piece position
     */
    public Point getPosition()
    {
        return this.position;
    }

    /**
     * Setter for the piece position
     *
     * @param p New piece position
     */
    public void setPosition(Point p)
    {
        this.position = p;
    }
}