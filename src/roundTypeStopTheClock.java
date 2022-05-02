import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.util.TimerTask;
import java.util.Timer;

/**
 Κλάση που αναπαριστά το παράθυρο γύρου τύπου "Σταμάτησε το χρονόμετρο".
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class roundTypeStopTheClock extends JFrame {

    private JPanel panel;
    private JLabel l1,l2,l3,l4,l5,question,pointsLabel,pointsLabel1,pointsLabel2,image;
    private JButton answer1,answer2,answer3,answer4,answer1_1,answer2_1,answer3_1,answer4_1,answer1_2,answer2_2,answer3_2,answer4_2;
    private int j=0,Flag1=0,Flag2=0;
    private String[] randomAnswers;
    private double totalPoints,totalPoints1,totalPoints2;
    private long timeLeft;
    private Instant start,finish,now;
    private JLabel Time_Label;
    private Timer timer;
    private Box box;

    /**
     Κατασκευαστής της κλάσης roundTypeStopTheClock για 1 παίκτη.
     …
     @param PlayerName το όνομα του παίκτη
     @param i ο αριθμός του τρέχοντος γύρου
     @param r το συνολικό πλήθος γύρων
     @param q το πλήθος ερωτήσεων ανά γύρο
     @param questions πίνακας με τις ερωτήσεις του γύρου
     @param points οι συνολικοί πόντοι του παίκτη
     */
    public roundTypeStopTheClock(String PlayerName,int i,int r, int q, Question[] questions,double points) {

        totalPoints=points;

        setTitle("Buzz! Quiz World (Single Player)");
        setSize(600, 600);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panel = new JPanel();
        l1 = new JLabel("Round " + (i + 1) + "/" + r + ". Round Type “Stop The Clock“");
        l2 = new JLabel("You have 5 seconds to answer. You get 0.2 points for each millisecond left on the clock.");
        l3 = new JLabel();
        l4 = new JLabel("Milliseconds Left");
        l5 = new JLabel();
        question = new JLabel();
        image = new JLabel(new ImageIcon(""));
        answer1 = new JButton();
        answer2 = new JButton();
        answer3 = new JButton();
        answer4 = new JButton();
        Time_Label = new JLabel();
        pointsLabel = new JLabel("Total Points: " + String.valueOf(totalPoints));
        timer = new Timer();

        box = Box.createVerticalBox();

        box.add(l1);
        box.add(l2);
        box.add(l3);
        box.add(question);
        box.add(image);
        box.add(answer1);
        box.add(answer2);
        box.add(answer3);
        box.add(answer4);
        box.add(l4);
        box.add(Time_Label);
        box.add(pointsLabel);

        panel.add(box);
        add(panel);

        playQuestion(j,questions);

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                now=Instant.now();
                Time_Label.setText(String.valueOf(5000 - Duration.between(start, now).toMillis()));
                if (5000 - Duration.between(start, now).toMillis()<0)
                {
                    Time_Label.setText("Time's up! You won't get any points.");
                }
            }
        }, 0, 1);

        answer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finish = Instant.now();
                timeLeft = 5000 - Duration.between(start, finish).toMillis();
                if(timeLeft<0){
                    timeLeft=0;
                }
                if(randomAnswers[0].equals("A")){
                    totalPoints += timeLeft*0.2;
                    totalPoints = Math.round(totalPoints * 100.0) / 100.0;
                    pointsLabel.setText("Total Points: " + String.format("%.2f",totalPoints));
                }
                j++;
                if(j<q){
                    playQuestion(j,questions);

                }
                else{
                    timer.cancel();
                    setVisible(false);
                    game.game1(PlayerName,i+1,r,totalPoints);
                }
            }
        });
        answer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finish = Instant.now();
                timeLeft = 5000 - Duration.between(start, finish).toMillis();if(timeLeft<0){
                    timeLeft=0;
                }
                if(randomAnswers[0].equals("B")){
                    totalPoints += timeLeft*0.2;
                    totalPoints = Math.round(totalPoints * 100.0) / 100.0;
                    pointsLabel.setText("Total Points: " + String.format("%.2f",totalPoints));
                }
                j++;
                if(j<q){
                    playQuestion(j,questions);
                }
                else{
                    timer.cancel();
                    setVisible(false);
                    game.game1(PlayerName,i+1,r,totalPoints);
                }
            }
        });
        answer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finish = Instant.now();
                timeLeft = 5000 - Duration.between(start, finish).toMillis();if(timeLeft<0){
                    timeLeft=0;
                }
                if(randomAnswers[0].equals("C")){
                    totalPoints += timeLeft*0.2;
                    totalPoints = Math.round(totalPoints * 100.0) / 100.0;
                    pointsLabel.setText("Total Points: " + String.format("%.2f",totalPoints));
                }
                j++;
                if(j<q){
                    playQuestion(j,questions);
                }
                else{
                    timer.cancel();
                    setVisible(false);
                    game.game1(PlayerName,i+1,r,totalPoints);
                }
            }
        });
        answer4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finish = Instant.now();
                timeLeft = 5000 - Duration.between(start, finish).toMillis();if(timeLeft<0){
                    timeLeft=0;
                }
                if(randomAnswers[0].equals("D")){
                    totalPoints += timeLeft*0.2;
                    totalPoints = Math.round(totalPoints * 100.0) / 100.0;
                    pointsLabel.setText("Total Points: " + String.format("%.2f",totalPoints));
                }
                j++;
                if(j<q){
                    playQuestion(j,questions);
                }
                else{
                    timer.cancel();
                    setVisible(false);
                    game.game1(PlayerName,i+1,r,totalPoints);
                }
            }
        });
    }

    /**
     Κατασκευαστής της κλάσης roundTypeStopTheClock για 2 παίκτες.
     …
     @param Player1 το όνομα του παίκτη 1
     @param Player2 το όνομα του παίκτη 2
     @param i ο αριθμός του τρέχοντος γύρου
     @param r το συνολικό πλήθος γύρων
     @param q το πλήθος ερωτήσεων ανά γύρο
     @param questions πίνακας με τις ερωτήσεις του γύρου
     @param points1 οι συνολικοί πόντοι του παίκτη 1
     @param points2 οι συνολικοί πόντοι του παίκτη 2
     */
    public roundTypeStopTheClock(String Player1,String Player2,int i,int r, int q, Question[] questions,double points1,double points2) {

        totalPoints1=points1;
        totalPoints2=points2;

        setTitle("Buzz! Quiz World (Double Player)");
        setSize(600, 600);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panel = new JPanel();
        l1 = new JLabel("Round " + (i + 1) + "/" + r + ". Round Type “Stop The Clock“");
        l2 = new JLabel("You have 5 seconds to answer. You get 0.2 points for each millisecond left on the clock.");
        l3 = new JLabel();
        l4 = new JLabel("Milliseconds Left");
        question = new JLabel();
        image = new JLabel(new ImageIcon(""));
        answer1 = new JButton();
        answer2 = new JButton();
        answer3 = new JButton();
        answer4 = new JButton();
        Time_Label = new JLabel();
        l5 = new JLabel("");
        pointsLabel1 = new JLabel(Player1+" Points: " + String.valueOf(totalPoints1));
        pointsLabel2 = new JLabel(Player2+" Points: " + String.valueOf(totalPoints2));
        timer = new Timer();

        box = Box.createVerticalBox();

        box.add(l1);
        box.add(l2);
        box.add(l3);
        box.add(question);
        box.add(image);
        box.add(answer1);
        box.add(answer2);
        box.add(answer3);
        box.add(answer4);
        box.add(l4);
        box.add(Time_Label);
        box.add(l5);
        box.add(pointsLabel1);
        box.add(pointsLabel2);

        answer1_1 = new JButton();
        answer1_2 = new JButton();
        answer2_1 = new JButton();
        answer2_2 = new JButton();
        answer3_1 = new JButton();
        answer3_2 = new JButton();
        answer4_1 = new JButton();
        answer4_2 = new JButton();

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

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                now=Instant.now();
                Time_Label.setText(String.valueOf(5000 - Duration.between(start, now).toMillis()));
                if (5000 - Duration.between(start, now).toMillis()<0)
                {
                    Time_Label.setText("Time's up! You won't get any points.");
                }
            }
        }, 0, 1);

        Action action1_1 = new AbstractAction("1") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Flag1==0) {
                    Flag1 = 1;
                    finish = Instant.now();
                    timeLeft = 5000 - Duration.between(start, finish).toMillis();
                    if (timeLeft < 0) {
                        timeLeft = 0;
                    }
                    if (randomAnswers[0].equals("A")) {
                        totalPoints1 += timeLeft * 0.2;
                        totalPoints1 = Math.round(totalPoints1 * 100.0) / 100.0;
                        pointsLabel1.setText(Player1 + " Points: " + String.format("%.2f", totalPoints1));
                    }
                    l5.setText(Player1+" Answered");
                    if (Flag2==1) {
                        j++;
                        if (j < q) {
                            playQuestion(j, questions);
                        } else {
                            timer.cancel();
                            setVisible(false);
                            game.game2(Player1,Player2, i + 1, r, totalPoints1,totalPoints2);
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
                if(Flag1==0) {
                    Flag1 = 1;
                    finish = Instant.now();
                    timeLeft = 5000 - Duration.between(start, finish).toMillis();
                    if (timeLeft < 0) {
                        timeLeft = 0;
                    }
                    if (randomAnswers[0].equals("B")) {
                        totalPoints1 += timeLeft * 0.2;
                        totalPoints1 = Math.round(totalPoints1 * 100.0) / 100.0;
                        pointsLabel1.setText(Player1 + " Points: " + String.format("%.2f", totalPoints1));
                    }
                    l5.setText(Player1+" Answered");
                    if (Flag2==1) {
                        j++;
                        if (j < q) {
                            playQuestion(j, questions);
                        } else {
                            timer.cancel();
                            setVisible(false);
                            game.game2(Player1,Player2, i + 1, r, totalPoints1,totalPoints2);
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
                if(Flag1==0) {
                    Flag1 = 1;
                    finish = Instant.now();
                    timeLeft = 5000 - Duration.between(start, finish).toMillis();
                    if (timeLeft < 0) {
                        timeLeft = 0;
                    }
                    if (randomAnswers[0].equals("C")) {
                        totalPoints1 += timeLeft * 0.2;
                        totalPoints1 = Math.round(totalPoints1 * 100.0) / 100.0;
                        pointsLabel1.setText(Player1 + " Points: " + String.format("%.2f", totalPoints1));
                    }
                    l5.setText(Player1+" Answered");
                    if (Flag2==1) {
                        j++;
                        if (j < q) {
                            playQuestion(j, questions);
                        } else {
                            timer.cancel();
                            setVisible(false);
                            game.game2(Player1,Player2, i + 1, r, totalPoints1,totalPoints2);
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
                    finish = Instant.now();
                    timeLeft = 5000 - Duration.between(start, finish).toMillis();
                    if (timeLeft < 0) {
                        timeLeft = 0;
                    }
                    if (randomAnswers[0].equals("D")) {
                        totalPoints1 += timeLeft * 0.2;
                        totalPoints1 = Math.round(totalPoints1 * 100.0) / 100.0;
                        pointsLabel1.setText(Player1 + " Points: " + String.format("%.2f", totalPoints1));
                    }
                    l5.setText(Player1+" Answered");
                    if (Flag2==1) {
                        j++;
                        if (j < q) {
                            playQuestion(j, questions);
                        } else {
                            timer.cancel();
                            setVisible(false);
                            game.game2(Player1,Player2, i + 1, r, totalPoints1,totalPoints2);
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
                if(Flag2==0) {
                    Flag2 = 1;
                    finish = Instant.now();
                    timeLeft = 5000 - Duration.between(start, finish).toMillis();
                    if (timeLeft < 0) {
                        timeLeft = 0;
                    }
                    if (randomAnswers[0].equals("A")) {
                        totalPoints2 += timeLeft * 0.2;
                        totalPoints2 = Math.round(totalPoints2 * 100.0) / 100.0;
                        pointsLabel2.setText(Player1 + " Points: " + String.format("%.2f", totalPoints2));
                    }
                    l5.setText(Player2+" Answered");
                    if (Flag1==1) {
                        j++;
                        if (j < q) {
                            playQuestion(j, questions);
                        } else {
                            timer.cancel();
                            setVisible(false);
                            game.game2(Player1,Player2, i + 1, r, totalPoints1,totalPoints2);
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
                if(Flag2==0) {
                    Flag2 = 1;
                    finish = Instant.now();
                    timeLeft = 5000 - Duration.between(start, finish).toMillis();
                    if (timeLeft < 0) {
                        timeLeft = 0;
                    }
                    if (randomAnswers[0].equals("B")) {
                        totalPoints2 += timeLeft * 0.2;
                        totalPoints2 = Math.round(totalPoints2 * 100.0) / 100.0;
                        pointsLabel2.setText(Player1 + " Points: " + String.format("%.2f", totalPoints2));
                    }
                    l5.setText(Player2+" Answered");
                    if (Flag1==1) {
                        j++;
                        if (j < q) {
                            playQuestion(j, questions);
                        } else {
                            timer.cancel();
                            setVisible(false);
                            game.game2(Player1,Player2, i + 1, r, totalPoints1,totalPoints2);
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
                if(Flag2==0) {
                    Flag2 = 1;
                    finish = Instant.now();
                    timeLeft = 5000 - Duration.between(start, finish).toMillis();
                    if (timeLeft < 0) {
                        timeLeft = 0;
                    }
                    if (randomAnswers[0].equals("C")) {
                        totalPoints2 += timeLeft * 0.2;
                        totalPoints2 = Math.round(totalPoints2 * 100.0) / 100.0;
                        pointsLabel2.setText(Player1 + " Points: " + String.format("%.2f", totalPoints2));
                    }
                    l5.setText(Player2+" Answered");
                    if (Flag1==1) {
                        j++;
                        if (j < q) {
                            playQuestion(j, questions);
                        } else {
                            timer.cancel();
                            setVisible(false);
                            game.game2(Player1,Player2, i + 1, r, totalPoints1,totalPoints2);
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
                    finish = Instant.now();
                    timeLeft = 5000 - Duration.between(start, finish).toMillis();
                    if (timeLeft < 0) {
                        timeLeft = 0;
                    }
                    if (randomAnswers[0].equals("D")) {
                        totalPoints2 += timeLeft * 0.2;
                        totalPoints2 = Math.round(totalPoints2 * 100.0) / 100.0;
                        pointsLabel2.setText(Player1 + " Points: " + String.format("%.2f", totalPoints2));
                    }
                    l5.setText(Player2+" Answered");
                    if (Flag1==1) {
                        j++;
                        if (j < q) {
                            playQuestion(j, questions);
                        } else {
                            timer.cancel();
                            setVisible(false);
                            game.game2(Player1,Player2, i + 1, r, totalPoints1,totalPoints2);
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
        l3.setText("Question " + (i + 1) + ":");
        l5.setText("");
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
        start = Instant.now();
    }



}
