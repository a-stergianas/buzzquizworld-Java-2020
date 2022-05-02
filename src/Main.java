import java.io.*;
import java.util.*;

/**
 Η main κλάση του παιχνιδιού στην οποία φορτώνονται τα highscore για το μονό και το διπλό παιχνίδι και ξεκινάει το παιχνίδι.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class Main {

    public static HashMap<String,Double> highscores1 = new HashMap<>();
    public static HashMap<String,Integer> highscores2 = new HashMap<String, Integer>();

    /**
     Η main κλάση του παιχνιδιού στην οποία φορτώνονται τα highscore για το μονό και το διπλό παιχνίδι και ξεκινάει το παιχνίδι.
     */
    public static void main(String[] args) throws FileNotFoundException {
        highscores.read1();
        highscores.read2();
        new startFrame();
    }
}



