/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reileao.Objects;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author igord
 */
public class Floor {
    private int x,y;
    private Image bg;
    
    public Floor(int x, int y) throws IOException{
        BufferedImage Sprite = ImageIO.read(new File("Data/Texture/Stage1.png"));
        this.x=x;
        this.y=y;
        bg = Sprite.getSubimage(0, 2025, 2094, 69);
    }
    public boolean isOver(Point p){
        if( p.x<this.x ||
            p.x>this.x+this.bg.getWidth(null) ||
            p.y<this.y ||
            p.y>this.y+this.bg.getHeight(null)) return false;
        return true;
    }
    public Image getImage(){
        return bg;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
