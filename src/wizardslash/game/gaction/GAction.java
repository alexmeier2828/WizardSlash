/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardslash.game.gaction;

/**
 * 
 * @author Alex Meier
 */
public abstract class GAction {
    private final String source;
    
    /**
     * constructor
     * @param source descriptive string of where this action came from 
     */
    public GAction(String source) {
        this.source = source;
    }
    
    
    public String getSource() {
        return this.source;
    }
    
    /**
     * Contains whatever needs to be done to satisfy the action
     */
    public abstract void complete();
}
