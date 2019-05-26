/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reileao;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author igord
 */
public class Player {
    private BufferedImage[] idle,moving,turning,jumping,falling,life,dying,hurt;
    private int frame,cframe,x,y,dx,initialjump,speed=15,lifes=3,inv=0,dif;
    private String state="Idle",jstate="Idle",isOver;
    private boolean front=true,gameOver=false;

    
    public Player() throws IOException{
        BufferedImage Sprite = ImageIO.read(new File("Data/Texture/Player.png"));
        idle    = new BufferedImage[10];
        moving  = new BufferedImage[13];
        turning = new BufferedImage[5];
        jumping = new BufferedImage[4];
        falling = new BufferedImage[5];
        dying   = new BufferedImage[23];
        hurt    = new BufferedImage[6];
        life    = new BufferedImage[1];
        //Sprites
        for(int i=0; i<10; i++) idle    [i]=Sprite.getSubimage(i*80, 0, 80, 76);
        for(int i=0; i<13; i++) moving  [i]=Sprite.getSubimage(i*128, 76, 128, 70);
        for(int i=0; i<5 ; i++) turning [i]=Sprite.getSubimage(i*74, 146, 74, 76);
        for(int i=0; i<4 ; i++) jumping [i]=Sprite.getSubimage(i*100, 222, 100, 136);
        for(int i=0; i<5 ; i++) falling [i]=Sprite.getSubimage(i*100, 358, 100, 136);
        for(int i=0; i<12; i++) dying   [i]=Sprite.getSubimage(i*152, 496, 152, 100);
        for(int i=0; i<11; i++) dying[12+i]=Sprite.getSubimage(i*152, 596, 152, 100);
        for(int i=0; i<6 ; i++) hurt    [i]=Sprite.getSubimage(i*106, 696, 106, 106);
                                life    [0]=Sprite.getSubimage( 1619, 434, 46, 62);
        //Initial Position
        this.x = 275;
        this.y = 2400;
    }
    public Image getImage(){
        //Death Bug
        if(gameOver){
            if(front) return dying[22]; else {
                //Flip Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-dying[22].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(dying[22], null);
                return a;
            }
        }
        //Bug remover
        if(this.frame<0)this.frame=0;
        //Moving without Jumping
        if(state.equals("Moving")&&this.jstate.equals("Idle")){
            if(frame>moving.length-1)frame=0;
            if(front) return moving[frame]; else {
                //Flip Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-moving[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(moving[frame], null);
                return a;
            }
        }
        //Dying
        else if(this.state.equals("Dying")){
            if(frame>dying.length-1){
                if(!gameOver){
                    gameOver=true;
                    JOptionPane.showMessageDialog(null, "Game Over");
                    System.exit(0);
                }
            }
            if(front) return dying[frame]; else {
                //Flip Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-dying[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(dying[frame], null);
                return a;
            }
        }
        //Hurt
        else if(this.state.equals("Hurt")){
            if(frame>hurt.length-1){
                frame=hurt.length-1;
                this.state="Idle";
                this.dx=0;
            }
            if(front) return hurt[frame]; else {
                //Flip Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-hurt[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(hurt[frame], null);
                return a;
            }
        }
        //Jumping
        else if(this.jstate.equals("Jumping")){
            if(frame>jumping.length-1){
                frame=jumping.length-1;
                if(dx!=0)this.state="Moving"; else this.state="Idle";
            }
            if(front) return jumping[frame]; else {
                //Flip Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-jumping[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(jumping[frame], null);
                return a;
            }
        }
        //Falling
        else if(this.jstate.equals("Falling")){
            if(frame>falling.length-1){
                frame=falling.length-1;
            }
            if(front) return falling[frame]; else {
                //Invert Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-falling[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(falling[frame], null);
                return a;
            }
        }
        //Turning without Jumping
        else if(state.equals("Turning")&&this.jstate.equals("Idle")){
            if(frame>=turning.length-1){
                this.state="Idle";
            }
            if(!front) return turning[frame]; else {
                //Flip Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-turning[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(turning[frame], null);
                return a;
            }
        }
        //Idle
        else {
            if(frame>idle.length-1)frame=0;
            if(front) return idle[frame]; else {
                //Flip Image
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-idle[frame].getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage a = op.filter(idle[frame], null);
                return a;
            }
        }
    }
    public void move(String c){
        if(!this.state.equals("Dying") && !this.state.equals("Hurt")){
            if(!this.state.equals("Turning"))
                if(dx>0&&!c.equals("Right")){
                    this.x += dx*speed;
                }
                else if(dx<0&&!c.equals("Left")){
                    this.x += dx*speed;
                }

            if((this.jstate.equals("Jumping"))&&(this.initialjump-165<this.getY())){
                this.y-=speed;
            } else this.jstate="Idle";

            if((!this.jstate.equals("Jumping"))&&(this.isOver.equals(""))){
                this.jstate="Falling";
                this.y+=speed;
            }
            if(this.dif>30 && this.state.equals("Moving") && !this.jstate.equals("Falling"))this.y-=dif/5;
            else if(this.dif>15 && this.state.equals("Moving") && !this.jstate.equals("Falling"))this.y-=1;
        }
    }
    public void setDif(int dif){
        this.dif=dif;
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
    public String getLifes(){
        String s;
        s=""+this.lifes;
        return s;
    }
    public int getInv(){
        return this.inv;
    }
    public Image getLifeImage(){
        return life[0];
    }
    public void setIsOver(String is){
        this.isOver=is;
    }
    public void nextFrame(){
        if(!this.state.equals("Moving")){
            this.cframe++;
            if(this.cframe>3){
                this.cframe=0;
                this.frame++;
            }
        } else {
            this.frame++;
        }
        inv--;
    }
    public void damage() throws Exception{
        if(this.inv<=0 && !this.state.equals("Dying")){
            Sounds.damageSound();
            if(this.lifes<=0 && !this.state.equals("Dying")){
                this.state="Dying";
                Sounds.setBgsound(false);
                Sounds.bgSound();
                Sounds.deathSong();
            } else {
                this.state="Hurt";
                this.lifes--;
                this.inv=45;
                this.frame=-1;
            }
        }
    }
    public void setDx(int dx) {
        if(!this.state.equals("Dying") && !this.state.equals("Hurt")){
            if(dx==0)this.state="Idle";
            if(this.jstate.equals("Jumping")){
                this.dx = dx;
                if(dx>0) this.front=true;
                if(dx<0) this.front=false;
            }
            else if(!this.state.equals("Turning")){
                String a=this.state;

                if(dx!=0)this.state="Moving"; else this.state="Idle";
                if(dx>0 && this.front==false){
                    this.state="Turning";
                    this.front=true;
                }
                if(dx<0 && this.front==true){
                    this.state="Turning";
                    this.front=false;
                }
                stateChange(a);
                this.dx = dx;
            } else this.dx=0;
        }
    }
    public void jump() {
        if((!this.jstate.equals("Jumping"))&&(!this.isOver.equals(""))&&!this.state.equals("Dying") && !this.state.equals("Hurt")) {
            this.initialjump=this.y;
            this.jstate="Jumping";
            frame=-1;
        }
    }    
    public void stateChange(String s){
        if(!this.state.equals(s))frame=-1;
    }
}
