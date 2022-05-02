import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 Κλάση που αναπαριστά έναν γύρο τύπου "Θερμόμετρο".
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class roundTypeThermometer extends JFrame {

    private JPanel panel;
    private JLabel l1,l2,l3,l4,l5,l6,question,image,winsLabel1,winsLabel2,totalPointsLabel1,totalPointsLabel2,l7;
    private JButton answer1,answer2,answer3,answer4;
    private JButton answer1_1,answer2_1,answer3_1,answer4_1,answer1_2,answer2_2,answer3_2,answer4_2;
    private int j=0,Flag1=0,Flag2=0,firstCorrect=0,wins1=0,wins2=0;
    private double totalPoints1,totalPoints2;
    private String[] randomAnswers;
    private Box box;

    /**
     Κατασκευαστής της κλάσης roundTypeThermometer.
     …
     @param Player1 το όνομα του παίκτη 1
     @param Player2 το όνομα του παίκτη 2
     @param i ο αριθμός του τρέχοντος γύρου
     @param r το συνολικό πλήθος γύρων
     @param points1 οι συνολικοί πόντοι του παίκτη 1
     @param points2 οι συνολικοί πόντοι του παίκτη 2
     */
    public roundTypeThermometer(String Player1, String Player2,int i,int r,double points1,double points2) {

        totalPoints1=points1;
        totalPoints2=points2;

        setTitle("Buzz! Quiz World (Single Player)");
        setSize(600, 600);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panel = new JPanel();
        l1 = new JLabel("Round " + (i + 1) + "/" + r + ". Round Type “Thermometer“");
        l2 = new JLabel("The first player to answer 5 questions correctly gets 5000 points.");
        l7 = new JLabel("(A question might apear twice)");
        l3 = new JLabel("Player 1 presses 1,2,3,4 for A,B,C,D.");
        l4 = new JLabel("Player 2 presses 6,7,8,9 for A,B,C,D.");
        l5 = new JLabel();
        l6 = new JLabel();
        question = new JLabel();
        image = new JLabel(new ImageIcon(""));
        answer1 = new JButton();
        answer2 = new JButton();
        answer3 = new JButton();
        answer4 = new JButton();
        answer1_1 = new JButton();
        answer1_2 = new JButton();
        answer2_1 = new JButton();
        answer2_2 = new JButton();
        answer3_1 = new JButton();
        answer3_2 = new JButton();
        answer4_1 = new JButton();
        answer4_2 = new JButton();
        winsLabel1 = new JLabel(Player1 + " wins: " + String.valueOf(wins1));
        winsLabel2 = new JLabel(Player2 + " wins: " + String.valueOf(wins2));
        totalPointsLabel1 = new JLabel(Player1 + " total points: " + totalPoints1);
        totalPointsLabel2 = new JLabel(Player2 + " total points: " + totalPoints2);

        box = Box.createVerticalBox();

        box.add(l1);
        box.add(l2);
        box.add(l7);
        box.add(l3);
        box.add(l4);
        box.add(question);
        box.add(image);
        box.add(answer1);
        box.add(answer2);
        box.add(answer3);
        box.add(answer4);
        box.add(l5);
        box.add(l6);
        box.add(winsLabel1);
        box.add(winsLabel2);
        box.add(totalPointsLabel1);
        box.add(totalPointsLabel2);
        panel.add(box);

        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);

        answer1_1.setEnabled(true);
        answer1_2.setEnabled(true);
        answer2_1.setEnabled(true);
        answer2_2.setEnabled(true);
        answer3_1.setEnabled(true);
        answer3_2.setEnabled(true);
        answer4_1.setEnabled(true);
        answer4_2.setEnabled(true);

        add(answer1_1);
        add(answer1_2);
        add(answer2_1);
        add(answer2_2);
        add(answer3_1);
        add(answer3_2);
        add(answer3_2);
        add(answer4_1);
        add(answer4_2);

        add(panel);

        playQuestion(j);

        Action action1_1 = new AbstractAction("1") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag1==0){
                    Flag1 = 1;
                    if (randomAnswers[0].equals("A")) {
                        if (firstCorrect==0) {
                            firstCorrect=1;
                            wins1++;
                        }
                        else{
                            wins1++;;
                        }
                        winsLabel1.setText(Player1 + " wins: " + String.valueOf(wins1));
                    }
                    l6.setText(Player1 + " Answer First");
                    if (Flag2 == 1) {
                        if (wins1<5 && wins2<5) {
                            firstCorrect=0;
                            j++;
                            playQuestion(j);
                        }
                        else {
                            setVisible(false);
                            if(wins1==5){
                                totalPoints1+=5000;
                            }
                            if(wins2==5){
                                totalPoints2+=5000;
                            }
                            game.game2(Player1, Player2, i + 1, r, totalPoints1,totalPoints2);
                        }
                    }
                }
            }
        };

        action1_1.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("1"));
        answer1_1.setAction(action1_1);
        answer1_1.getActionMap().put("setOneAction", action1_1);
        answer1_1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action1_1.getValue(Action.ACCELERATOR_KEY), "setOneAction");

        Action action2_1 = new AbstractAction("2") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag1==0){
                    Flag1 = 1;
                    if (randomAnswers[0].equals("B")) {
                        if (firstCorrect==0) {
                            firstCorrect=1;
                            wins1++;
                        }
                        else{
                            wins1++;;
                        }
                        winsLabel1.setText(Player1 + " wins: " + String.valueOf(wins1));
                    }
                    l6.setText(Player1 + " Answer First");
                    if (Flag2 == 1) {
                        if (wins1<5 && wins2<5) {
                            firstCorrect=0;
                            j++;
                            playQuestion(j);
                        }
                        else {
                            setVisible(false);
                            if(wins1==5){
                                totalPoints1+=5000;
                            }
                            if(wins2==5){
                                totalPoints2+=5000;
                            }
                            game.game2(Player1, Player2, i + 1, r, totalPoints1,totalPoints2);
                        }
                    }
                }
            }
        };

        action2_1.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("2"));
        answer2_1.setAction(action2_1);
        answer2_1.getActionMap().put("setOneAction", action2_1);
        answer2_1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action2_1.getValue(Action.ACCELERATOR_KEY), "setOneAction");

        Action action3_1 = new AbstractAction("3") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag1==0){
                    Flag1 = 1;
                    if (randomAnswers[0].equals("C")) {
                        if (firstCorrect==0) {
                            firstCorrect=1;
                            wins1++;
                        }
                        else{
                            wins1++;;
                        }
                        winsLabel1.setText(Player1 + " wins: " + String.valueOf(wins1));
                    }
                    l6.setText(Player1 + " Answer First");
                    if (Flag2 == 1) {
                        if (wins1<5 && wins2<5) {
                            firstCorrect=0;
                            j++;
                            playQuestion(j);
                        }
                        else {
                            setVisible(false);
                            if(wins1==5){
                                totalPoints1+=5000;
                            }
                            if(wins2==5){
                                totalPoints2+=5000;
                            }
                            game.game2(Player1, Player2, i + 1, r, totalPoints1,totalPoints2);
                        }
                    }
                }
            }
        };

        action3_1.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("3"));
        answer3_1.setAction(action3_1);
        answer3_1.getActionMap().put("setOneAction", action3_1);
        answer3_1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action3_1.getValue(Action.ACCELERATOR_KEY), "setOneAction");

        Action action4_1 = new AbstractAction("4") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag1==0){
                    Flag1 = 1;
                    if (randomAnswers[0].equals("D")) {
                        if (firstCorrect==0) {
                            firstCorrect=1;
                            wins1++;
                        }
                        else{
                            wins1++;;
                        }
                        winsLabel1.setText(Player1 + " wins: " + String.valueOf(wins1));
                    }
                    l6.setText(Player1 + " Answer First");
                    if (Flag2 == 1) {
                        if (wins1<5 && wins2<5) {
                            firstCorrect=0;
                            j++;
                            playQuestion(j);
                        }
                        else {
                            setVisible(false);
                            if(wins1==5){
                                totalPoints1+=5000;
                            }
                            if(wins2==5){
                                totalPoints2+=5000;
                            }
                            game.game2(Player1, Player2, i + 1, r, totalPoints1,totalPoints2);
                        }
                    }
                }
            }
        };

        action4_1.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("4"));
        answer4_1.setAction(action4_1);
        answer4_1.getActionMap().put("setOneAction", action4_1);
        answer4_1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action4_1.getValue(Action.ACCELERATOR_KEY), "setOneAction");

        Action action1_2 = new AbstractAction("6") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag2==0){
                    Flag2 = 1;
                    if (randomAnswers[0].equals("A")) {
                        if (firstCorrect==0) {
                            firstCorrect=1;
                            wins2++;
                        }
                        else{
                            wins2++;;
                        }
                        winsLabel2.setText(Player2 + " wins: " + String.valueOf(wins2));
                    }
                    l6.setText(Player2 + " Answer First");
                    if (Flag1 == 1) {
                        if (wins1<5 && wins2<5) {
                            firstCorrect=0;
                            j++;
                            playQuestion(j);
                        }
                        else {
                            setVisible(false);
                            if(wins1==5){
                                totalPoints1+=5000;
                            }
                            if(wins2==5){
                                totalPoints2+=5000;
                            }
                            game.game2(Player1, Player2, i + 1, r, totalPoints1,totalPoints2);
                        }
                    }
                }
            }
        };

        action1_2.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("6"));
        answer1_2.setAction(action1_2);
        answer1_2.getActionMap().put("setOneAction", action1_2);
        answer1_2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action1_2.getValue(Action.ACCELERATOR_KEY), "setOneAction");

        Action action2_2 = new AbstractAction("7") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag2==0){
                    Flag2 = 1;
                    if (randomAnswers[0].equals("B")) {
                        if (firstCorrect==0) {
                            firstCorrect=1;
                            wins2++;
                        }
                        else{
                            wins2++;;
                        }
                        winsLabel2.setText(Player2 + " wins: " + String.valueOf(wins2));
                    }
                    l6.setText(Player2 + " Answer First");
                    if (Flag1 == 1) {
                        if (wins1<5 && wins2<5) {
                            firstCorrect=0;
                            j++;
                            playQuestion(j);
                        }
                        else {
                            setVisible(false);
                            if(wins1==5){
                                totalPoints1+=5000;
                            }
                            if(wins2==5){
                                totalPoints2+=5000;
                            }
                            game.game2(Player1, Player2, i + 1, r, totalPoints1,totalPoints2);
                        }
                    }
                }
            }
        };

        action2_2.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("7"));
        answer2_2.setAction(action2_2);
        answer2_2.getActionMap().put("setOneAction", action2_2);
        answer2_2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action2_2.getValue(Action.ACCELERATOR_KEY), "setOneAction");

        Action action3_2 = new AbstractAction("8") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag2==0){
                    Flag2 = 1;
                    if (randomAnswers[0].equals("C")) {
                        if (firstCorrect==0) {
                            firstCorrect=1;
                            wins2++;
                        }
                        else{
                            wins2++;;
                        }
                        winsLabel2.setText(Player2 + " wins: " + String.valueOf(wins2));
                    }
                    l6.setText(Player2 + " Answer First");
                    if (Flag1 == 1) {
                        if (wins1<5 && wins2<5) {
                            firstCorrect=0;
                            j++;
                            playQuestion(j);
                        }
                        else {
                            setVisible(false);
                            if(wins1==5){
                                totalPoints1+=5000;
                            }
                            if(wins2==5){
                                totalPoints2+=5000;
                            }
                            game.game2(Player1, Player2, i + 1, r, totalPoints1,totalPoints2);
                        }
                    }
                }
            }
        };

        action3_2.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("8"));
        answer3_2.setAction(action3_2);
        answer3_2.getActionMap().put("setOneAction", action3_2);
        answer3_2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action3_2.getValue(Action.ACCELERATOR_KEY), "setOneAction");

        Action action4_2 = new AbstractAction("9") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag2==0){
                    Flag2 = 1;
                    if (randomAnswers[0].equals("D")) {
                        if (firstCorrect==0) {
                            firstCorrect=1;
                            wins2++;
                        }
                        else{
                            wins2++;;
                        }
                        winsLabel2.setText(Player2 + " wins: " + String.valueOf(wins2));
                    }
                    l6.setText(Player2 + " Answer First");
                    if (Flag1 == 1) {
                        if (wins1<5 && wins2<5) {
                            firstCorrect=0;
                            j++;
                            playQuestion(j);
                        }
                        else {
                            setVisible(false);
                            if(wins1==5){
                                totalPoints1+=5000;
                            }
                            if(wins2==5){
                                totalPoints2+=5000;
                            }
                            game.game2(Player1, Player2, i + 1, r, totalPoints1,totalPoints2);
                        }
                    }
                }
            }
        };

        action4_2.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("9"));
        answer4_2.setAction(action4_2);
        answer4_2.getActionMap().put("setOneAction", action4_2);
        answer4_2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                (KeyStroke) action4_2.getValue(Action.ACCELERATOR_KEY), "setOneAction");

    }

    /**
     Κλάση τυχαίας επιλογής και εμφάνισης ερώτησης.
     …
     @param i ο αριθμός του τρέχοντος γύρου
     */
    public void playQuestion(int i)
    {
        Flag1=0;
        Flag2=0;
        Question[][] questions = loadQuestions.loadQuestions(1,1);
        l5.setText("Question " + (i + 1) + ":");
        l6.setText("");
        question.setText(questions[0][0].getQuestion());
        if(questions[0][0].getImage().equals("none")==false){
            image.setIcon(new ImageIcon("Pictures\\"+questions[0][0].getImage()));
            image.setVisible(true);
        }
        else{
            image.setIcon(new ImageIcon(""));
            image.setVisible(false);
        }
        randomAnswers = questions[0][0].getRandomAnswers();
        answer1.setText(randomAnswers[1]);
        answer2.setText(randomAnswers[2]);
        answer3.setText(randomAnswers[3]);
        answer4.setText(randomAnswers[4]);
    }
}
