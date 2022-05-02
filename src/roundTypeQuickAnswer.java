import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Κλάση που αναπαριστά έναν γύρο τύπου "Γρήγορη Απάντηση".
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class roundTypeQuickAnswer extends JFrame {

    private JPanel panel;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,question,pointsLabel1,pointsLabel2,image;
    private JButton answer1_1,answer2_1,answer3_1,answer4_1,answer1_2,answer2_2,answer3_2,answer4_2,answer1,answer2,answer3,answer4;
    private int j=0,Flag1=0,Flag2=0;
    private double points1,points2;
    private String[] randomAnswers;
    private Box box;

    /**
     Κατασκευαστής της κλάσης roundTypeQuickAnswer.
     …
     @param Player1 το όνομα του παίκτη 1
     @param Player2 το όνομα του παίκτη 2
     @param i ο αριθμός του τρέχοντος γύρου
     @param r το συνολικό πλήθος γύρων
     @param q το πλήθος ερωτήσεων ανά γύρο
     @param questions πίνακας με τις ερωτήσεις του γύρου
     @param totalPoints1 οι συνολικοί πόντοι του παίκτη 1
     @param totalPoints2 οι συνολικοί πόντοι του παίκτη 2
     */
    public roundTypeQuickAnswer(String Player1, String Player2,int i,int r, int q, Question[] questions,double totalPoints1,double totalPoints2) {

        points1=totalPoints1;
        points2=totalPoints2;

        setTitle("Buzz! Quiz World (Single Player)");
        setSize(600, 600);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panel = new JPanel();
        l1 = new JLabel("Round " + (i + 1) + "/" + r + ". Round Type “Quick Answer“");
        l2 = new JLabel("The first player to answer correctly gets 1000 points and the second 500 points.");
        l3 = new JLabel("Player 1 presses 1,2,3,4 for A,B,C,D.");
        l4 = new JLabel("Player 2 presses 6,7,8,9 for A,B,C,D.");
        l5 = new JLabel();
        l6 = new JLabel();
        answer1= new JButton();
        answer2= new JButton();
        answer3= new JButton();
        answer4= new JButton();
        question = new JLabel();
        image = new JLabel(new ImageIcon(""));
        answer1_1 = new JButton();
        answer1_2 = new JButton();
        answer2_1 = new JButton();
        answer2_2 = new JButton();
        answer3_1 = new JButton();
        answer3_2 = new JButton();
        answer4_1 = new JButton();
        answer4_2 = new JButton();
        pointsLabel1 = new JLabel(Player1 + " Points: " + String.valueOf(points1));
        pointsLabel2 = new JLabel(Player2 + " Points: " + String.valueOf(points2));


        box = Box.createVerticalBox();

        box.add(l1);
        box.add(l2);
        box.add(l3);
        box.add(l4);
        box.add(l5);
        box.add(question);
        box.add(image);
        box.add(answer1);
        box.add(answer2);
        box.add(answer3);
        box.add(answer4);
        box.add(l6);
        box.add(pointsLabel1);
        box.add(pointsLabel2);

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

        panel.add(box);

        add(panel);

        playQuestion(j,questions);

        Timer timer = new Timer(100, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            }
        });
        timer.start();

        Action action1_1 = new AbstractAction("1") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag1==0){
                    Flag1 = 1;
                    if (randomAnswers[0].equals("A")) {
                        if (timer.isRunning()) {
                            timer.stop();
                            points1 += 1000;
                        }
                        else {
                            points1 += 500;
                        }
                    }
                    l6.setText(Player1 + " Answered First");
                    pointsLabel1.setText(Player1 + " Points: " + String.valueOf(points1));
                    if (Flag2 == 1) {
                        j++;
                        if (j < q) {
                                timer.start();
                                playQuestion(j, questions);
                        }
                        else {
                                setVisible(false);
                                game.game2(Player1, Player2, i + 1, r, points1,points2);
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
                        if (timer.isRunning()) {
                            timer.stop();
                            points1 += 1000;
                        }
                        else {
                            points1 += 500;
                        }
                    }
                    l6.setText(Player1 + " Answered First");
                    pointsLabel1.setText(Player1 + " Points: " + String.valueOf(points1));
                    if (Flag2 == 1) {
                        j++;
                        if (j < q) {
                            timer.start();
                            playQuestion(j, questions);
                        }
                        else {
                            setVisible(false);
                            game.game2(Player1, Player2, i + 1, r, points1,points2);
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
                        if (timer.isRunning()) {
                            timer.stop();
                            points1 += 1000;
                        }
                        else {
                            points1 += 500;
                        }
                    }
                    l6.setText(Player1 + " Answered First");
                    pointsLabel1.setText(Player1 + " Points: " + String.valueOf(points1));
                    if (Flag2 == 1) {
                        j++;
                        if (j < q) {
                            timer.start();
                            playQuestion(j, questions);
                        }
                        else {
                            setVisible(false);
                            game.game2(Player1, Player2, i + 1, r, points1,points2);
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
                if(Flag1==0) {
                    Flag1 = 1;
                    if (randomAnswers[0].equals("D")) {
                        if (timer.isRunning()) {
                            timer.stop();
                            points1 += 1000;
                        }
                        else {
                            points1 += 500;
                        }
                    }
                    l6.setText(Player1 + " Answered First");
                    pointsLabel1.setText(Player1 + " Points: " + String.valueOf(points1));
                    if (Flag2 == 1) {
                        j++;
                        if (j < q) {
                            timer.start();
                            playQuestion(j, questions);
                        }
                        else {
                            setVisible(false);
                            game.game2(Player1, Player2, i + 1, r, points1, points2);
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
                        if (timer.isRunning()) {
                            timer.stop();
                            points2 += 1000;
                        }
                        else {
                            points2 += 500;
                        }
                    }
                    l6.setText(Player2 + " Answered First");
                    pointsLabel2.setText(Player2 + " Points: " + String.valueOf(points2));
                    if (Flag1 == 1) {
                        j++;
                        if (j < q) {
                            timer.start();
                            playQuestion(j, questions);
                        } else {
                            setVisible(false);
                            game.game2(Player1, Player2, i + 1, r, points1, points2);
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
                        if (timer.isRunning()) {
                            timer.stop();
                            points2 += 1000;
                        }
                        else {
                            points2 += 500;
                        }
                    }
                    l6.setText(Player2 + " Answered First");
                    pointsLabel2.setText(Player2 + " Points: " + String.valueOf(points2));
                    if (Flag1 == 1) {
                        j++;
                        if (j < q) {
                            timer.start();
                            playQuestion(j, questions);
                        }
                        else {
                            setVisible(false);
                            game.game2(Player1, Player2, i + 1, r, points1, points2);
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
                        if (timer.isRunning()) {
                            timer.stop();
                            points2 += 1000;
                        }
                        else {
                            points2 += 500;
                        }
                    }
                    l6.setText(Player2 + " Answered First");
                    pointsLabel2.setText(Player2 + " Points: " + String.valueOf(points2));
                    if (Flag1 == 1) {
                        j++;
                        if (j < q) {
                            timer.start();
                            playQuestion(j, questions);
                        } else {
                            setVisible(false);
                            game.game2(Player1, Player2, i + 1, r, points1, points2);
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
                if(Flag2==0) {
                    Flag2 = 1;
                    if (randomAnswers[0].equals("D")) {
                        if (timer.isRunning()) {
                            timer.stop();
                            points2 += 1000;
                        }
                        else {
                            points2 += 500;
                        }
                    }
                    l6.setText(Player2 + " Answered First");
                    pointsLabel2.setText(Player2 + " Points: " + String.valueOf(points2));
                    if (Flag1 == 1) {
                        j++;
                        if (j < q) {
                            timer.start();
                            playQuestion(j, questions);
                        }
                        else {
                            setVisible(false);
                            game.game2(Player1, Player2, i + 1, r, points1, points2);
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
     Κλάση εμφάνισης ερώτησης.
     …
     @param i ο αριθμός του τρέχοντος γύρου
     @param questions πίνακας με τις ερωτήσεις του γύρου
     */
    public void playQuestion(int i,Question[] questions)
    {
        Flag1=0;
        Flag2=0;
        l5.setText("Question " + (i + 1) + ":");
        l6.setText("");
        question.setText(questions[i].getQuestion());
        if(questions[i].getImage().equals("none")==false){
            image.setIcon(new ImageIcon("Pictures\\"+questions[i].getImage()));
            image.setVisible(true);
        }
        else{
            image.setIcon(new ImageIcon(""));
            image.setVisible(false);
        }
        randomAnswers = questions[i].getRandomAnswers();
        answer1.setText(randomAnswers[1]);
        answer2.setText(randomAnswers[2]);
        answer3.setText(randomAnswers[3]);
        answer4.setText(randomAnswers[4]);
    }
}