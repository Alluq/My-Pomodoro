import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        Window window = new Window(200, 200);
        JLabel jlabel = new JLabel("Hello Wurld");
        jlabel.setPreferredSize(new Dimension(200,200));
        window.addLabel(jlabel, BorderLayout.CENTER);
        window.show();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
