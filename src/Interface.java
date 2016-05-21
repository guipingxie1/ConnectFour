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
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Interface {

  private JFrame frame;
  private static Board board;
  private JPanel panels[];
  
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
    frame.setBounds(100, 100, 450, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFrame.setDefaultLookAndFeelDecorated(true);
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{70, 70, 70, 70, 70, 70, 70, 0};
    gridBagLayout.rowHeights = new int[]{35, 0, 90, 90, 90, 90, 90, 90, 0};
    gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    frame.getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(0, 0, 5, 5);
    gbc.gridx = 0;
    gbc.gridy = 0;
    JButton button_1 = new JButton("Column 1");
    button_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        /*
        if (player) {
          board.placePiece(0, 'X');
        }
        else {
          
        }
        */
        
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
    
    /* Add extra spacing between the buttons and the board */
    Component horizontalStrut = Box.createHorizontalStrut(20);
    GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
    gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
    gbc_horizontalStrut.gridx = 0;
    gbc_horizontalStrut.gridy = 1;
    frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
    
    /* Have a new JPanel for every square */
    for (int i = 0; i < 6; ++i) {
      for (int j = 0; j < 7; ++j) {
        panels[7 * i + j] = new JPanel();
        panels[7 * i + j].setBackground(new Color(245, 255, 250));
        panels[7 * i + j].setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        
      }
    }
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(245, 255, 250));
    panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.insets = new Insets(0, 0, 5, 5);
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 0;
    gbc_panel.gridy = 2;
    frame.getContentPane().add(panel, gbc_panel);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(245, 255, 250));
    panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_1 = new GridBagConstraints();
    gbc_panel_1.insets = new Insets(0, 0, 5, 5);
    gbc_panel_1.fill = GridBagConstraints.BOTH;
    gbc_panel_1.gridx = 1;
    gbc_panel_1.gridy = 2;
    frame.getContentPane().add(panel_1, gbc_panel_1);
    
    JPanel panel_2 = new JPanel();
    panel_2.setBackground(new Color(245, 255, 250));
    panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_2 = new GridBagConstraints();
    gbc_panel_2.insets = new Insets(0, 0, 5, 5);
    gbc_panel_2.fill = GridBagConstraints.BOTH;
    gbc_panel_2.gridx = 2;
    gbc_panel_2.gridy = 2;
    frame.getContentPane().add(panel_2, gbc_panel_2);
    
    JPanel panel_3 = new JPanel();
    panel_3.setBackground(new Color(245, 255, 250));
    panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_3 = new GridBagConstraints();
    gbc_panel_3.insets = new Insets(0, 0, 5, 5);
    gbc_panel_3.fill = GridBagConstraints.BOTH;
    gbc_panel_3.gridx = 3;
    gbc_panel_3.gridy = 2;
    frame.getContentPane().add(panel_3, gbc_panel_3);
    
    JPanel panel_4 = new JPanel();
    panel_4.setBackground(new Color(245, 255, 250));
    panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_4 = new GridBagConstraints();
    gbc_panel_4.insets = new Insets(0, 0, 5, 5);
    gbc_panel_4.fill = GridBagConstraints.BOTH;
    gbc_panel_4.gridx = 4;
    gbc_panel_4.gridy = 2;
    frame.getContentPane().add(panel_4, gbc_panel_4);
    
    JPanel panel_5 = new JPanel();
    panel_5.setBackground(new Color(245, 255, 250));
    panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_5 = new GridBagConstraints();
    gbc_panel_5.insets = new Insets(0, 0, 5, 5);
    gbc_panel_5.fill = GridBagConstraints.BOTH;
    gbc_panel_5.gridx = 5;
    gbc_panel_5.gridy = 2;
    frame.getContentPane().add(panel_5, gbc_panel_5);
    
    JPanel panel_6 = new JPanel();
    panel_6.setBackground(new Color(245, 255, 250));
    panel_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_6 = new GridBagConstraints();
    gbc_panel_6.insets = new Insets(0, 0, 5, 0);
    gbc_panel_6.fill = GridBagConstraints.BOTH;
    gbc_panel_6.gridx = 6;
    gbc_panel_6.gridy = 2;
    frame.getContentPane().add(panel_6, gbc_panel_6);
    
    JPanel panel_7 = new JPanel();
    panel_7.setBackground(new Color(245, 255, 250));
    panel_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_7 = new GridBagConstraints();
    gbc_panel_7.insets = new Insets(0, 0, 5, 5);
    gbc_panel_7.fill = GridBagConstraints.BOTH;
    gbc_panel_7.gridx = 0;
    gbc_panel_7.gridy = 3;
    frame.getContentPane().add(panel_7, gbc_panel_7);
    
    JPanel panel_8 = new JPanel();
    panel_8.setBackground(new Color(245, 255, 250));
    panel_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_8 = new GridBagConstraints();
    gbc_panel_8.insets = new Insets(0, 0, 5, 5);
    gbc_panel_8.fill = GridBagConstraints.BOTH;
    gbc_panel_8.gridx = 1;
    gbc_panel_8.gridy = 3;
    frame.getContentPane().add(panel_8, gbc_panel_8);
    
    JPanel panel_9 = new JPanel();
    panel_9.setBackground(new Color(245, 255, 250));
    panel_9.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_9 = new GridBagConstraints();
    gbc_panel_9.insets = new Insets(0, 0, 5, 5);
    gbc_panel_9.fill = GridBagConstraints.BOTH;
    gbc_panel_9.gridx = 2;
    gbc_panel_9.gridy = 3;
    frame.getContentPane().add(panel_9, gbc_panel_9);
    
    JPanel panel_10 = new JPanel();
    panel_10.setBackground(new Color(245, 255, 250));
    panel_10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_10 = new GridBagConstraints();
    gbc_panel_10.insets = new Insets(0, 0, 5, 5);
    gbc_panel_10.fill = GridBagConstraints.BOTH;
    gbc_panel_10.gridx = 3;
    gbc_panel_10.gridy = 3;
    frame.getContentPane().add(panel_10, gbc_panel_10);
    
    JPanel panel_11 = new JPanel();
    panel_11.setBackground(new Color(245, 255, 250));
    panel_11.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_11 = new GridBagConstraints();
    gbc_panel_11.insets = new Insets(0, 0, 5, 5);
    gbc_panel_11.fill = GridBagConstraints.BOTH;
    gbc_panel_11.gridx = 4;
    gbc_panel_11.gridy = 3;
    frame.getContentPane().add(panel_11, gbc_panel_11);
    
    JPanel panel_12 = new JPanel();
    panel_12.setBackground(new Color(245, 255, 250));
    panel_12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_12 = new GridBagConstraints();
    gbc_panel_12.insets = new Insets(0, 0, 5, 5);
    gbc_panel_12.fill = GridBagConstraints.BOTH;
    gbc_panel_12.gridx = 5;
    gbc_panel_12.gridy = 3;
    frame.getContentPane().add(panel_12, gbc_panel_12);
    
    JPanel panel_13 = new JPanel();
    panel_13.setBackground(new Color(245, 255, 250));
    panel_13.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_13 = new GridBagConstraints();
    gbc_panel_13.insets = new Insets(0, 0, 5, 0);
    gbc_panel_13.fill = GridBagConstraints.BOTH;
    gbc_panel_13.gridx = 6;
    gbc_panel_13.gridy = 3;
    frame.getContentPane().add(panel_13, gbc_panel_13);
    
    JPanel panel_14 = new JPanel();
    panel_14.setBackground(new Color(245, 255, 250));
    panel_14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_14 = new GridBagConstraints();
    gbc_panel_14.insets = new Insets(0, 0, 5, 5);
    gbc_panel_14.fill = GridBagConstraints.BOTH;
    gbc_panel_14.gridx = 0;
    gbc_panel_14.gridy = 4;
    frame.getContentPane().add(panel_14, gbc_panel_14);
    
    JPanel panel_15 = new JPanel();
    panel_15.setBackground(new Color(245, 255, 250));
    panel_15.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_15 = new GridBagConstraints();
    gbc_panel_15.insets = new Insets(0, 0, 5, 5);
    gbc_panel_15.fill = GridBagConstraints.BOTH;
    gbc_panel_15.gridx = 1;
    gbc_panel_15.gridy = 4;
    frame.getContentPane().add(panel_15, gbc_panel_15);
    
    JPanel panel_16 = new JPanel();
    panel_16.setBackground(new Color(245, 255, 250));
    panel_16.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_16 = new GridBagConstraints();
    gbc_panel_16.insets = new Insets(0, 0, 5, 5);
    gbc_panel_16.fill = GridBagConstraints.BOTH;
    gbc_panel_16.gridx = 2;
    gbc_panel_16.gridy = 4;
    frame.getContentPane().add(panel_16, gbc_panel_16);
    
    JPanel panel_17 = new JPanel();
    panel_17.setBackground(new Color(245, 255, 250));
    panel_17.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_17 = new GridBagConstraints();
    gbc_panel_17.insets = new Insets(0, 0, 5, 5);
    gbc_panel_17.fill = GridBagConstraints.BOTH;
    gbc_panel_17.gridx = 3;
    gbc_panel_17.gridy = 4;
    frame.getContentPane().add(panel_17, gbc_panel_17);
    
    JPanel panel_18 = new JPanel();
    panel_18.setBackground(new Color(245, 255, 250));
    panel_18.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_18 = new GridBagConstraints();
    gbc_panel_18.insets = new Insets(0, 0, 5, 5);
    gbc_panel_18.fill = GridBagConstraints.BOTH;
    gbc_panel_18.gridx = 4;
    gbc_panel_18.gridy = 4;
    frame.getContentPane().add(panel_18, gbc_panel_18);
    
    JPanel panel_19 = new JPanel();
    panel_19.setBackground(new Color(245, 255, 250));
    panel_19.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_19 = new GridBagConstraints();
    gbc_panel_19.insets = new Insets(0, 0, 5, 5);
    gbc_panel_19.fill = GridBagConstraints.BOTH;
    gbc_panel_19.gridx = 5;
    gbc_panel_19.gridy = 4;
    frame.getContentPane().add(panel_19, gbc_panel_19);
    
    JPanel panel_20 = new JPanel();
    panel_20.setBackground(new Color(245, 255, 250));
    panel_20.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_20 = new GridBagConstraints();
    gbc_panel_20.insets = new Insets(0, 0, 5, 0);
    gbc_panel_20.fill = GridBagConstraints.BOTH;
    gbc_panel_20.gridx = 6;
    gbc_panel_20.gridy = 4;
    frame.getContentPane().add(panel_20, gbc_panel_20);
    
    JPanel panel_21 = new JPanel();
    panel_21.setBackground(new Color(245, 255, 250));
    panel_21.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_21 = new GridBagConstraints();
    gbc_panel_21.insets = new Insets(0, 0, 5, 5);
    gbc_panel_21.fill = GridBagConstraints.BOTH;
    gbc_panel_21.gridx = 0;
    gbc_panel_21.gridy = 5;
    frame.getContentPane().add(panel_21, gbc_panel_21);
    
    JPanel panel_22 = new JPanel();
    panel_22.setBackground(new Color(245, 255, 250));
    panel_22.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_22 = new GridBagConstraints();
    gbc_panel_22.insets = new Insets(0, 0, 5, 5);
    gbc_panel_22.fill = GridBagConstraints.BOTH;
    gbc_panel_22.gridx = 1;
    gbc_panel_22.gridy = 5;
    frame.getContentPane().add(panel_22, gbc_panel_22);
    
    JPanel panel_23 = new JPanel();
    panel_23.setBackground(new Color(245, 255, 250));
    panel_23.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_23 = new GridBagConstraints();
    gbc_panel_23.insets = new Insets(0, 0, 5, 5);
    gbc_panel_23.fill = GridBagConstraints.BOTH;
    gbc_panel_23.gridx = 2;
    gbc_panel_23.gridy = 5;
    frame.getContentPane().add(panel_23, gbc_panel_23);
    
    JPanel panel_24 = new JPanel();
    panel_24.setBackground(new Color(245, 255, 250));
    panel_24.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_24 = new GridBagConstraints();
    gbc_panel_24.insets = new Insets(0, 0, 5, 5);
    gbc_panel_24.fill = GridBagConstraints.BOTH;
    gbc_panel_24.gridx = 3;
    gbc_panel_24.gridy = 5;
    frame.getContentPane().add(panel_24, gbc_panel_24);
    
    JPanel panel_25 = new JPanel();
    panel_25.setBackground(new Color(245, 255, 250));
    panel_25.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_25 = new GridBagConstraints();
    gbc_panel_25.insets = new Insets(0, 0, 5, 5);
    gbc_panel_25.fill = GridBagConstraints.BOTH;
    gbc_panel_25.gridx = 4;
    gbc_panel_25.gridy = 5;
    frame.getContentPane().add(panel_25, gbc_panel_25);
    
    JPanel panel_26 = new JPanel();
    panel_26.setBackground(new Color(245, 255, 250));
    panel_26.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_26 = new GridBagConstraints();
    gbc_panel_26.insets = new Insets(0, 0, 5, 5);
    gbc_panel_26.fill = GridBagConstraints.BOTH;
    gbc_panel_26.gridx = 5;
    gbc_panel_26.gridy = 5;
    frame.getContentPane().add(panel_26, gbc_panel_26);
    
    JPanel panel_27 = new JPanel();
    panel_27.setBackground(new Color(245, 255, 250));
    panel_27.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_27 = new GridBagConstraints();
    gbc_panel_27.insets = new Insets(0, 0, 5, 0);
    gbc_panel_27.fill = GridBagConstraints.BOTH;
    gbc_panel_27.gridx = 6;
    gbc_panel_27.gridy = 5;
    frame.getContentPane().add(panel_27, gbc_panel_27);
    
    JPanel panel_28 = new JPanel();
    panel_28.setBackground(new Color(245, 255, 250));
    panel_28.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_28 = new GridBagConstraints();
    gbc_panel_28.insets = new Insets(0, 0, 5, 5);
    gbc_panel_28.fill = GridBagConstraints.BOTH;
    gbc_panel_28.gridx = 0;
    gbc_panel_28.gridy = 6;
    frame.getContentPane().add(panel_28, gbc_panel_28);
    
    JPanel panel_29 = new JPanel();
    panel_29.setBackground(new Color(245, 255, 250));
    panel_29.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_29 = new GridBagConstraints();
    gbc_panel_29.insets = new Insets(0, 0, 5, 5);
    gbc_panel_29.fill = GridBagConstraints.BOTH;
    gbc_panel_29.gridx = 1;
    gbc_panel_29.gridy = 6;
    frame.getContentPane().add(panel_29, gbc_panel_29);
    
    JPanel panel_30 = new JPanel();
    panel_30.setBackground(new Color(245, 255, 250));
    panel_30.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_30 = new GridBagConstraints();
    gbc_panel_30.insets = new Insets(0, 0, 5, 5);
    gbc_panel_30.fill = GridBagConstraints.BOTH;
    gbc_panel_30.gridx = 2;
    gbc_panel_30.gridy = 6;
    frame.getContentPane().add(panel_30, gbc_panel_30);
    
    JPanel panel_31 = new JPanel();
    panel_31.setBackground(new Color(245, 255, 250));
    panel_31.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_31 = new GridBagConstraints();
    gbc_panel_31.insets = new Insets(0, 0, 5, 5);
    gbc_panel_31.fill = GridBagConstraints.BOTH;
    gbc_panel_31.gridx = 3;
    gbc_panel_31.gridy = 6;
    frame.getContentPane().add(panel_31, gbc_panel_31);
    
    JPanel panel_32 = new JPanel();
    panel_32.setBackground(new Color(245, 255, 250));
    panel_32.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_32 = new GridBagConstraints();
    gbc_panel_32.insets = new Insets(0, 0, 5, 5);
    gbc_panel_32.fill = GridBagConstraints.BOTH;
    gbc_panel_32.gridx = 4;
    gbc_panel_32.gridy = 6;
    frame.getContentPane().add(panel_32, gbc_panel_32);
    
    JPanel panel_33 = new JPanel();
    panel_33.setBackground(new Color(245, 255, 250));
    panel_33.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_33 = new GridBagConstraints();
    gbc_panel_33.insets = new Insets(0, 0, 5, 5);
    gbc_panel_33.fill = GridBagConstraints.BOTH;
    gbc_panel_33.gridx = 5;
    gbc_panel_33.gridy = 6;
    frame.getContentPane().add(panel_33, gbc_panel_33);
    
    JPanel panel_34 = new JPanel();
    panel_34.setBackground(new Color(245, 255, 250));
    panel_34.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_34 = new GridBagConstraints();
    gbc_panel_34.insets = new Insets(0, 0, 5, 0);
    gbc_panel_34.fill = GridBagConstraints.BOTH;
    gbc_panel_34.gridx = 6;
    gbc_panel_34.gridy = 6;
    frame.getContentPane().add(panel_34, gbc_panel_34);
    
    JPanel panel_35 = new JPanel();
    panel_35.setBackground(new Color(245, 255, 250));
    panel_35.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_35 = new GridBagConstraints();
    gbc_panel_35.insets = new Insets(0, 0, 5, 5);
    gbc_panel_35.fill = GridBagConstraints.BOTH;
    gbc_panel_35.gridx = 0;
    gbc_panel_35.gridy = 7;
    frame.getContentPane().add(panel_35, gbc_panel_35);
    
    JPanel panel_36 = new JPanel();
    panel_36.setBackground(new Color(245, 255, 250));
    panel_36.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_36 = new GridBagConstraints();
    gbc_panel_36.insets = new Insets(0, 0, 5, 5);
    gbc_panel_36.fill = GridBagConstraints.BOTH;
    gbc_panel_36.gridx = 1;
    gbc_panel_36.gridy = 7;
    frame.getContentPane().add(panel_36, gbc_panel_36);
    
    JPanel panel_37 = new JPanel();
    panel_37.setBackground(new Color(245, 255, 250));
    panel_37.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_37 = new GridBagConstraints();
    gbc_panel_37.insets = new Insets(0, 0, 5, 5);
    gbc_panel_37.fill = GridBagConstraints.BOTH;
    gbc_panel_37.gridx = 2;
    gbc_panel_37.gridy = 7;
    frame.getContentPane().add(panel_37, gbc_panel_37);
    
    JPanel panel_38 = new JPanel();
    panel_38.setBackground(new Color(245, 255, 250));
    panel_38.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_38 = new GridBagConstraints();
    gbc_panel_38.insets = new Insets(0, 0, 5, 5);
    gbc_panel_38.fill = GridBagConstraints.BOTH;
    gbc_panel_38.gridx = 3;
    gbc_panel_38.gridy = 7;
    frame.getContentPane().add(panel_38, gbc_panel_38);
    
    JPanel panel_39 = new JPanel();
    panel_39.setBackground(new Color(245, 255, 250));
    panel_39.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_39 = new GridBagConstraints();
    gbc_panel_39.insets = new Insets(0, 0, 5, 5);
    gbc_panel_39.fill = GridBagConstraints.BOTH;
    gbc_panel_39.gridx = 4;
    gbc_panel_39.gridy = 7;
    frame.getContentPane().add(panel_39, gbc_panel_39);
    
    JPanel panel_40 = new JPanel();
    panel_40.setBackground(new Color(245, 255, 250));
    panel_40.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_40 = new GridBagConstraints();
    gbc_panel_40.insets = new Insets(0, 0, 5, 5);
    gbc_panel_40.fill = GridBagConstraints.BOTH;
    gbc_panel_40.gridx = 5;
    gbc_panel_40.gridy = 7;
    frame.getContentPane().add(panel_40, gbc_panel_40);
    
    JPanel panel_41 = new JPanel();
    panel_41.setBackground(new Color(245, 255, 250));
    panel_41.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    GridBagConstraints gbc_panel_41 = new GridBagConstraints();
    gbc_panel_41.insets = new Insets(0, 0, 5, 0);
    gbc_panel_41.fill = GridBagConstraints.BOTH;
    gbc_panel_41.gridx = 6;
    gbc_panel_41.gridy = 7;
    frame.getContentPane().add(panel_41, gbc_panel_41);
    frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{button_1, button_2, button_3, button_4, button_5, button_6, button_7, horizontalStrut, panel, panel_1, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7, panel_8, panel_9, panel_10, panel_11, panel_12, panel_13, panel_14, panel_15, panel_16, panel_17, panel_18, panel_19, panel_20, panel_21, panel_22, panel_23, panel_24, panel_25, panel_26, panel_27, panel_28, panel_29, panel_30, panel_31, panel_32, panel_33, panel_34, panel_35, panel_36, panel_37, panel_38, panel_39, panel_40, panel_41}));
    frame.pack();
    frame.setVisible(true);
  }
}
