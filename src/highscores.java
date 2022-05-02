import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 Κλάση που διαχειρίζεται τα highscores.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class highscores {

    /**
     Η μέθοδος read1 διαβάζει τα ήδη υπάρχοντα highscore από το αρχείο "hightscores1.txt" για το παιχνίδι ενός παίκτη.
     */
    public static void read1(){
        File file = new File("hightscores1.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            else{
                Scanner s = new Scanner(file);
                while (s.hasNext()) {
                    Main.highscores1.put(s.next(),Double.valueOf(s.next()));
                }
                s.close();
            }
        }
        catch (IOException e) {}
    }

    /**
     Η μέθοδος write1 φορτώνει τα νέα highscore στο αρχείο "hightscores1.txt" για το παιχνίδι ενός παίκτη.
     */
    public static void write1(){
        File file = new File("hightscores1.txt");
        try {
            file.delete();
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Double> e : Main.highscores1.entrySet()){
                bw.write(e.getKey());
                bw.write(" ");
                bw.write(String.valueOf(e.getValue()));
                bw.write("\r");
            }
            bw.close();
        } catch (IOException e) {}
    }

    /**
     Η μέθοδος read2 διαβάζει τα ήδη υπάρχοντα highscore από το αρχείο "hightscores2.txt" για το παιχνίδι δύο παικτών.
     */
    public static void read2(){
        File file = new File("hightscores2.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            else{
                Scanner s = new Scanner(file);
                while (s.hasNext()) {
                    Main.highscores2.put(s.next(),Integer.valueOf(s.next()));
                }
                s.close();
            }
        }
        catch (IOException e) {}
    }

    /**
     Η μέθοδος write2 φορτώνει τα νέα highscore στο αρχείο "hightscores2.txt" για το παιχνίδι δύο παικτών.
     */
    public static void write2(){
        File file = new File("hightscores2.txt");
        try {
            file.delete();
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Integer> e : Main.highscores2.entrySet()){
                bw.write(e.getKey());
                bw.write(" ");
                bw.write(String.valueOf(e.getValue()));
                bw.write("\r");
            }
            bw.close();
        } catch (IOException e) {}
    }
}
