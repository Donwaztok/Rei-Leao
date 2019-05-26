/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reileao.Mobs;

import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author igord
 */
public class Mob {
    private BufferedImage[] moving,turning;
    private int frame,cframe,sx,x,y,mov=150;
    private String state="Moving";
    private boolean front=true;

    
    public Mob(int x, int y, int t) throws IOException{
        moving  = new BufferedImage[8];
        turning = new BufferedImage[3];
        BufferedImage Sprite;
        
        switch(t){
            case 1: Sprite = ImageIO.read(new File("Data/Texture/chameleon.png")); break;
            case 2: Sprite = ImageIO.read(new File("Data/Texture/bettle.png")); break;
            default: Sprite = ImageIO.read(new File("Data/Texture/chameleon.png")); break;
        }
        for(int i=0; i<8; i++) moving   [i]=Sprite.getSubimage(i*70, 0, 70, 40);
        for(int i=0; i<3; i++) turning  [i]=Sprite.getSubimage(i*53, 40, 53, 46);
                
        this.x = x;
        this.y = y;
        this.sx= x-1;
    }
    public Image getImage(){
        if(this.frame<0)this.frame=0;
        
        if(state.equals("Moving")){
            if(frame>moving.length-1)frame=0;
            if(front) return moving[frame]; else {
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-moving[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(moving[frame], null);
                return a;
            }
        }
        if(state.equals("Turning")){
            if(frame>=turning.length-1){
                this.state="Moving";
                if(this.front) this.x+=1; else this.x-=1;
            }
            if(!front){
                return turning[frame];
            } else {
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-turning[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(turning[frame], null);
                return a;
            }
        }
        else return moving[0];
    }
    public void move(){
        String a = this.state;
        if(this.x<sx+mov-1 && this.x>this.sx) this.state="Moving";
        else if(this.x==sx+mov && !this.state.equals("Turning")){
            this.state="Turning";
            this.front=false;
        }
        else if(this.x==this.sx){
            this.state="Turning";
            this.front=true;
        }
        stateChange(a);
        
        if(!this.state.equals("Turning")){
            if(this.front) this.x+=1; else this.x-=1;
        }
        this.nextFrame();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x=x;
    }
    public void setY(int y) {
        this.y=y;
    }
    public String isOver(Point p){
        if(p.x>this.x && p.x<this.x+moving[0].getWidth()){
            if(p.y<=this.y && p.y>=this.y-(moving[0].getHeight()/2)) return "Down";
            else if(p.y<=this.y-(moving[0].getHeight()/2) && p.y>=this.y-moving[0].getHeight()) return "Up";
        }
        return "No";
    }
    public void nextFrame(){
        this.cframe++;
        if(this.cframe>2){
            this.cframe=0;
            this.frame++;
        }
    } 
    public void stateChange(String s){
        if(!this.state.equals(s))frame=-1;
    }
}

