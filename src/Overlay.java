import javax.swing.*;
import java.awt.*;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class Overlay extends JFrame {

    private int overlayHeight = 30;
    private int overlayWidth = 100;

    Overlay(){
        super();
        this.setAlwaysOnTop(true);
        /*this.setUndecorated(true);
        this.setShape(new RoundRectangle2D.Double( 10, 10 ,200 ,100 ,10, 10));*/
    }

    Overlay(String title){
        super(title);
        this.setAlwaysOnTop(true);
        /*this.setUndecorated(true);
        this.setShape(new RoundRectangle2D.Double( 0, 0 ,overlayWidth ,overlayHeight ,50, 50));*/
    }




}
