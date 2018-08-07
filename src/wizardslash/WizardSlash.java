/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardslash;

//imports
import javax.swing.SwingUtilities;
import wizardslash.view.Playfield;
/**
 *
 * @author Alex Meier
 */
public class WizardSlash {
    private final Playfield playfield;
    private static final int STEP_TIME = 100;
    public WizardSlash() {
        this.playfield = new Playfield(500, 500, 50, 50);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //main game loop
        ViewThread EDT = new ViewThread();
        long last_step_time = 0;
        while(true) {
            
            //only do this if STEP_TIME milliseconds has passed since the last turn
            if(System.currentTimeMillis() - last_step_time > STEP_TIME) {
                SwingUtilities.invokeLater(EDT);
                last_step_time = System.currentTimeMillis();
            }
        }

    }
    
    
    private static class ViewThread extends Thread {
        private final WizardSlash slash;
       
        public ViewThread() {
            //constructor\
            this.slash = new WizardSlash();
        }
        
        @Override
        public void run() {
            this.slash.playfield.repaint();
        }
    }
    
}
