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
import javax.swing.JOptionPane;
import reileao.Sounds;

/**
 *
 * @author igord
 */
public class Hyena {
    private BufferedImage[] moving,turning,dying;
    private int frame,cframe,sx,x,y,mov=300;
    private String state="Moving";
    private boolean front=true,gameOver=false,alive=true;

    
    public Hyena() throws IOException{
        moving  = new BufferedImage[11];
        turning = new BufferedImage[11];
        dying   = new BufferedImage[10];
        BufferedImage Sprite;
        
        Sprite = ImageIO.read(new File("Data/Texture/hyena.png"));
       
        for(int i=0; i<11; i++) moving [i]=Sprite.getSubimage(i*142, 0, 142, 108);
        for(int i=0; i<11; i++) turning[i]=Sprite.getSubimage(i*142, 108, 142, 102);
        for(int i=0; i<10; i++) dying  [i]=Sprite.getSubimage(i*172, 210, 172, 126);
                
        this.x = 2900;
        this.y = 665;
        this.sx= 2600;
    }
    public Image getImage(){
        if(gameOver){
            if(front) return dying[9]; else {
                //Invert Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-dying[9].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(dying[9], null);
                return a;
            }
        }
        //Bugs
        if(this.frame<0)this.frame=0;
        //Moving
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
        //Dying
        if(this.state.equals("Dying")){
            if(frame>dying.length-1){
                if(!gameOver){
                    gameOver=true;
                    JOptionPane.showMessageDialog(null, "You won!!");
                    System.exit(0);
                }
            }
            if(front) return dying[frame]; else {
                //Invert Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-dying[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(dying[frame], null);
                return a;
            }
        }
        //Turning
        if(state.equals("Turning")){
            if(frame>=turning.length-1){
                this.state="Moving";
                if(this.front) this.x+=1; else this.x-=1;
            }
            if(!front) return turning[frame]; else {
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
        if(!this.state.equals("Dying")){
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
    public boolean isAlive(){
        return this.alive;
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
        if(this.cframe>2 && !this.state.equals("Dying")){
            this.cframe=0;
            this.frame++;
        }
        if(this.cframe>10 && this.state.equals("Dying")){
            this.cframe=0;
            this.frame++;
        }
    }
    public void die() throws Exception{
        this.alive=false;
        Sounds.hyenaSound();
        this.state="Dying";
        this.frame=-1;
    }
    public void stateChange(String s){
        if(!this.state.equals(s))frame=-1;
    }
}
