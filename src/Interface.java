import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Interface {
  
  /* Constants */
  private static final int BOARD_HEIGHT = 6;
  private static final int BOARD_WIDTH = 7;
  private static final int BORDER_WIDTH = 3;
  private static final int GRID_WIDTH = 1;
  private static final int SQUARE_SIZE = 100;
  private static final int BUTTON_SIZE = 50;
  
  /* Interface Objects */
  private JFrame frame;
  private JPanel window;
  private JPanel buttons;
  private JPanel board;
  
  private JButton[] buttonPanels;
  private JPanel[][] boardPanels;

  
  /**
   * Launch the application
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Interface window = new Interface();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application
   */
  public Interface() {
    frame = new JFrame("Connect Four");
    
    /* Size includes the border so we have to account for it */
    frame.setSize(BOARD_WIDTH * SQUARE_SIZE + 2 * BORDER_WIDTH, 
        BOARD_HEIGHT * SQUARE_SIZE + 2 * BORDER_WIDTH + BUTTON_SIZE + 16);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //frame.getContentPane().setLayout(new BorderLayout());
    
    initWindow();
    initButtons();
    initBoard();
    
    window.add(buttons);
    window.add(board);
    
    frame.setContentPane(window);
    frame.pack();
    frame.setVisible(true);
  }
  
  /**
   * Creates the main window
   */
  private void initWindow() {
    window = new JPanel();
    window.setPreferredSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE + 2 * BORDER_WIDTH, 
        BOARD_HEIGHT * SQUARE_SIZE + 2 * BORDER_WIDTH + BUTTON_SIZE + 16));
    window.setMinimumSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE + 2 * BORDER_WIDTH, 
        BOARD_HEIGHT * SQUARE_SIZE + 2 * BORDER_WIDTH + BUTTON_SIZE + 16));
    window.setBackground(Color.WHITE);
    window.setBorder(BorderFactory.createLineBorder(Color.BLACK, BORDER_WIDTH));
  }
  
  
  /**
   * Initialize the buttons at the top for placing pieces
   */
  private void initButtons() {
    buttons = new JPanel();
    buttons.setBorder(null);
    buttons.setPreferredSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE, BUTTON_SIZE));
    buttons.setMinimumSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE, BUTTON_SIZE));
    buttons.setBackground(new Color(240, 248, 255));
    
    buttons.setLayout(new GridLayout(1, BOARD_WIDTH));
    buttonPanels = new JButton[BOARD_WIDTH];
    
    for (int i = 0; i < BOARD_WIDTH; ++i) {
      buttonPanels[i] = new JButton();
      buttonPanels[i].setLayout(new FlowLayout(0, 0, 0));
      //buttonPanels[i].setBorder(BorderFactory.createEmptyBorder());
      buttonPanels[i].setPreferredSize(new Dimension(SQUARE_SIZE, BUTTON_SIZE));
      buttonPanels[i].setMinimumSize(new Dimension(SQUARE_SIZE, BUTTON_SIZE));
      //buttonPanels[i].setBorder(null);
      buttonPanels[i].setOpaque(true);
      buttons.add(buttonPanels[i]);
    }
  }

  
  /**
   * Initialize the board
   */
  private void initBoard() {
    board = new JPanel();
    //board.setBorder(null);
    board.setPreferredSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE, 
        BOARD_HEIGHT * SQUARE_SIZE));
    board.setMinimumSize(new Dimension(BOARD_WIDTH * SQUARE_SIZE, 
        BOARD_HEIGHT * SQUARE_SIZE));
    board.setBackground(Color.WHITE);
    
    board.setLayout(new GridLayout(BOARD_HEIGHT, BOARD_WIDTH));
    boardPanels = new JPanel[BOARD_WIDTH][BOARD_HEIGHT];
    
    for (int i = 0; i < BOARD_WIDTH; ++i) {
      for (int j = 0; j < BOARD_HEIGHT; ++j) {
        boardPanels[i][j] = new JPanel();
        boardPanels[i][j].setLayout(new FlowLayout(0, 0, 0));
        boardPanels[i][j].setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
        boardPanels[i][j].setMinimumSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
        boardPanels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, GRID_WIDTH));
        boardPanels[i][j].setOpaque(true);
        boardPanels[i][j].setBackground(Color.WHITE);
        board.add(boardPanels[i][j]);
      }
    }
  }
}
