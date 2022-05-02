import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Κλάση που αναπαριστά το παράθυρο διαλόγου με τον παίκτη για την εισαγωγή ονόματος και πλήθους γύρων για το παιχνίδι ενός παίκτη.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class dialogFrame1 extends JFrame {

    private JPanel panel;
    private JLabel enterNameLabel,selectRoundsLabel,roundsLabel;
    private JTextField name;
    private JSlider roundsSlider;
    private JButton okButton,cancelButton;

    /**
     Ο κατασκευαστής της dialogFrame1.
     */
    public dialogFrame1() {
        setTitle("Buzz!");
        setSize(250, 180);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        enterNameLabel = new JLabel("Enter your name:");
        name = new JTextField(16);
        selectRoundsLabel = new JLabel("Select amount of rounds:");
        roundsLabel = new JLabel("6");
        roundsSlider = new JSlider(3,10);
        roundsSlider.setValue(6);
        roundsSlider.setPaintTicks(true);
        roundsSlider.setMajorTickSpacing(1);
        roundsSlider.setSnapToTicks(true);
        okButton = new JButton("OK");
        okButton.setEnabled(false);
        cancelButton = new JButton("Cancel");

        name.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (name.getText().equals("")){
                    okButton.setEnabled(false);
                }
                else {
                    okButton.setEnabled(true);
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (name.getText().equals("")){
                    okButton.setEnabled(false);
                }
                else {
                    okButton.setEnabled(true);
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (name.getText().equals("")){
                    okButton.setEnabled(false);
                }
                else {
                    okButton.setEnabled(true);
                }
            }
        });

        roundsSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                roundsLabel.setText(String.valueOf(roundsSlider.getValue()));
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                game.game1(name.getText(),0,roundsSlider.getValue(),0);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new startFrame();
            }
        });

        panel.add(enterNameLabel);
        panel.add(name);
        panel.add(selectRoundsLabel);
        panel.add(roundsLabel);
        panel.add(roundsSlider);
        panel.add(okButton);
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
    }
}