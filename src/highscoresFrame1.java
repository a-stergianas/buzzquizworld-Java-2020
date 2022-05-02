import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.util.*;
import java.util.Scanner;

/**
 Κλάση που αναπαριστά το παράθυρο εμφάνισης των highscores για το παιχνίδι ενός παίκτη.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class highscoresFrame1 extends JFrame {

    /**
     Ο κατασκευαστής της κλάσης highscoresFrame1.
     */
    public highscoresFrame1() {
        String PointsString;

        HashMap<String, Double> highscores1 = new HashMap<>();
        File file1 = new File("hightscores1.txt");
        try {
            Scanner s = new Scanner(file1);
            while (s.hasNext()) {
                highscores1.put(s.next(),Double.valueOf(s.next()));
            }
            s.close();
        }
        catch (IOException e) {}

        String[] Colum = {"Name", "Highscore"};
        String[][] data = new String[highscores1.size()][2];
        int count = 0;
        for(Map.Entry<String,Double> entry : highscores1.entrySet()){
            data[count][0] = entry.getKey();
            double a =entry.getValue();
            PointsString = String.valueOf(a);
            data[count][1] = PointsString;
            count++;
        }

        JTable table = new JTable(data, Colum);
        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}




