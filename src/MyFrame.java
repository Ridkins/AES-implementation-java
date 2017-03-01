import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame {

    public MyFrame(){

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(13, 1));

        labelFieldForKey = new JLabel("Enter your key to encrypt: ");
        buttonPanel.add(labelFieldForKey);

        //Create JTextField
        textFieldForKey = new JTextField(40);
        buttonPanel.add(textFieldForKey);

        Icon keyIcon = new ImageIcon("src\\key.png");
        generateKeyButton = new JButton("Generate key", keyIcon);
        generateKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SessionIdentifierGenerator a = new SessionIdentifierGenerator();
                key = a.nextSessionId();
                textFieldForKey.setText(key);

            }
        });
        buttonPanel.add(generateKeyButton);

        labelFieldForEncrypt = new JLabel("Enter text to encrypt:");
        buttonPanel.add(labelFieldForEncrypt);

        textFieldForEncrypt = new JTextField(40);
        buttonPanel.add(textFieldForEncrypt);

        Icon encIcon = new ImageIcon("src\\enc.png");
        encryptButton = new JButton("Encrypt", encIcon);
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String k = textFieldForKey.getText();
                String textClar = textFieldForEncrypt.getText();
                enc = AES.encrypt(textClar.getBytes(), k.getBytes());
                textFieldForDecrypt.setText(new String(enc));

            }
        });
        buttonPanel.add(encryptButton);

        labelFieldForDecrypt = new JLabel("Enter text to decrypt:");
        buttonPanel.add(labelFieldForDecrypt);

        textFieldForDecrypt = new JTextField(40);
        buttonPanel.add(textFieldForDecrypt);

        Icon decIcon = new ImageIcon("src\\dec.png");
        decryptButton = new JButton("Decrypt", decIcon);
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String k = textFieldForKey.getText();
                dec = AES.decrypt(enc, k.getBytes());
                decryptedValue.setText(new String(dec));

            }
        });
        buttonPanel.add(decryptButton);

        labelDecryptedValue = new JLabel("Decrypted Value:");
        buttonPanel.add(labelDecryptedValue);

        decryptedValue = new JTextField();
        buttonPanel.add(decryptedValue);

        Icon claIcon = new ImageIcon("src\\cla.png");
        clearAllButton = new JButton("Clear all fields", claIcon);
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textFieldForKey.setText("");
                textFieldForEncrypt.setText("");
                textFieldForDecrypt.setText("");
                decryptedValue.setText("");

            }
        });
        buttonPanel.add(clearAllButton);

        Icon closeIcon = new ImageIcon("src\\close.png");
        closeButton = new JButton("Close", closeIcon);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                dispose();

            }
        });
        buttonPanel.add(closeButton);

       add(buttonPanel, BorderLayout.CENTER);

        // Frame properties
        setTitle("Rijndael algorithm. K");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setIcon();
    }

     //Method helps to set icon to the frame
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mei.png")));
    }

    //VARIABLES
    private JButton generateKeyButton;
    private JButton encryptButton;
    private JButton decryptButton;
    private JButton closeButton;
    private JButton clearAllButton;
    private JPanel buttonPanel;
    private JLabel labelFieldForKey;
    private JLabel labelFieldForEncrypt;
    private JLabel labelFieldForDecrypt;
    private JLabel labelDecryptedValue;
    private JTextField textFieldForKey;
    private JTextField textFieldForEncrypt;
    private JTextField textFieldForDecrypt;
    String key = "";
    byte[] enc;
    byte[] dec;
    private JTextField decryptedValue;

    public static final int DEFAULT_WIDTH = 700;
    public static final int DEFAULT_HEIGHT = 400;

}
