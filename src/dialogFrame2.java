import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Κλάση που αναπαριστά το παράθυρο διαλόγου με τους παίκτες για την εισαγωγή ονομάτων και πλήθους γύρων για το παιχνίδι δύο παικτών.
 …
 @author Στεργιανάς Αχιλλέας
 @author Καρανταγλής Νικόλαος
 …
 @version 2.0
 …
 */
public class dialogFrame2 extends JFrame {

    private JPanel panel;
    private JLabel enterName1Label,enterName2Label,selectRoundsLabel,roundsLabel;
    private JSlider roundsSlider;
    private JTextField name1,name2;
    private JButton okButton,cancelButton;

    /**
     Ο κατασκευαστής της dialogFrame2.
     */
    public dialogFrame2() {
        setTitle("Buzz!");
        setSize(230, 225);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        enterName1Label = new JLabel("Enter Player 1 name:");
        name1 = new JTextField(16);
        enterName2Label = new JLabel("Enter Player 2 name:");
        name2 = new JTextField(16);
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

        name1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (name1.getText().equals("") || name2.getText().equals("")){
                    okButton.setEnabled(false);
                }
                else {
                    okButton.setEnabled(true);
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (name1.getText().equals("") || name2.getText().equals("")){
                    okButton.setEnabled(false);
                }
                else {
                    okButton.setEnabled(true);
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (name1.getText().equals("") || name2.getText().equals("")){
                    okButton.setEnabled(false);
                }
                else {
                    okButton.setEnabled(true);
                }
            }
        });
        name2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (name1.getText().equals("") || name2.getText().equals("")){
                    okButton.setEnabled(false);
                }
                else {
                    okButton.setEnabled(true);
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (name1.getText().equals("") || name2.getText().equals("")){
                    okButton.setEnabled(false);
                }
                else {
                    okButton.setEnabled(true);
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (name1.getText().equals("") || name2.getText().equals("")){
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
                game.game2(name1.getText(),name2.getText(),0,roundsSlider.getValue(),0,0);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new startFrame();
            }
        });

        panel.add(enterName1Label);
        panel.add(name1);
        panel.add(enterName2Label);
        panel.add(name2);
        panel.add(selectRoundsLabel);
        panel.add(roundsLabel);
        panel.add(roundsSlider);
        panel.add(okButton);
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
    }
}