import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Main extends JFrame implements ActionListener{
    JButton Stare;
    JButton nade;
    JButton sleep;
    JPanel Scrn;
    Image stareImage;
    Image caressImage;
    Image sleepImage;
    Image img;
    public Main(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setTitle("かわいいねこちゃん");
        Scrn = new JPanel();
        Scrn.setSize(400,300);
        Scrn.setBackground(new Color(255,255,170));
        setLayout(new BorderLayout());
        add(Scrn,BorderLayout.CENTER);

        try {
            stareImage = ImageIO.read(new File("img/stare.png"));
            caressImage = ImageIO.read(new File("img/nadenade.png"));
            sleepImage = ImageIO.read(new File("img/sleep.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stare = new JButton("stare");
        nade  = new JButton("caress");
        sleep = new JButton("put to bed");

        Stare.addActionListener(this);
        nade.addActionListener(this);
        sleep.addActionListener(this);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getContentPane().add(Stare);
        getContentPane().add(nade);
        getContentPane().add(sleep);
        

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        setPreferredSize(new Dimension(400,300));
        if (e.getSource() == Stare) {
            img = stareImage;
            repaint();
        }else if(e.getSource() == nade) {
            img = caressImage;
            repaint();
        }else if (e.getSource() == sleep) {
            img = sleepImage;
            repaint();
        }
    }
    public static void main(String[] args){
        new Main();
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(img, 0, 0, null);
    }
}


    

