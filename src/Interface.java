import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;

public class Interface {

  private JFrame frame;
  private static Board board;
  
  /* True for player one: 'X', alternates to 'Y' */
  private boolean player;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          board = new Board();
          Interface window = new Interface();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Interface() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setForeground(Color.BLACK);
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFrame.setDefaultLookAndFeelDecorated(true);
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{70, 70, 70, 70, 70, 70, 70, 0};
    gridBagLayout.rowHeights = new int[]{35, 0, 70, 70, 70, 70, 70, 70, 0};
    gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    frame.getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(0, 0, 5, 5);
    gbc.gridx = 0;
    gbc.gridy = 0;
    JButton button_1 = new JButton("Column 1");
    button_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
      }
    });
    frame.getContentPane().add(button_1, gbc);
    GridBagConstraints gbc_1 = new GridBagConstraints();
    gbc_1.fill = GridBagConstraints.BOTH;
    gbc_1.insets = new Insets(0, 0, 5, 5);
    gbc_1.gridx = 1;
    gbc_1.gridy = 0;
    JButton button_2 = new JButton("Column 2");
    frame.getContentPane().add(button_2, gbc_1);
    GridBagConstraints gbc_2 = new GridBagConstraints();
    gbc_2.fill = GridBagConstraints.BOTH;
    gbc_2.insets = new Insets(0, 0, 5, 5);
    gbc_2.gridx = 2;
    gbc_2.gridy = 0;
    JButton button_3 = new JButton("Column 3");
    frame.getContentPane().add(button_3, gbc_2);
    GridBagConstraints gbc_3 = new GridBagConstraints();
    gbc_3.fill = GridBagConstraints.BOTH;
    gbc_3.insets = new Insets(0, 0, 5, 5);
    gbc_3.gridx = 3;
    gbc_3.gridy = 0;
    JButton button_4 = new JButton("Column 4");
    frame.getContentPane().add(button_4, gbc_3);
    GridBagConstraints gbc_4 = new GridBagConstraints();
    gbc_4.fill = GridBagConstraints.BOTH;
    gbc_4.insets = new Insets(0, 0, 5, 5);
    gbc_4.gridx = 4;
    gbc_4.gridy = 0;
    JButton button_5 = new JButton("Column 5");
    frame.getContentPane().add(button_5, gbc_4);
    GridBagConstraints gbc_5 = new GridBagConstraints();
    gbc_5.fill = GridBagConstraints.BOTH;
    gbc_5.insets = new Insets(0, 0, 5, 5);
    gbc_5.gridx = 5;
    gbc_5.gridy = 0;
    JButton button_6 = new JButton("Column 6");
    frame.getContentPane().add(button_6, gbc_5);
    GridBagConstraints gbc_6 = new GridBagConstraints();
    gbc_6.insets = new Insets(0, 0, 5, 0);
    gbc_6.fill = GridBagConstraints.BOTH;
    gbc_6.gridx = 6;
    gbc_6.gridy = 0;
    JButton button_7 = new JButton("Column 7");
    frame.getContentPane().add(button_7, gbc_6);
    
    Component horizontalStrut = Box.createHorizontalStrut(20);
    GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
    gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
    gbc_horizontalStrut.gridx = 0;
    gbc_horizontalStrut.gridy = 1;
    frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
    frame.pack();
    frame.setVisible(true);
  }
}
