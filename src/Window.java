import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame{
    private int width;
    private int height;
    public JFrame jframe;

    

    public Window(int w, int h){
         width = w;
         height = h;
         jframe = new JFrame("Lmao");
         jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void show(){
        jframe.pack();
        jframe.setVisible(true);
    }

    public void addLabel(JLabel label, String layout){
        System.out.print(null == jframe);
        jframe.getContentPane().add(label, layout);
    }


}
