package chess.events;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

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
            // Show moves for this piece
            if (b.isCurrentlyHighlightedSquaresEmpty())
                b.displayPossibleMoves(p);

            else
            {
                // Attack piece
                if (s.getBackground() == Square.getPossibleMoveColor())
                    b.getSourceMoveSquare().movePieceTo(s);

                // Reset possible moves
                b.resetHighlightedSquares();
            }
        }
        else
        {
            // Move piece
            if (s.getBackground() == Square.getPossibleMoveColor())
                b.getSourceMoveSquare().movePieceTo(s);

            // Reset possible moves
            b.resetHighlightedSquares();
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