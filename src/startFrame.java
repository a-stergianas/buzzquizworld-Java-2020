import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Κλάση που αναπαριστά το αρχικό παράθυρο του παιχνιδιού από το οποίο ο χρήστης επιλέγει έναν ή δύο παίκτες και βλέπει τα highscores.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class startFrame extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuFile,menuHighscores;
    private JMenuItem Highscores1,Highscores2,menuExit;
    private JPanel panel;
    private JLabel helloLabel;
    private JButton singlePlayerButton,doublePlayerButton;

    /**
     Ο κατασκευαστής της startFrame.
     */
    public startFrame() {
        setTitle("Buzz! Quiz World");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuHighscores = new JMenu("Highscores");
        Highscores1 = new JMenuItem("Single Player");
        Highscores2 = new JMenuItem("Double Player");
        menuExit = new JMenuItem("Exit");
        menuBar.add(menuFile);
        menuFile.add(menuHighscores);
        menuHighscores.add(Highscores1);
        menuHighscores.add(Highscores2);
        menuFile.add(menuExit);

        Highscores1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new highscoresFrame1();
            }
        });
        Highscores2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new highscoresFrame2();
            }
        });
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel = new JPanel();
        helloLabel = new JLabel("Hello, let's play Buzz!");
        helloLabel.setPreferredSize(new Dimension(450,50));
        helloLabel.setHorizontalAlignment(JLabel.CENTER);
        singlePlayerButton = new JButton("Single Player");
        doublePlayerButton = new JButton("Double Player");
        singlePlayerButton.setPreferredSize(new Dimension(200,300));
        doublePlayerButton.setPreferredSize(new Dimension(200,300));

        singlePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new dialogFrame1();
            }
        });
        doublePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new dialogFrame2();
            }
        });

        panel.add(helloLabel);
        panel.add(singlePlayerButton);
        panel.add(doublePlayerButton);

        setJMenuBar(menuBar);
        add(panel);
        setVisible(true);
    }
}