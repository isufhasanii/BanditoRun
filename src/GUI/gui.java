package GUI;

import Movement.Jump;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class gui extends JPanel implements ActionListener {

    int X_Bild;
    Timer time;
    Image img;
    Image img2;
    int key;
    int walk;
    int anzahl = 0;
    int anzahl2 = 0;
    int nx,nx2;
    int left = 0;
    int figur_y = 235;

    public gui(){
        nx = 0;
        nx2 = 690;
        key = 0;
        walk = 0;
        setFocusable(true);
        ImageIcon u = new ImageIcon("C:/Users/agim7/IdeaProjects/BanditoRun/Bilder/background.jpg");
        img = u.getImage();
        ImageIcon s = new ImageIcon("C:/Users/agim7/IdeaProjects/BanditoRun/Bilder/bandit.png");
        img2 = s.getImage();
        addKeyListener(new AL());
        Jump jump = new Jump();
        time = new Timer(5, this);
        time.start();

    }

    public void paint (Graphics g){

        super.paint(g);
        Graphics2D f2 = (Graphics2D) g;

        if (getXBild() == 0 + (anzahl*1300)){
            anzahl += 1;
            nx = 0;
        }

        if(getXBild() == 650 + (anzahl2*1300)){
            anzahl2 += 1;
            nx2 = 0;
        }

        if (getXBild() >= 0){
            f2.drawImage(img,650-nx,0,null);
        }

        f2.drawImage(img,650-nx2,0, null);

        f2.drawImage(img2, left,figur_y,null);

    }
    public int getXBild(){
        return X_Bild;
    }

    public void move(){
        if(walk != -2){

            if (left + walk <= 75){
                left += walk;

            }else {
                X_Bild += walk;
                nx += walk;
                nx2 += walk;
            }
        }else {
            if (left+walk > 0){
                left += walk;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        move();
        figur_y = Jump.JumpPosition;
        repaint();

    }


    private class AL extends KeyAdapter{

        public AL(){

        }

        public void keyPressed(KeyEvent e){

            key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT){
                walk = -2;
            }
            if (key == KeyEvent.VK_RIGHT){
                walk = 2;
            }
            if (key == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }
            if(key == KeyEvent.VK_SPACE){
                if (Jump.fertig == true)
                Jump();
            }
        }

        public void keyReleased(KeyEvent e){

            key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
                walk = 0;
            }
        }


    }
    public void Jump(){
            Jump JumpAnimation = new Jump();
            JumpAnimation.start();
    }
}
