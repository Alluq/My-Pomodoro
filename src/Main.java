import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Main {

    //Enums for different intervals
    public enum Intervals {
        SHORT_BREAK(5.00),
        LONG_BREAK(60.00),
        POMODORO(25.00);

        private double time;

        private Intervals(double time) {
            this.time = time;
        }

        public double time() {
            return this.time;
        }
    }


    //Main Overlay timer
    private static Overlay overlayTimer;
    private static JLabel timerText;

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    //Timer that ticks ever second
    private static Timer timer;

    //Current Timer Interval
    private static Intervals currentTimerState = Intervals.POMODORO;

    //Current timer time
    private static double timerTime = Intervals.POMODORO.time();

    // Makes the Gui and initializes everything
    private static void initializeGUI() {

        //Setting the Overlay
        overlayTimer = new Overlay("My Pomodoro Timer");
        overlayTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        overlayTimer.setBackground(Color.BLACK);
        overlayTimer.setResizable(true);

        //Setting the timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //If time is up
                if (timerTime < 0.01) {
                    timerText.setText("Done!");

                    //Changes pomodoro to short-break
                    if (currentTimerState == Intervals.POMODORO) {

                        //pop-up message
                        overlayTimer.setLocation(SCREEN_SIZE.width/2, SCREEN_SIZE.height/2);
                        JOptionPane.showMessageDialog(overlayTimer, "Pomodoro is Done Click Ok to Start Short Break");

                        //Set Short Break
                        timerTime = Intervals.SHORT_BREAK.time();
                        currentTimerState = Intervals.SHORT_BREAK;

                    }

                    //Changes short-break to pomodoor
                    else if (currentTimerState == Intervals.SHORT_BREAK) {

                        //pop-up message
                        overlayTimer.setLocation(SCREEN_SIZE.width/2, SCREEN_SIZE.height/2);
                        JOptionPane.showMessageDialog(overlayTimer, "Short Break is Done Click Ok to Start Pomodoro");

                        //set pomodoro
                        timerTime = Intervals.POMODORO.time();
                        currentTimerState = Intervals.POMODORO;
                    }
                    timer.restart();
                    overlayTimer.setLocation(0, 0);
                }

                //If timer's not up continues countdown
                else {
                    timerTime -= 0.01;
                }
                timerText.setText(new DecimalFormat("#.00").format(timerTime));
            }
        });

        //Sets text
        timerText = new JLabel(new DecimalFormat("#.00").format(timerTime), SwingConstants.CENTER);
        timerText.setPreferredSize(new Dimension(100, 30));
        overlayTimer.getContentPane().add(timerText, BorderLayout.CENTER);
    }

    private static void showAndUpdateGUI() {
        overlayTimer.pack();
        overlayTimer.show();
    }


    public static void main(String[] args) {
        initializeGUI();
        timer.start();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showAndUpdateGUI();
            }
        });
    }
}
