package chess.events;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import java.util.ArrayList;

import chess.graphics.*;
import chess.pieces.*;

/**
 * Class to manage events that could occurs on a square
 */
public class SquareEvents implements MouseInputListener
{
    /**
     * Constructor for a square events manager
     */
    public SquareEvents()
    {
        super();
    }

	@Override
	public void mouseClicked(MouseEvent e) {
        Square s = (Square) e.getSource();
        Board b = (Board) s.getParent();
        Piece p = s.getPiece();

        if (p != null)
        {
            // Change current square background color to see the source of the move possibilities
            s.setBackground(new Color(200,15,15));

            // Retrieve possible moves and change their squares background color
            ArrayList<Point> moves = p.getPossibleMoves();
        
            for (Point move : moves) {
                Square moveSquare = (Square) b.getComponent((int) (move.getY() * Board.getBoardColumnNumber() + move.getX()));
                moveSquare.setBackground(new Color(255,0,0));
            }
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}
}