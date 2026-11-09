import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton signup,clear,signin;
    JTextField card_txt;
    JPasswordField pin_txt;
    Login(){

        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image I2 = I1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel label = new JLabel(I3);
        label.setBounds(70,10,100,100);
        add(label);

        getContentPane().setBackground(new Color(173, 216, 230));

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Times New Roman",Font.BOLD,45));
        text.setBounds(200,50,450,40);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel card = new JLabel("CARD NO:");
        card.setFont(new Font("Rale way",Font.BOLD,30));
        card.setBounds(130,160,160,40);
        card.setForeground(Color.BLACK);
        add(card);

        card_txt = new JTextField();
        card_txt.setBounds(300,165,250,30);
        card_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        add(card_txt);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Rale way",Font.BOLD,30));
        pin.setBounds(220,220,150,40);
        pin.setForeground(Color.BLACK);
        add(pin);

        pin_txt = new JPasswordField();
        pin_txt.setBounds(300,225,150,30);
        pin_txt.setEchoChar('*');
        pin_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        add(pin_txt);

        signin = new JButton("SIGN IN");
        signin.setBounds(300,300,120,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,120,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==clear){
             card_txt.setText("");
             pin_txt.setText("");
         } else if (e.getSource()==signin) {
             
         } else if (e.getSource()==signup) {
             
         }
    }

    public static void main(String args[]){
        new Login();
    }
}

