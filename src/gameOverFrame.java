import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Κλάση που αναπαριστά το παράθυρο στο τέλος του παιχνιδιού ενημερώνοντας για το αποτέλεσμα.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class gameOverFrame extends JFrame{

    private JPanel panel;
    private JLabel l1,l2,l3;
    private JButton playAgainButton,homeButton;
    private double totalPoints,totalPoints1,totalPoints2;
    private Box box;

    /**
     Ο κατασκευαστής της κλάσης gameOverFrame με 3 ορίσματα για το τέλος του παιχνιδιού ενός παίκτη.
     …
     @param PlayerName το όνομα του παίκτη
     @param points οι συνολικοί πόντοι του παίκτη
     @param r το συνολικό πλήθος γύρων
     */
    public gameOverFrame(String PlayerName,double points,int r) {

        totalPoints=points;

        setTitle("Buzz! Quiz World (Game Over)");
        setSize(500, 200);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panel = new JPanel();
        l1 = new JLabel("Gave Over!");
        l2 = new JLabel(PlayerName + " scored " + totalPoints + " points in " + r + " rounds.");

        playAgainButton = new JButton("PLAY AGAIN");
        homeButton = new JButton("BACK TO MAIN MENU");

        box = Box.createVerticalBox();

        box.add(l1);
        box.add(l2);
        box.add(playAgainButton);
        box.add(homeButton);

        box.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(box);
        add(panel);

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new dialogFrame1();
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new startFrame();
            }
        });
    }

    /**
     Ο κατασκευαστής της κλάσης gameOverFrame με 4 ορίσματα για το τέλος του παιχνιδιού δύο παικτών.
     …
     @param Player1 το όνομα του παίκτη 1
     @param Player2 το όνομα του παίκτη 2
     @param points1 οι συνολικοί πόντοι του παίκτη 1
     @param points2 οι συνολικοί πόντοι του παίκτη 2
     */
    public gameOverFrame (String Player1, String Player2,double points1,double points2) {

        totalPoints1=points1;
        totalPoints2=points2;

        setTitle("Buzz! Quiz World (Game Over)");
        setSize(500, 200);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panel = new JPanel();
        l1 = new JLabel("Gave Over!");
        l2 = new JLabel();
        if(totalPoints1>totalPoints2){
            l2.setText(Player1 + " wins " + Player2 + " " + totalPoints1 + "-" + totalPoints2);
        }else{
            if(totalPoints2>totalPoints1){
                l2.setText(Player2 + " wins " + Player1 + " " + totalPoints2 + "-" + totalPoints1);
            }else{
                l2.setText(Player1 + " and " + Player2 + " draw " + totalPoints1 + " - " + totalPoints2);
            }
        }


        playAgainButton = new JButton("PLAY AGAIN");
        homeButton = new JButton("BACK TO MAIN MENU");

        box = Box.createVerticalBox();

        box.add(l1);
        box.add(l2);
        box.add(playAgainButton);
        box.add(homeButton);

        box.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(box);
        add(panel);

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new dialogFrame2();
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new startFrame();
            }
        });
    }
}