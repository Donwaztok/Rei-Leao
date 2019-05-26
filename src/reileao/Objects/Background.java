/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reileao.Objects;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author igord
 */
public class Background {
    private Image image;
    private int x,y;
    
    public Background(){
        image = new ImageIcon("Data/Texture/bg.png").getImage();
    }
    public Image getImage(){
        return image;
    }
    public void move(){
        this.y+=1;
        if(this.y>750)this.y=-800;
    }
    
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
}
