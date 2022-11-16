package chess.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Class to represent the main window
 */
public class Window extends JFrame
{
    /**
     * Constructor that fills the window's content and displays it
     */
    public Window()
    {
        // Window settings
        super("Chess game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600, 600));
        this.setResizable(false);

        // Panel to store all window content
        JPanel contentPanel = (JPanel) this.getContentPane();

        // Use a BoxLayout to place components along a given axis and to set their size on the other one 
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        contentPanel.setName("Content panel");
        contentPanel.setBackground(Color.RED);

        // Add chess board
        contentPanel.add(new Board());

        // Show the window
        this.setVisible(true);
    }
}