package gui;

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
        time = new Timer(5, this);
        time.start();
    }

    public void paint (Graphics g){

        super.paint(g);
        Graphics2D f2 = (Graphics2D) g;

        if (getXBild() == 510 + (anzahl * 2350)){
            anzahl += 1;
            nx = 0;
        }

        if (getXBild() == 1690+ (anzahl*2350)){
            anzahl += 1;
            nx2 = 0;
        }

        if (getXBild() >= 510){
            f2.drawImage(img,685-nx,0,null);
        }

        f2.drawImage(img,685-nx2,0, null);

        f2.drawImage(img2, 30,235,null);

    }
    public int getXBild(){
        return X_Bild;
    }

    public void move(){

        X_Bild += walk;
        nx += walk;
        nx2 += walk;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        move();
        repaint();

    }


    private class AL extends KeyAdapter{

        public AL(){

        }

        public void KeyPressed(KeyEvent e){

            key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT){
                walk = -2;
            }
            if (key == KeyEvent.VK_RIGHT){
                walk = 2;
            }
        }

        public void keyReleased(KeyEvent e){

            key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
                walk = 0;
            }
        }


    }

}
