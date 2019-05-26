/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reileao;

import java.awt.BorderLayout;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author igord
 */
public class GameFrame extends JFrame{
    private PaintPanel panel;
    
    public GameFrame() throws Exception{
        this.setTitle("Lion King");
        
        this.setSize(1240,720);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());
        this.panel = new PaintPanel();
        this.getContentPane().add(panel,BorderLayout.CENTER);
        
        this.setVisible(true);
    }
}
