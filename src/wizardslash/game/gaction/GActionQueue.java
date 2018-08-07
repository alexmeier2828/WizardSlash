/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardslash.game.gaction;
import java.util.PriorityQueue;

/**
 *Manages all action requests from Game.
 * @author Alex Meier
 */
public class GActionQueue{
    PriorityQueue<GAction> queue;
    
    /**
     * Constructor
     */
    public GActionQueue() {
        queue = new PriorityQueue<GAction>();
    }
}
