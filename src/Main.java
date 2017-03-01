import javax.swing.*;
import java.awt.*;


public class Main {


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame frame = new MyFrame();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });


/*        try{
            System.out.println("------------------");

             String textClar = "Algorithm for encryptation 123";
            //AES
            //k - key for encryptation String k = "1a25s8fe5dsg65ad";
            System.out.println("Text for encryptation: "+textClar);
            byte[] enc = AES.encrypt(textClar.getBytes(), k.getBytes());
            System.out.println("Text encrypted with algorithm AES: "+new String(enc));

            byte[] dec = AES.decrypt(enc, k.getBytes());
            System.out.println("Text decrypted with algorithm AES: "+new String(dec));
            System.out.println("------------------");
            SessionIdentifierGenerator a = new SessionIdentifierGenerator();
             String key = a.nextSessionId();
            System.out.println(key);

        }catch(Exception e){
            e.printStackTrace();
        }*/
    }
}
