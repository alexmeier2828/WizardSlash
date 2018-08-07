/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardslash.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *The following class manages the game window, and sprite grid.
 * @author Alex Meier
 * 
 */
public class Playfield{
    private final int size_x;
    private final int size_y;
    
    //Frame
    private JFrame frame;
    
    private SquareGrid squareGrid;
   
    
    
    /**
    @param sizeX width of window
    @param sizeY height of window
    @param gridSizeX width of grid
    @param gridSizeY height of grid
    */
    public Playfield(int sizeX, int sizeY, int gridSizeX, int gridSizeY) {
        //grid setup
        this.size_x = sizeX;
        this.size_y = sizeY;
        this.squareGrid = new SquareGrid(gridSizeX, gridSizeY, sizeX/gridSizeX);
        
        //Frame initiallization
        this.frame = new JFrame("WizardSlash");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.frame.setLayout();
        
        
        
        //initialize new MyPanel object and add it to frame
        MyPanel myPanel = new MyPanel(this.size_x, this.size_y);
        this.frame.getContentPane().add(myPanel);  
        this.frame.pack();
        this.frame.setVisible(true);
        //this.frame.setResizable(false);
        
        this.frame.validate();
        this.frame.repaint();
    }
    
    public void repaint() {
        this.frame.repaint();
    }
    
    //main draw method that gets called from the MyPanel class.
    public void draw(Graphics2D g2d) {
        this.squareGrid.draw(g2d);
    }
        
    
    /*
    This class just overides the paint function, so I don't need to extend JPanel 
    in the main Playfield class.
    */
    class MyPanel extends JPanel {
        public MyPanel(int width, int height) {
            super();
            super.setSize(width, height);
            super.setPreferredSize(new Dimension(width, height));
            super.setMinimumSize(new Dimension(width, height));
        }
    
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        
            Graphics2D g2d = (Graphics2D) g;
            Playfield.this.draw(g2d);
            
        }
    }
}