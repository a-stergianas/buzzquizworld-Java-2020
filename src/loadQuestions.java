import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 Κλάση που επιλέγει και επιστρέφει τυχαία τον απαραίτητο αριθμό ερωτήσεων για το παιχνίδι.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class loadQuestions {

    /**
     Κλάση τύπου πίνακα Question 2 διαστάσεων που προσθέτει τις ερωτήσεις σε έναν δισδιάστατο πίνακα
     (έτσι ώστε η πρώτη διάσταση να προσδιορίζει τον αριθμό γύρου)
     και επιστρέγει τυχαία (a*b) από αυτές για να παίξει ο παίκτης.
     …
     @param a το πλήθος των γύρων που επέλεξε ο χρήστης.
     @param b το πλήθος των ερωτήσεων ανά γύρω που επέλεξαν οι δημιουργοί (5).
     @return returnQuestions πίνακας τύπου Question 2 διαστάσεων με τις ερωτήσεις που θα παίξει ο παίκτης.
     */
    public static Question[][] loadQuestions(int a, int b) {
        Random rand = new Random();
        int NumberOfQuestions=0;
        String[] Helper1;
        ArrayList Helper = new ArrayList<String>(5);
        Question[] questions;
        Question[][] returnQuestions = new Question[a][b];
        int random;

        File file1 = new File("Questions.txt");
        try {
            Scanner s = new Scanner(file1);
            while (s.hasNextLine()) {
                Helper.add(s.nextLine());
                NumberOfQuestions ++;
            }
            s.close();
        } catch (IOException e) {
        }

        questions = new Question[NumberOfQuestions];
        Helper1 = new String[8];
        for (int i=0; i<NumberOfQuestions; i++) {
            String s1;
            s1 = (String) Helper.get(i);
            Helper1 = s1.split("-");
            if (Helper1[0].equals("1")) {
                questions[i] = new Question(Helper1[1],Helper1[2],Helper1[3],Helper1[4],Helper1[5],Helper1[6]);
            }
            if (Helper1[0].equals("2")) {
                questions[i] = new Question(Helper1[1],Helper1[2],Helper1[3],Helper1[4],Helper1[5],Helper1[6],Helper1[7]);
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                do {
                    random=rand.nextInt(NumberOfQuestions);
                } while (questions[random].getUsed());
                returnQuestions[i][j] = questions[random];
                questions[random].isUsed();
            }
        }
        return returnQuestions;
    }
}
