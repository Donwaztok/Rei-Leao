/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reileao;

import reileao.Objects.Floor;
import reileao.Objects.Background;
import reileao.Objects.Wall;
import reileao.Objects.Plataform;
import reileao.Mobs.Hyena;
import reileao.Mobs.Mob;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author igord
 */
public class PaintPanel extends JPanel implements KeyListener, ActionListener{
    private Player player;
    private Image i;
    private Floor floor;
    private ArrayList<Plataform> plataforms;
    private ArrayList<Wall> walls;
    private ArrayList<Mob> mobs;
    private Wall frontwall;
    private Hyena hyena;
    private Background bg;
    private Timer timer;
    private Font lion15,lion60;
    
    public PaintPanel() throws Exception{
        this.player= new Player();
        this.i = player.getImage();
        //Floor
        this.floor = new Floor(0,2491);
        //Plataforms      
        plataforms = new ArrayList();        
        plataforms.add(new Plataform(751,2306,1));
        plataforms.add(new Plataform(1026,2248,2));
        plataforms.add(new Plataform(2149,1635,3));
        plataforms.add(new Plataform(2238,1614,4));
        plataforms.add(new Plataform(2336,2207,5));
        plataforms.add(new Plataform(1945,2147,6));
        plataforms.add(new Plataform(1776,2095,7));
        plataforms.add(new Plataform(785,2084,8));
        plataforms.add(new Plataform(669,2018,9));
        plataforms.add(new Plataform(578,1965,10));
        plataforms.add(new Plataform(769,1859,11));
        plataforms.add(new Plataform(1084,1800,12));
        plataforms.add(new Plataform(1394,1755,13));
        plataforms.add(new Plataform(1424,1440,14));
        plataforms.add(new Plataform(1247,1524,15));
        plataforms.add(new Plataform(1152,1383,16));
        plataforms.add(new Plataform(960,1337,17));
        plataforms.add(new Plataform(1760,1737,18));
        plataforms.add(new Plataform(2051,1701,19));
        plataforms.add(new Plataform(2098,1659,20));
        plataforms.add(new Plataform(2322,1547 ,21));
        plataforms.add(new Plataform(2006,1528 ,22));
        plataforms.add(new Plataform(1744,1516 ,23));
        plataforms.add(new Plataform(1423,1437 ,24));
        plataforms.add(new Plataform(1150,1381 ,25));
        plataforms.add(new Plataform(960,1333 ,26));
        plataforms.add(new Plataform(1024,1546,27));
        plataforms.add(new Plataform(816,1581,28));
        plataforms.add(new Plataform(608,1611,29));
        plataforms.add(new Plataform(707,1482,30));
        plataforms.add(new Plataform(816,1232,31));
        plataforms.add(new Plataform(1184,1156,32));
        plataforms.add(new Plataform(1440,1098,33));
        plataforms.add(new Plataform(1088,938,34));
        plataforms.add(new Plataform(1205,897,35));
        plataforms.add(new Plataform(1265,865,36));
        plataforms.add(new Plataform(1041,472,37));
        plataforms.add(new Plataform(1504,590,38));
        plataforms.add(new Plataform(1375,442,39));
        plataforms.add(new Plataform(1410,267,40));
        plataforms.add(new Plataform(1639,304,41));
        plataforms.add(new Plataform(1734,141,42));
        plataforms.add(new Plataform(561,1037,43));
        plataforms.add(new Plataform(789,1008,44));
        plataforms.add(new Plataform(467,876,45));
        plataforms.add(new Plataform(1769,404,46));
        plataforms.add(new Plataform(2067,428,47));
        plataforms.add(new Plataform(1759,591,48));
        plataforms.add(new Plataform(2160,617,49));
        plataforms.add(new Plataform(2240,752,50));
        plataforms.add(new Plataform(2559,659,51));
        plataforms.add(new Plataform(2867,650,52));
        plataforms.add(new Plataform(3056,479,53));
        plataforms.add(new Plataform(2321,220,54)); 
        plataforms.add(new Plataform(2783,2404,55));
        plataforms.add(new Plataform(2977,2396,56));
        plataforms.add(new Plataform(2530,2217,57));    
        plataforms.add(new Plataform(3039,2085,58));
        plataforms.add(new Plataform(2752,1960,59));
        plataforms.add(new Plataform(2947,1797,60));
        plataforms.add(new Plataform(2383,1217,61));
        plataforms.add(new Plataform(2373,1060,62));
        plataforms.add(new Plataform(2463,945,63));
        plataforms.add(new Plataform(2240,749,64));
        plataforms.add(new Plataform(2351,860,65));
        plataforms.add(new Plataform(2130,1363,66));
        plataforms.add(new Plataform(1923,797,67));
        plataforms.add(new Plataform(1745,821,68));
        plataforms.add(new Plataform(1760,1069,69));
        plataforms.add(new Plataform(1856,970,70));
        plataforms.add(new Plataform(2049,958,71));
        plataforms.add(new Plataform(2428,225,72));
        plataforms.add(new Plataform(2452,245,73)); 
        plataforms.add(new Plataform(2471,257,74)); 
        plataforms.add(new Plataform(2495,272,75));
        plataforms.add(new Plataform(2527,286,76));
        plataforms.add(new Plataform(2030,2418,77));
        plataforms.add(new Plataform(2062,2409,78));
        plataforms.add(new Plataform(2088,2400,79));
        plataforms.add(new Plataform(2115,2386,80));
        plataforms.add(new Plataform(2144,2371,81));
        plataforms.add(new Plataform(2205,2306,82));
        plataforms.add(new Plataform(2176,2317,83));
        plataforms.add(new Plataform(2234,2292,84));
        plataforms.add(new Plataform(2271,2287,85));
        plataforms.add(new Plataform(1806,1761,86));
        plataforms.add(new Plataform(1880,1774,87));
        plataforms.add(new Plataform(502,1950,88));
        plataforms.add(new Plataform(501,1944,89));
        plataforms.add(new Plataform(455,1931,90));
        plataforms.add(new Plataform(368,1902,91));
        plataforms.add(new Plataform(1132,1376,92));
        plataforms.add(new Plataform(1082,1359,93));
        plataforms.add(new Plataform(1018,1341,94));
        plataforms.add(new Plataform(919,1313,95));
        plataforms.add(new Plataform(1940,1791,96));
        plataforms.add(new Plataform(1333,845,97));
        plataforms.add(new Plataform(1399,828,98));
        plataforms.add(new Plataform(1302,731,99));
        plataforms.add(new Plataform(1278,711,100));
        plataforms.add(new Plataform(1233,693,101));
        plataforms.add(new Plataform(1134,671,102));
        plataforms.add(new Plataform(2167,162,103));
        plataforms.add(new Plataform(2227,181,104));
        plataforms.add(new Plataform(2274,196,105));
        plataforms.add(new Plataform(1082,1395,106));
        //Walls
        walls = new ArrayList();  
        walls.add(new Wall(-100,0,0));
        walls.add(new Wall(2039,2458,1));
        walls.add(new Wall(2766,2274,2));
        walls.add(new Wall(3151,2203,3));
        walls.add(new Wall(3150,1631,4));
        walls.add(new Wall(1927,2132,5));
        walls.add(new Wall(2516,1349,6));
        walls.add(new Wall(2309,1096,7));
        walls.add(new Wall(2257,828,8));
        walls.add(new Wall(2349,339,9));
        walls.add(new Wall(2315,253,10));
        walls.add(new Wall(2420,546,11));
        walls.add(new Wall(3082,545,12));
        walls.add(new Wall(3169,161,13));
        walls.add(new Wall(3105,758,14));
        walls.add(new Wall(659,2074,15));
        walls.add(new Wall(550,1992,16));
        walls.add(new Wall(2061,1735,17));
        walls.add(new Wall(1340,1411,18));
        walls.add(new Wall(859,1272,19));
        walls.add(new Wall(1217,930,20));
        walls.add(new Wall(1858,1003,21));
        walls.add(new Wall(2341,1579,22));
        walls.add(new Wall(2192,2357,23));
        walls.add(new Wall(2345,2234,24));
        walls.add(new Wall(2297,1264,25));
        //Front Wall
        this.frontwall=new Wall(2272,1651,26);
        
        //Hyena
        hyena = new Hyena();
        //Mobs
        mobs = new ArrayList();
        //Chameleon
        mobs.add(new Mob(710,2520,1));
        mobs.add(new Mob(1070,2520,1));
        mobs.add(new Mob(1970,2164,1));
        mobs.add(new Mob(1340,2100,1));
        mobs.add(new Mob( 359,1935,1));
        mobs.add(new Mob(1085,1825,1));
        mobs.add(new Mob(2330,1570,1));
        mobs.add(new Mob(1160,1400,1));
        mobs.add(new Mob( 965,1348,1));
        mobs.add(new Mob(1865, 985,1));
        mobs.add(new Mob(2060, 987,1));
        mobs.add(new Mob(1280, 865,1));
        mobs.add(new Mob(1145, 705,1));
        //Bettle
        mobs.add(new Mob( 830,1874,2));
        mobs.add(new Mob(1400,1773,2));
        mobs.add(new Mob(1745,1531,2));
        mobs.add(new Mob(1445,1127,2));
        //Background
        this.bg = new Background();
        //Timer
        this.timer = new Timer(33,this);
        //Font
        lion15 = Font.createFont(Font.TRUETYPE_FONT, new File("Data/Font/lion_king.ttf"));
        lion15 = lion15.deriveFont(Font.PLAIN,15);
        lion60 = lion15.deriveFont(Font.PLAIN,60);
        //etc
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
        //Sound
        Sounds.bgSound();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        i = player.getImage();
        //Background
        g2d.drawImage(bg.getImage(), bg.getX(), bg.getY(), null);
        //Floor
        g2d.drawImage(floor.getImage(), bg.getX()+floor.getX(), bg.getY()+floor.getY(), null);
        //Plataforms
        for(int i=0; i<plataforms.size(); i++){
            g2d.drawImage(plataforms.get(i).getImage(), bg.getX()+plataforms.get(i).getX(), bg.getY()+plataforms.get(i).getY(), null);
            //g2d.setColor(Color.white);
            //g2d.drawOval(bg.getX()+plataforms.get(i).getX(), bg.getY()+plataforms.get(i).getY(), 5, 5);
        }
        //Walls
        for(int i=0; i<walls.size(); i++)
            g2d.drawImage(walls.get(i).getImage(), bg.getX()+walls.get(i).getX(), bg.getY()+walls.get(i).getY(), null);
        //Hyena
        g2d.drawImage(hyena.getImage(), bg.getX()+hyena.getX(), bg.getY()+hyena.getY()-hyena.getImage().getHeight(null), null);
        //g2d.setColor(Color.white);
        //g2d.drawOval(bg.getX()+hyena.getX(), bg.getY()+hyena.getY(), 5, 5);
        //Mobs
        for(int i=0; i<mobs.size(); i++){
            g2d.drawImage(mobs.get(i).getImage(), bg.getX()+mobs.get(i).getX(), bg.getY()+mobs.get(i).getY()-mobs.get(i).getImage().getHeight(null), null);
            //g2d.setColor(Color.white);
            //g2d.drawOval(bg.getX()+mobs.get(i).getX(), bg.getY()+mobs.get(i).getY(), 5, 5);
        }
        //Player
        g2d.drawImage(i, bg.getX()+(player.getX()-(i.getWidth(null)/2)), bg.getY()+(player.getY()-i.getHeight(null)), null);
        //g2d.setColor(Color.white);
        //g2d.drawOval(bg.getX()+player.getX(), bg.getY()+player.getY(), 5, 5);
        //Front wall
        g2d.drawImage(this.frontwall.getImage(), bg.getX()+this.frontwall.getX(), bg.getY()+this.frontwall.getY(), null);
        //Player lifes
        g2d.drawImage(player.getLifeImage(), 10, 625, null);
        //Info
        g2d.setColor(Color.white);
        //g2d.setFont(lion15);
        g2d.drawString("x: "+player.getX()+" | y: "+player.getY(), 5, 13);
        //Player life String
        g2d.setColor(Color.white);
        g2d.setFont(lion60);
        g2d.drawString(player.getLifes(), 70, 680);
    }

    @Override
    public void keyTyped(KeyEvent ke){}
    @Override
    public void keyPressed(KeyEvent ke){
        switch(ke.getKeyCode()){
            case KeyEvent.VK_ESCAPE : System.exit(0); break;
            case KeyEvent.VK_LEFT : case KeyEvent.VK_A : player.setDx(-1); break;
            case KeyEvent.VK_RIGHT : case KeyEvent.VK_D : player.setDx(1); break;
            case KeyEvent.VK_UP : case KeyEvent.VK_W : player.jump(); break;
        }
    }
    @Override
    public void keyReleased(KeyEvent ke){
        switch(ke.getKeyCode()){
            case KeyEvent.VK_LEFT : case KeyEvent.VK_A : player.setDx(0); break;
            case KeyEvent.VK_RIGHT : case KeyEvent.VK_D : player.setDx(0); break;
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        repaint();
        try {
            collision();
        } catch (Exception ex) {
            Logger.getLogger(PaintPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        camera();
        player.nextFrame();
        hyena.move();
    }
    public void collision() throws Exception{
        //Collision with plataforms (only down)
        boolean over=false;
        for(int i=0; i<plataforms.size(); i++)
            if(plataforms.get(i).isOver(new Point(player.getX(), player.getY()-15))){
                player.setIsOver("Floor");
                player.setDif(player.getY()-plataforms.get(i).getY());
                over=true;
                break;
            }
        if(!over) player.setIsOver("");
        if(floor.isOver(new Point(player.getX(), player.getY()-15))) player.setIsOver("Floor");
        //Collision with walls (left and right)
        over=false;
        for(int j=0; j<walls.size(); j++)
            if(walls.get(j).isOver(new Point(player.getX()+1+(i.getWidth(null)/2), player.getY()))){
                player.move("Right");
                over=true;
                break;
            }
            else if(walls.get(j).isOver(new Point(player.getX()-1-(i.getWidth(null)/2), player.getY()))){
                player.move("Left");
                over=true;
                break;
            }
        if(!over) player.move("");
        //Collision with mobs (up and down)
        for(int j=0; j<mobs.size(); j++){
            mobs.get(j).move();
            if(mobs.get(j).isOver(new Point(player.getX(),player.getY())).equals("Up") && player.getInv()<=0){
                mobs.remove(j);
                Sounds.mobSound();
            } else if(mobs.get(j).isOver(new Point(player.getX(),player.getY())).equals("Down")) player.damage();
        }
        //Collision with Hyena (up and down)
        hyena.move();
        if(hyena.isAlive()){
            if(hyena.isOver(new Point(player.getX(),player.getY())).equals("Up") && player.getInv()<=0) hyena.die();
            else if(hyena.isOver(new Point(player.getX(),player.getY())).equals("Down")) player.damage();
        }
    }
    public void camera(){
        if((player.getX()+bg.getX())<=200 )bg.setX(-player.getX()+200 );
        if((player.getX()+bg.getX())>=1000)bg.setX(-player.getX()+1000);
        if((player.getY()+bg.getY())<=100 )bg.setY(-player.getY()+100 );
        if((player.getY()+bg.getY())>=620 )bg.setY(-player.getY()+620 );
        if(bg.getX()>0)bg.setX(0);
        if(bg.getX()<-3200+1240)bg.setX(-3200+1240);
        if(bg.getY()>0)bg.setY(0);
        if(bg.getY()<-2560+691)bg.setY(-2560+691);
    }
}