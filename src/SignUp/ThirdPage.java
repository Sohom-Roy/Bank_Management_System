
package SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class ThirdPage extends JFrame implements ActionListener {

    long formNumber;

    JComboBox<String> accountType, relationship;
    JTextField deposit, nomineeName, nomineeAddress;

    JRadioButton atmYes, atmNo;
    JRadioButton internetYes, internetNo;
    JRadioButton mobileYes, mobileNo;
    JRadioButton smsYes, smsNo;
    JRadioButton chequeYes, chequeNo;

    ButtonGroup atmGroup, internetGroup, mobileGroup, smsGroup, chequeGroup;

    JDateChooser nomineeDob;

    JButton previous, clear, next;

    ThirdPage(long formNumber) {

        this.formNumber = formNumber;

        setLayout(null);

        // Logo
        ImageIcon I1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/logo.png")
        );

        Image I2 = I1.getImage().getScaledInstance(
                100, 100, Image.SCALE_DEFAULT
        );

        ImageIcon I3 = new ImageIcon(I2);

        JLabel label = new JLabel(I3);
        label.setBounds(10, 8, 100, 100);
        add(label);

        // Form Number
        JLabel formno = new JLabel("FORM NUMBER: " + formNumber);
        formno.setFont(new Font("Times New Roman", Font.BOLD, 30));
        formno.setBounds(135, 15, 450, 40);
        formno.setForeground(Color.BLACK);
        add(formno);

        // Page Heading
        JLabel heading = new JLabel("Page 3: Account Details");
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        heading.setBounds(155, 55, 400, 40);
        heading.setForeground(Color.BLACK);
        add(heading);

        // Account Type
        JLabel account = new JLabel("Account Type:");
        account.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        account.setBounds(80, 120, 180, 30);
        account.setForeground(Color.BLACK);
        add(account);

        String accounts[] = {
                "Select Account Type",
                "Savings Account",
                "Current Account",
                "Student Savings Account"
        };

        accountType = new JComboBox<>(accounts);
        accountType.setBounds(270, 120, 250, 25);
        accountType.setFont(new Font("Arial", Font.PLAIN, 16));
        add(accountType);

        // Initial Deposit
        JLabel initialDeposit = new JLabel("Initial Deposit:");
        initialDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        initialDeposit.setBounds(80, 165, 180, 30);
        initialDeposit.setForeground(Color.BLACK);
        add(initialDeposit);

        deposit = new JTextField();
        deposit.setBounds(270, 165, 250, 25);
        deposit.setFont(new Font("Arial", Font.PLAIN, 16));
        add(deposit);

        // ATM / Debit Card
        JLabel atm = new JLabel("ATM / Debit Card:");
        atm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        atm.setBounds(80, 210, 180, 30);
        atm.setForeground(Color.BLACK);
        add(atm);

        atmYes = new JRadioButton("Yes");
        atmYes.setBounds(270, 210, 70, 25);
        atmYes.setBackground(new Color(173, 216, 230));
        atmYes.setFont(new Font("Arial", Font.PLAIN, 16));
        add(atmYes);

        atmNo = new JRadioButton("No");
        atmNo.setBounds(350, 210, 70, 25);
        atmNo.setBackground(new Color(173, 216, 230));
        atmNo.setFont(new Font("Arial", Font.PLAIN, 16));
        add(atmNo);

        atmGroup = new ButtonGroup();
        atmGroup.add(atmYes);
        atmGroup.add(atmNo);

        // Internet Banking
        JLabel internet = new JLabel("Internet Banking:");
        internet.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        internet.setBounds(80, 255, 180, 30);
        internet.setForeground(Color.BLACK);
        add(internet);

        internetYes = new JRadioButton("Yes");
        internetYes.setBounds(270, 255, 70, 25);
        internetYes.setBackground(new Color(173, 216, 230));
        internetYes.setFont(new Font("Arial", Font.PLAIN, 16));
        add(internetYes);

        internetNo = new JRadioButton("No");
        internetNo.setBounds(350, 255, 70, 25);
        internetNo.setBackground(new Color(173, 216, 230));
        internetNo.setFont(new Font("Arial", Font.PLAIN, 16));
        add(internetNo);

        internetGroup = new ButtonGroup();
        internetGroup.add(internetYes);
        internetGroup.add(internetNo);

        // Mobile Banking
        JLabel mobile = new JLabel("Mobile Banking:");
        mobile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        mobile.setBounds(80, 300, 180, 30);
        mobile.setForeground(Color.BLACK);
        add(mobile);

        mobileYes = new JRadioButton("Yes");
        mobileYes.setBounds(270, 300, 70, 25);
        mobileYes.setBackground(new Color(173, 216, 230));
        mobileYes.setFont(new Font("Arial", Font.PLAIN, 16));
        add(mobileYes);

        mobileNo = new JRadioButton("No");
        mobileNo.setBounds(350, 300, 70, 25);
        mobileNo.setBackground(new Color(173, 216, 230));
        mobileNo.setFont(new Font("Arial", Font.PLAIN, 16));
        add(mobileNo);

        mobileGroup = new ButtonGroup();
        mobileGroup.add(mobileYes);
        mobileGroup.add(mobileNo);

        // SMS Alerts
        JLabel sms = new JLabel("SMS Alerts:");
        sms.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        sms.setBounds(80, 345, 180, 30);
        sms.setForeground(Color.BLACK);
        add(sms);

        smsYes = new JRadioButton("Yes");
        smsYes.setBounds(270, 345, 70, 25);
        smsYes.setBackground(new Color(173, 216, 230));
        smsYes.setFont(new Font("Arial", Font.PLAIN, 16));
        add(smsYes);

        smsNo = new JRadioButton("No");
        smsNo.setBounds(350, 345, 70, 25);
        smsNo.setBackground(new Color(173, 216, 230));
        smsNo.setFont(new Font("Arial", Font.PLAIN, 16));
        add(smsNo);

        smsGroup = new ButtonGroup();
        smsGroup.add(smsYes);
        smsGroup.add(smsNo);

        // Cheque Book
        JLabel cheque = new JLabel("Cheque Book:");
        cheque.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        cheque.setBounds(80, 390, 180, 30);
        cheque.setForeground(Color.BLACK);
        add(cheque);

        chequeYes = new JRadioButton("Yes");
        chequeYes.setBounds(270, 390, 70, 25);
        chequeYes.setBackground(new Color(173, 216, 230));
        chequeYes.setFont(new Font("Arial", Font.PLAIN, 16));
        add(chequeYes);

        chequeNo = new JRadioButton("No");
        chequeNo.setBounds(350, 390, 70, 25);
        chequeNo.setBackground(new Color(173, 216, 230));
        chequeNo.setFont(new Font("Arial", Font.PLAIN, 16));
        add(chequeNo);

        chequeGroup = new ButtonGroup();
        chequeGroup.add(chequeYes);
        chequeGroup.add(chequeNo);

        // Nominee Name
        JLabel nominee = new JLabel("Nominee Name:");
        nominee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        nominee.setBounds(80, 435, 180, 30);
        nominee.setForeground(Color.BLACK);
        add(nominee);

        nomineeName = new JTextField();
        nomineeName.setBounds(270, 435, 250, 25);
        nomineeName.setFont(new Font("Arial", Font.PLAIN, 16));
        add(nomineeName);

        // Nominee Relationship
        JLabel relation = new JLabel("Nominee Relation:");
        relation.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        relation.setBounds(80, 480, 190, 30);
        relation.setForeground(Color.BLACK);
        add(relation);

        String relationships[] = {
                "Select Relationship",
                "Father",
                "Mother",
                "Spouse",
                "Son",
                "Daughter",
                "Brother",
                "Sister",
                "Other"
        };

        relationship = new JComboBox<>(relationships);
        relationship.setBounds(270, 480, 250, 25);
        relationship.setFont(new Font("Arial", Font.PLAIN, 16));
        add(relationship);

        // Nominee Date of Birth
        JLabel dob = new JLabel("Nominee DOB:");
        dob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        dob.setBounds(80, 525, 180, 30);
        dob.setForeground(Color.BLACK);
        add(dob);

        nomineeDob = new JDateChooser();
        nomineeDob.setBounds(270, 525, 250, 25);
        nomineeDob.setDateFormatString("dd-MM-yyyy");
        nomineeDob.setMaxSelectableDate(new Date());
        add(nomineeDob);

        // Nominee Address
        JLabel address = new JLabel("Nominee Address:");
        address.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        address.setBounds(80, 570, 180, 30);
        address.setForeground(Color.BLACK);
        add(address);

        nomineeAddress = new JTextField();
        nomineeAddress.setBounds(270, 570, 250, 25);
        nomineeAddress.setFont(new Font("Arial", Font.PLAIN, 16));
        add(nomineeAddress);

        // NEXT Button
        next = new JButton("NEXT");
        next.setBounds(400, 630, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setFocusPainted(false);
        next.addActionListener(this);
        add(next);

        // CLEAR Button
        clear = new JButton("CLEAR");
        clear.setBounds(250, 630, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setFocusPainted(false);
        clear.addActionListener(this);
        add(clear);

        // PREVIOUS Button
        previous = new JButton("PREVIOUS");
        previous.setBounds(100, 630, 120, 30);
        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.WHITE);
        previous.setFont(new Font("Arial", Font.BOLD, 14));
        previous.setFocusPainted(false);
        previous.addActionListener(this);
        add(previous);

        // Frame Settings
        getContentPane().setBackground(new Color(173, 216, 230));

        setSize(600, 720);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {

            accountType.setSelectedIndex(0);
            deposit.setText("");

            atmGroup.clearSelection();
            internetGroup.clearSelection();
            mobileGroup.clearSelection();
            smsGroup.clearSelection();
            chequeGroup.clearSelection();

            nomineeName.setText("");
            relationship.setSelectedIndex(0);
            nomineeDob.setDate(null);
            nomineeAddress.setText("");

        } else if (e.getSource() == previous) {

            new SecondPage(formNumber);
            dispose();

        } else if (e.getSource() == next) {

            new FourthPage(formNumber);
            dispose();

        }
    }

    public static void main(String args[]) {
        new ThirdPage(1001);
    }
}
