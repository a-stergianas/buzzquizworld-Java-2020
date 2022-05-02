import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.util.*;
import java.util.Scanner;

/**
 Κλάση που αναπαριστά το παράθυρο εμφάνισης των highscores για το παιχνίδι δύο παικτών.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class highscoresFrame2 extends JFrame {

    /**
     Ο κατασκευαστής της κλάσης highscoresFrame2.
     */
    public highscoresFrame2() {
        String PointsString;

        HashMap<String, Integer> highscores2 = new HashMap<>();
        File file2 = new File("hightscores2.txt");
        try {
            Scanner s = new Scanner(file2);
            while (s.hasNext()) {
                highscores2.put(s.next(),Integer.valueOf(s.next()));
            }
            s.close();
        }
        catch (IOException e) {}

        String[] Colum = {"Name", "Wins"};
        String[][] data = new String[highscores2.size()][2];
        int count = 0;
        for(Map.Entry<String,Integer> entry : highscores2.entrySet()){
            data[count][0] = entry.getKey();
            int a =entry.getValue();
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




