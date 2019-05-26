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
public class Plataform {
    private int x,y;
    private BufferedImage bg;
    
    public Plataform(int x, int y, int id) throws IOException{
        BufferedImage Sprite = ImageIO.read(new File("Data/Texture/Stage1.png"));
        this.x=x;
        this.y=y;
        switch (id) {
            case  1: bg = Sprite.getSubimage(0,0,188,38); break;
            case  2: bg = Sprite.getSubimage(188,0,220,38); break;
            case  3: bg = Sprite.getSubimage(136,885,109,81); break;
            case  4: bg = Sprite.getSubimage(245,885,115,70); break;
            case  5: bg = Sprite.getSubimage(81,1454,193,39); break;
            case  6: bg = Sprite.getSubimage(1004,0,263,38); break;
            case  7: bg = Sprite.getSubimage(1267,0,220,38); break;
            case  8: bg = Sprite.getSubimage(0,38,807,38); break;
            case  9: bg = Sprite.getSubimage(1487,0,163,38); break;
            case 10: bg = Sprite.getSubimage(50,627,104,32); break;
            case 11: bg = Sprite.getSubimage(807,38,354,38); break;
            case 12: bg = Sprite.getSubimage(1161,38,206,38); break;
            case 13: bg = Sprite.getSubimage(1367,38,174,38); break;
            case 14: bg = Sprite.getSubimage(1541,38,207,38); break;
            case 15: bg = Sprite.getSubimage(1748,38,113,38); break;
            case 16: bg = Sprite.getSubimage(0,76,272,38); break;
            case 17: bg = Sprite.getSubimage(272,38,213,38); break;
            case 18: bg = Sprite.getSubimage(1171,324,78,54); break;
            case 19: bg = Sprite.getSubimage(81,1087,60,105); break;
            case 20: bg = Sprite.getSubimage(141,1087,60,98); break;
            case 21: bg = Sprite.getSubimage(771,76,191 ,38); break;
            case 22: bg = Sprite.getSubimage(962,76,202 ,38); break;
            case 23: bg = Sprite.getSubimage(1164,76 ,138 ,38); break;
            case 24: bg = Sprite.getSubimage(1302,76 ,203 ,38); break;
            case 25: bg = Sprite.getSubimage(1505,76 ,275 ,38); break;
            case 26: bg = Sprite.getSubimage(1780,76 ,218 ,38); break;
            case 27: bg = Sprite.getSubimage(1999,38 ,64 ,38); break;
            case 28: bg = Sprite.getSubimage(0,114 ,112 ,38); break;
            case 29: bg = Sprite.getSubimage(112,114 ,90 ,38); break;
            case 30: bg = Sprite.getSubimage(202,114 ,93 ,38); break;
            case 31: bg = Sprite.getSubimage(295,114 ,143 ,38); break;
            case 32: bg = Sprite.getSubimage(438,114 ,192 ,38); break;
            case 33: bg = Sprite.getSubimage(630,114 ,161 ,38); break;
            case 34: bg = Sprite.getSubimage(791,114 ,124 ,38); break;
            case 35: bg = Sprite.getSubimage(574,266 ,117 ,50); break;
            case 36: bg = Sprite.getSubimage(691,266 ,97 ,54); break;
            case 37: bg = Sprite.getSubimage(1456,114 ,223 ,38); break;
            case 38: bg = Sprite.getSubimage(1679,114 ,129 ,38); break;
            case 39: bg = Sprite.getSubimage(1808,114 ,145 ,38); break;
            case 40: bg = Sprite.getSubimage(0,152 ,222 ,38); break;
            case 41: bg = Sprite.getSubimage(222,152 ,209 ,38); break;
            case 42: bg = Sprite.getSubimage(431,152 ,213 ,38); break;
            case 43: bg = Sprite.getSubimage(644,152 ,211 ,38); break;
            case 44: bg = Sprite.getSubimage(855,152 ,217 ,38); break;
            case 45: bg = Sprite.getSubimage(1072,152 ,217 ,38); break;
            case 46: bg = Sprite.getSubimage(1289,152 ,207 ,38); break;
            case 47: bg = Sprite.getSubimage(1496,152 ,213 ,38); break;
            case 48: bg = Sprite.getSubimage(1953,114 ,97 ,38); break;
            case 49: bg = Sprite.getSubimage(1709,152 ,256 ,38); break;
            case 50: bg = Sprite.getSubimage(1965,152 ,129 ,38); break;
            case 51: bg = Sprite.getSubimage(0,190 ,318 ,38); break;
            case 52: bg = Sprite.getSubimage(318,190 ,218 ,38); break;
            case 53: bg = Sprite.getSubimage(536,190 ,112 ,38); break;
            case 54: bg = Sprite.getSubimage(1867,266,132,47); break;
            case 55: bg = Sprite.getSubimage(913,190 ,225 ,38); break;
            case 56: bg = Sprite.getSubimage(1138,190 ,190 ,38); break;
            case 57: bg = Sprite.getSubimage(1328,190 ,415 ,38); break;
            case 58: bg = Sprite.getSubimage(1743,190 ,159 ,38); break;
            case 59: bg = Sprite.getSubimage(0,228 ,288 ,38); break;
            case 60: bg = Sprite.getSubimage(1902,190 ,189 ,38); break;
            case 61: bg = Sprite.getSubimage(288,228 ,401 ,38); break;
            case 62: bg = Sprite.getSubimage(689,228 ,188 ,38); break;
            case 63: bg = Sprite.getSubimage(877,228 ,99 ,38); break;
            case 64: bg = Sprite.getSubimage(976,228 ,129 ,38); break;
            case 65: bg = Sprite.getSubimage(1249,324,49,38); break;
            case 66: bg = Sprite.getSubimage(1105,228 ,141 ,38); break;
            case 67: bg = Sprite.getSubimage(1246,228 ,173 ,38); break;
            case 68: bg = Sprite.getSubimage(1419,228 ,175 ,38); break;
            case 69: bg = Sprite.getSubimage(1594,228 ,96 ,38); break;
            case 70: bg = Sprite.getSubimage(1690,228 ,224 ,38); break;
            case 71: bg = Sprite.getSubimage(0,266 ,237 ,38); break;
            case 72: bg = Sprite.getSubimage(0,304 ,45 ,20); break;
            case 73: bg = Sprite.getSubimage(45,304 ,56 ,20); break;
            case 74: bg = Sprite.getSubimage(101,304 ,62 ,20); break;
            case 75: bg = Sprite.getSubimage(163,304 ,60 ,20); break;
            case 76: bg = Sprite.getSubimage(304,304 ,81 ,20); break;
            case 77: bg = Sprite.getSubimage(81,972,32,50); break;
            case 78: bg = Sprite.getSubimage(113,972,32,50); break;
            case 79: bg = Sprite.getSubimage(145,972,32,50); break;
            case 80: bg = Sprite.getSubimage(177,972,32,50); break;
            case 81: bg = Sprite.getSubimage(209,972,32,73); break;
            case 82: bg = Sprite.getSubimage(305,972,32,61); break;
            case 83: bg = Sprite.getSubimage(273,972,32,54); break;
            case 84: bg = Sprite.getSubimage(81,1022,45,65); break;
            case 85: bg = Sprite.getSubimage(337,972,101,70); break;
            case 86: bg = Sprite.getSubimage(128,711,79,52); break;
            case 87: bg = Sprite.getSubimage(50,659,77,45); break;
            case 88: bg = Sprite.getSubimage(127,659,120,34); break;
            case 89: bg = Sprite.getSubimage(449,669,118,37); break;
            case 90: bg = Sprite.getSubimage(154,626,87,33); break;
            case 91: bg = Sprite.getSubimage(81,1604,102,45); break;
            case 92: bg = Sprite.getSubimage(247,659,78,28); break;
            case 93: bg = Sprite.getSubimage(143,763,71,27); break;
            case 94: bg = Sprite.getSubimage(214,757,79,34); break;
            case 95: bg = Sprite.getSubimage(449,706,120,43); break;
            case 96: bg = Sprite.getSubimage(207,711,118,46); break;
            case 97: bg = Sprite.getSubimage(788,266,95,47); break;
            case 98: bg = Sprite.getSubimage(883,266,95,50); break;
            case 99: bg = Sprite.getSubimage(978,266,117,40); break;
            case 100: bg = Sprite.getSubimage(1095,266,85,43); break;
            case 101: bg = Sprite.getSubimage(1180,266,90,44); break;
            case 102: bg = Sprite.getSubimage(1270,266,136,46); break;
            case 103: bg = Sprite.getSubimage(1406,266,91,34); break;
            case 104: bg = Sprite.getSubimage(1497,266,90,29); break;
            case 105: bg = Sprite.getSubimage(1779,266,88,35); break;
            case 106: bg = Sprite.getSubimage(656,682,93,38); break;

            default: bg = new BufferedImage(200, 38, 1); break;
        }
        //BlueImage();
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
    private void BlueImage(){
        bg = new BufferedImage(bg.getWidth(),bg.getHeight(), 1);
        Graphics2D g = bg.createGraphics();
            g.setColor(Color.blue);
            g.fillRect(0, 0, bg.getWidth(null), bg.getHeight(null));
            g.dispose();
        
    }
}
