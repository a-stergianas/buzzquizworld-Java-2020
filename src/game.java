import java.util.Random;

/**
 Κλάση που εκτελεί το παιχνίδι καλώντας τυχαία τους τύπους γύρου που θα παιχτούν και ελέγχοντας για νέα highscore.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class game {

    /**
     Κλάση που εκτελεί το παιχνίδι ενός παίκτη.
     …
     @param PlayerName το όνομα του παίκτη
     @param i ο αριθμός του τρέχοντος γύρου
     @param r το συνολικό πλήθος γύρων
     @param totalPoints οι συνολικοί πόντοι του παίκτη
     */
    public static void game1(String PlayerName, int i, int r,double totalPoints) {
        int q=5,roundType;
        Question[][] questions = loadQuestions.loadQuestions(r, q);
        Random rand = new Random();

        if(i<r) {
            roundType = rand.nextInt(3);
            switch (roundType) {
                case 0:
                    new roundTypeCorrectAnswer(PlayerName,i, r, q, questions[i],totalPoints);
                    break;
                case 1:
                    new roundTypeBetting(PlayerName,i, r, q, questions[i],totalPoints);
                    break;
                case 2:
                    new roundTypeStopTheClock(PlayerName,i, r, q, questions[i],totalPoints);
                    break;
            }
        }
        else {
            if (Main.highscores1.containsKey(PlayerName)) {
                if (totalPoints > Main.highscores1.get(PlayerName)) {
                    Main.highscores1.replace(PlayerName, totalPoints);
                    highscores.write1();
                }
            } else {
                Main.highscores1.put(PlayerName, totalPoints);
                highscores.write1();
            }
            new gameOverFrame(PlayerName,totalPoints,r);
        }
    }

    /**
     Κλάση που εκτελεί το παιχνίδι δύο παικτών.
     …
     @param Player1 το όνομα του παίκτη 1
     @param Player1 το όνομα του παίκτη 2
     @param i ο αριθμός του τρέχοντος γύρου
     @param r το συνολικό πλήθος γύρων
     @param totalPoints1 οι συνολικοί πόντοι του παίκτη1
     @param totalPoints2 οι συνολικοί πόντοι του παίκτη2
     */
    public static void game2(String Player1, String Player2, int i, int r,double totalPoints1,double totalPoints2) {
        int q=5,roundType;
        Question[][] questions = loadQuestions.loadQuestions(r, q);
        Random rand = new Random();
        int newWins;
        String winner;

        if(i<r) {
            roundType = rand.nextInt(5);
            switch (roundType) {
                case 0:
                    new roundTypeCorrectAnswer(Player1,Player2,i, r, q, questions[i],totalPoints1,totalPoints2);
                    break;
                case 1:
                    new roundTypeBetting(Player1,Player2,i, r, q, questions[i],totalPoints1,totalPoints2);
                    break;
                case 2:
                    new roundTypeStopTheClock(Player1,Player2,i, r, q, questions[i],totalPoints1,totalPoints2);
                    break;
                case 3:
                    new roundTypeQuickAnswer(Player1,Player2,i, r, q, questions[i],totalPoints1,totalPoints2);
                    break;
                case 4:
                    for(int p=0;p<q;p++){
                        questions[i][p].isNOTUsed();
                    }
                    new roundTypeThermometer(Player1,Player2,i, r,totalPoints1,totalPoints2);
                    break;
            }
        }
        else {
            if(totalPoints1!=totalPoints2){
                if(totalPoints1>totalPoints2){
                    winner=Player1;
                }
                else{
                    winner=Player2;
                }
                if (Main.highscores2.containsKey(winner)) {
                    newWins = Main.highscores2.get(winner) + 1;
                    Main.highscores2.replace(winner, newWins);
                    highscores.write2();
                } else {
                    Main.highscores2.put(winner, 1);
                    highscores.write2();
                }
            }
            new gameOverFrame(Player1,Player2,totalPoints1,totalPoints2);
        }
    }
}