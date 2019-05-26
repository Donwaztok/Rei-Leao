/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reileao.Objects;

import java.awt.Color;
import java.awt.Graphics2D;
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
public class Wall {
    private int x,y;
    private Image bg;
    
    public Wall(int x, int y, int id) throws IOException{
        BufferedImage Sprite = ImageIO.read(new File("Data/Texture/Stage1.png"));
        this.x=x;
        this.y=y;
        switch (id) {
            case  1: bg = Sprite.getSubimage(302, 531, 71, 102); break;
            case  2: bg = Sprite.getSubimage(50, 324,48, 160); break;
            case  3: bg = Sprite.getSubimage(101, 324,49, 269); break;
            case  4: bg = Sprite.getSubimage(0, 473,50, 499); break;
            case  5: bg = Sprite.getSubimage(150,324,60,91); break;
            case  6: bg = Sprite.getSubimage(210,324,92,258); break;
            case  7: bg = Sprite.getSubimage(302,324,74,207); break;
            case  8: bg = Sprite.getSubimage(345,1042,93,315); break;//
            case  9: bg = Sprite.getSubimage(449,324,214,211); break;
            case  10: bg = Sprite.getSubimage(663,324,129,81); break;
            case  11: bg = Sprite.getSubimage(792,324,138,173); break;
            case  12: bg = Sprite.getSubimage(930,324,118,173); break;
            case  13: bg = Sprite.getSubimage(1048,324,50,385); break;
            case  14: bg = Sprite.getSubimage(438,972,95,824); break;
            case  15: bg = Sprite.getSubimage(663,405,124,73); break;
            case  16: bg = Sprite.getSubimage(663,478,119,89); break;
            case  17: bg = Sprite.getSubimage(449,535,123,134); break;
            case  18: bg = Sprite.getSubimage(572,535,84,88); break;
            case  19: bg = Sprite.getSubimage(782,497,100,103); break;
            case  20: bg = Sprite.getSubimage(782,673,115,73); break;
            case  21: bg = Sprite.getSubimage(656,567,79,115); break;
            case  22: bg = Sprite.getSubimage(1098,324,73,123); break;
            case  23: bg = Sprite.getSubimage(81,1234,86,87); break;
            case  24: bg = Sprite.getSubimage(50,763,93,122); break;
            case  25: bg = Sprite.getSubimage(143,807,183,78); break;
            case  26: bg = Sprite.getSubimage(533,972,648,657); break;

            default: bg = new BufferedImage(100,2560, 1); break;
        }
        //redImage();
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
    private void redImage(){
        bg = new BufferedImage(bg.getWidth(null),bg.getHeight(null), 1);
        Graphics2D g = (Graphics2D) bg.getGraphics();
            g.setColor(Color.red);
            g.fillRect(0, 0, bg.getWidth(null), bg.getHeight(null));
            g.dispose();
        
    }
}
