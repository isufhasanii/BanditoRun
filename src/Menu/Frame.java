package Menu;

import gui.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

    private JButton start;
    private JButton setting;
    private JButton information;
    private JButton end;



    public static void main(String[] args) {

        Frame frame = new Frame("HomeMenu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    public Frame(String title){
        super(title);

        start = new JButton("Spiel starten");
        start.setBounds(120,40,160,40);
        start.addActionListener(this::actionPerformed);
        add(start);

        setting = new JButton("Einstellungen");
        setting.setBounds(120,110,160,40);
        setting.addActionListener(this::actionPerformed);
        add(setting);

        information = new JButton("Credits");
        information.setBounds(120,190,160,40);
        information.addActionListener(this::actionPerformed);
        add(information);

        end = new JButton("Beenden");
        end.setBounds(120,260,160,40);
        end.addActionListener(this::actionPerformed);
        add(end);

    }

    public static void fenster() {
        JFrame fenster = new JFrame();
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setSize(650,350);
        fenster.setVisible(true);
        fenster.add(new gui());

    }

    public static void auswahl(){
        JFrame auswahl = new JFrame();
        auswahl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        auswahl.setSize(450,350);
        auswahl.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == start){
            fenster();
        }

        if (e.getSource() == information){
            Object[] option = {"OK"};

            JOptionPane.showOptionDialog(null, "Programmiert von Isuf Hasani", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null,option,option[0]);
        }

        if (e.getSource() == setting){
            auswahl();
        }

        if (e.getSource() == end){
            System.exit(0);
        }
    }

}
