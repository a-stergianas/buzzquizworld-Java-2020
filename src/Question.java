import java.util.Random;

/**
 Κλάση που αναπαριστά μία ερώτηση.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class Question {

    private String category;                        // Μεταβλητή για την κατηγορία της ερώτησης
    private String question;                        // Μεταβλητή για την εκφώνηση της ερώτησης
    private String image;                           // Μεταβλητή για το όνομα της εικόνας
    private String correctAnswer;                   // Μεταβλητή για την σωστή απάντηση της ερώτησης
    private String[] wrongAnswers= new String[3];   // Πίνακας για τις 3 λάθος απαντήσεις
    private boolean used;                           // Λογική μεταβλητή για το αν έχει χρησιμοποιηθεί η ερώτηση ξανά

    /**
     Κατασκευαστής της κλάσης Question για απλή ερώτηση.
     …
     @param category η κατηγορία της ερώτησης
     @param question η εκφώνηση της ερώτησης
     @param correctAnswer η σωστή απάντηση της ερώτησης
     @param wrongAnswer1 η πρώτη από τις 3 λάθος απαντήσεις
     @param wrongAnswer2 η δεύτερη από τις 3 λάθος απαντήσεις
     @param wrongAnswer3 η τρίτη από τις 3 λάθος απαντήσεις
     */
    public Question(String category, String question, String correctAnswer,String wrongAnswer1,String wrongAnswer2,String wrongAnswer3) {
        this.category = category;
        this.question = question;
        this.image="none";
        this.correctAnswer = correctAnswer;
        this.wrongAnswers[0] = wrongAnswer1;
        this.wrongAnswers[1] = wrongAnswer2;
        this.wrongAnswers[2] = wrongAnswer3;
        this.used = false;
    }

    /**
     Κατασκευαστής της κλάσης Question για ερώτηση με εικόνα.
     …
     @param category η κατηγορία της ερώτησης
     @param question η εκφώνηση της ερώτησης
     @param correctAnswer η σωστή απάντηση της ερώτησης
     @param wrongAnswer1 η πρώτη από τις 3 λάθος απαντήσεις
     @param wrongAnswer2 η δεύτερη από τις 3 λάθος απαντήσεις
     @param wrongAnswer3 η τρίτη από τις 3 λάθος απαντήσεις
     @param image το όνομα του αρχείου εικόνας της ερώτησης
     */
    public Question(String category, String question, String correctAnswer,String wrongAnswer1,String wrongAnswer2,String wrongAnswer3,String image) {
        this.category = category;
        this.question = question;
        this.image = image;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers[0] = wrongAnswer1;
        this.wrongAnswers[1] = wrongAnswer2;
        this.wrongAnswers[2] = wrongAnswer3;
        this.used = false;
    }

    /**
     Κλάση που μετατρέπει την τιμή used της ερώτησης σε true.
     */
    public void isUsed(){
        this.used = true;
    }

    /**
     Κλάση που μετατρέπει την τιμή used της ερώτησης σε false.
     */
    public void isNOTUsed(){
        this.used = false;
    }

    /**
     Κλάση τύπου String που επιστρέφει την κατηγορία της ερώτησης.
     …
     @return category η κατηγορία της ερώτησης
     …
     */
    public String getCategory(){
        return this.category;
    }

    /**
     Κλάση τύπου String που επιστρέφει την εκφώνηση της ερώτησης.
     …
     @return question η εκφώνηση της ερώτησης
     …
     */
    public String getQuestion(){
        return this.question;
    }

    /**
     Κλάση τύπου String που επιστρέφει το όνομα αρχείου εικόνας της ερώτησης.
     …
     @return image η εικόνα της ερώτησης
     …
     */
    public String getImage(){
        return this.image;
    }

    /**
     Κλάση τύπου String που επιστρέφει την σωστή απάντηση της ερώτησης.
     …
     @return correctAnswer η σωστή απάντηση της ερώτησης
     …
     */
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }

    /**
     Κλάση τύπου String που επιστρέφει την λάθος απάντηση της ερώτησης που βρίσκεται στην θέση i.
     …
     @param i η θέση της λάθος απάντησης που θέλουμε να επιστραφεί
     …
     @return wrongAnswers[i] η λάθος απάντηση της ερώτησης που ζητήθηκε
     …
     */
    public String getWrongAnswers(int i){
        return this.wrongAnswers[i];
    }

    /**
     Κλάση τύπου boolean που επιστρέφει αν η ερώτηση έχει χρησιμοποιηθεί.
     …
     @return used η λογικη μεταβλητή που δείχνει αν η ερώτηση έχει χρησιμοποιηθεί
     …
     */
    public boolean getUsed(){
        return this.used;
    }

    /**
     Κλάση τύπου πίνακα String που επιστρέφει με τυχαία σειρά τις 4 πιθανές απαντήσεις καθώς και την σωστή επιλογή που θα πρέπει να κάνει ο παίκτης.
     …
     @return τον χαρακτήρα που δείχνει την σωστή απάντηση
     …
     */
    public String[] getRandomAnswers() {
        String[] returnAnswers = new String[5];
        Random rand = new Random();
        int answersOrder = rand.nextInt(24);
        switch (answersOrder) {
            case 0:     //ABCD
                returnAnswers[0]="A";
                returnAnswers[1]="A) " + this.correctAnswer;
                returnAnswers[2]="B) " + this.wrongAnswers[0];
                returnAnswers[3]="C) " + this.wrongAnswers[1];
                returnAnswers[4]="D) " + this.wrongAnswers[2];
                break;
            case 1:     //ABDC
                returnAnswers[0]="A";
                returnAnswers[1]="A) " + this.correctAnswer;
                returnAnswers[2]="B) " + this.wrongAnswers[0];
                returnAnswers[3]="C) " + this.wrongAnswers[2];
                returnAnswers[4]="D) " + this.wrongAnswers[1];
                break;
            case 2:     //ACBD
                returnAnswers[0]="A";
                returnAnswers[1]="A) " + this.correctAnswer;
                returnAnswers[2]="B) " + this.wrongAnswers[1];
                returnAnswers[3]="C) " + this.wrongAnswers[0];
                returnAnswers[4]="D) " + this.wrongAnswers[2];
                break;
            case 3:     //ACDB
                returnAnswers[0]="A";
                returnAnswers[1]="A) " + this.correctAnswer;
                returnAnswers[2]="B) " + this.wrongAnswers[1];
                returnAnswers[3]="C) " + this.wrongAnswers[2];
                returnAnswers[4]="D) " + this.wrongAnswers[0];
                break;
            case 4:     //ADBC
                returnAnswers[0]="A";
                returnAnswers[1]="A) " + this.correctAnswer;
                returnAnswers[2]="B) " + this.wrongAnswers[2];
                returnAnswers[3]="C) " + this.wrongAnswers[0];
                returnAnswers[4]="D) " + this.wrongAnswers[1];
                break;
            case 5:     //ADCB
                returnAnswers[0]="A";
                returnAnswers[1]="A) " + this.correctAnswer;
                returnAnswers[2]="B) " + this.wrongAnswers[2];
                returnAnswers[3]="C) " + this.wrongAnswers[1];
                returnAnswers[4]="D) " + this.wrongAnswers[0];
                break;
            case 6:     //BACD
                returnAnswers[0]="B";
                returnAnswers[1]="A) " + this.wrongAnswers[0];
                returnAnswers[2]="B) " + this.correctAnswer;
                returnAnswers[3]="C) " + this.wrongAnswers[1];
                returnAnswers[4]="D) " + this.wrongAnswers[2];
                break;
            case 7:     //BADC
                returnAnswers[0]="B";
                returnAnswers[1]="A) " + this.wrongAnswers[0];
                returnAnswers[2]="B) " + this.correctAnswer;
                returnAnswers[3]="C) " + this.wrongAnswers[2];
                returnAnswers[4]="D) " + this.wrongAnswers[1];
                break;
            case 8:     //BCAD
                returnAnswers[0]="C";
                returnAnswers[1]="A) " + this.wrongAnswers[0];
                returnAnswers[2]="B) " + this.wrongAnswers[1];
                returnAnswers[3]="C) " + this.correctAnswer;
                returnAnswers[4]="D) " + this.wrongAnswers[2];
                break;
            case 9:     //BCDA
                returnAnswers[0]="D";
                returnAnswers[1]="A) " + this.wrongAnswers[0];
                returnAnswers[2]="B) " + this.wrongAnswers[1];
                returnAnswers[3]="C) " + this.wrongAnswers[2];
                returnAnswers[4]="D) " + this.correctAnswer;
                break;
            case 10:    //BDAC
                returnAnswers[0]="C";
                returnAnswers[1]="A) " + this.wrongAnswers[0];
                returnAnswers[2]="B) " + this.wrongAnswers[2];
                returnAnswers[3]="C) " + this.correctAnswer;
                returnAnswers[4]="D) " + this.wrongAnswers[1];
                break;
            case 11:    //BDCA
                returnAnswers[0]="D";
                returnAnswers[1]="A) " + this.wrongAnswers[0];
                returnAnswers[2]="B) " + this.wrongAnswers[2];
                returnAnswers[3]="C) " + this.wrongAnswers[1];
                returnAnswers[4]="D) " + this.correctAnswer;
                break;
            case 12:    //CABD
                returnAnswers[0]="B";
                returnAnswers[1]="A) " + this.wrongAnswers[1];
                returnAnswers[2]="B) " + this.correctAnswer;
                returnAnswers[3]="C) " + this.wrongAnswers[0];
                returnAnswers[4]="D) " + this.wrongAnswers[2];
                break;
            case 13:    //CADB
                returnAnswers[0]="B";
                returnAnswers[1]="A) " + this.wrongAnswers[1];
                returnAnswers[2]="B) " + this.correctAnswer;
                returnAnswers[3]="C) " + this.wrongAnswers[2];
                returnAnswers[4]="D) " + this.wrongAnswers[0];
                break;
            case 14:    //CBAD
                returnAnswers[0]="C";
                returnAnswers[1]="A) " + this.wrongAnswers[1];
                returnAnswers[2]="B) " + this.wrongAnswers[0];
                returnAnswers[3]="C) " + this.correctAnswer;
                returnAnswers[4]="D) " + this.wrongAnswers[2];
                break;
            case 15:    //CBDA
                returnAnswers[0]="D";
                returnAnswers[1]="A) " + this.wrongAnswers[1];
                returnAnswers[2]="B) " + this.wrongAnswers[0];
                returnAnswers[3]="C) " + this.wrongAnswers[2];
                returnAnswers[4]="D) " + this.correctAnswer;
                break;
            case 16:    //CDAB
                returnAnswers[0]="C";
                returnAnswers[1]="A) " + this.wrongAnswers[1];
                returnAnswers[2]="B) " + this.wrongAnswers[2];
                returnAnswers[3]="C) " + this.correctAnswer;
                returnAnswers[4]="D) " + this.wrongAnswers[0];
                break;
            case 17:    //CDBA
                returnAnswers[0]="D";
                returnAnswers[1]="A) " + this.wrongAnswers[1];
                returnAnswers[2]="B) " + this.wrongAnswers[2];
                returnAnswers[3]="C) " + this.wrongAnswers[0];
                returnAnswers[4]="D) " + this.correctAnswer;
                break;
            case 18:    //DABC
                returnAnswers[0]="B";
                returnAnswers[1]="A) " + this.wrongAnswers[2];
                returnAnswers[2]="B) " + this.correctAnswer;
                returnAnswers[3]="C) " + this.wrongAnswers[0];
                returnAnswers[4]="D) " + this.wrongAnswers[1];
                break;
            case 19:    //DACB
                returnAnswers[0]="B";
                returnAnswers[1]="A) " + this.wrongAnswers[2];
                returnAnswers[2]="B) " + this.correctAnswer;
                returnAnswers[3]="C) " + this.wrongAnswers[1];
                returnAnswers[4]="D) " + this.wrongAnswers[0];
                break;
            case 20:    //DBAC
                returnAnswers[0]="C";
                returnAnswers[1]="A) " + this.wrongAnswers[2];
                returnAnswers[2]="B) " + this.wrongAnswers[0];
                returnAnswers[3]="C) " + this.correctAnswer;
                returnAnswers[4]="D) " + this.wrongAnswers[1];
                break;
            case 21:    //DBCA
                returnAnswers[0]="D";
                returnAnswers[1]="A) " + this.wrongAnswers[2];
                returnAnswers[2]="B) " + this.wrongAnswers[0];
                returnAnswers[3]="C) " + this.wrongAnswers[1];
                returnAnswers[4]="D) " + this.correctAnswer;
                break;
            case 22:    //DCAB
                returnAnswers[0]="C";
                returnAnswers[1]="A) " + this.wrongAnswers[2];
                returnAnswers[2]="B) " + this.wrongAnswers[1];
                returnAnswers[3]="C) " + this.correctAnswer;
                returnAnswers[4]="D) " + this.wrongAnswers[0];
                break;
            case 23:    //DCBA
                returnAnswers[0]="D";
                returnAnswers[1]="A) " + this.wrongAnswers[2];
                returnAnswers[2]="B) " + this.wrongAnswers[1];
                returnAnswers[3]="C) " + this.wrongAnswers[0];
                returnAnswers[4]="D) " + this.correctAnswer;
                break;
        }
        return returnAnswers;
    }
}