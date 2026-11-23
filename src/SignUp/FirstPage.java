package SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import Pages.Welcome;

import Pages.Welcome;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class FirstPage extends JFrame implements ActionListener {

    JTextField nametxt, fathernametxt, emailtxt, addresstxt,citytxt, pintxt, districttxt;
    JRadioButton male, female, other, married, unmarried;
    JComboBox<String> statetxt;
    JButton clear, exit, next;
    ButtonGroup genderGroup, maritalGroup;
    JDateChooser dateChooser;
    SignupData data;

    // Form Number
    long formNumber;

    // Constructor for generating a new form number
    public FirstPage() {
        this(new SignupData(Math.abs(new Random().nextLong() % 9000L) + 1000L));
    }

    public FirstPage(long formNumber) {
        this(new SignupData(formNumber));
    }

    public FirstPage(SignupData data) {
        this.data = data;
        this.formNumber = data.formNumber;
        initializePage();
        loadData();
        setVisible(true);
    }
    private void saveData() {

        data.name = nametxt.getText().trim();

        data.fatherName = fathernametxt.getText().trim();

        data.dateOfBirth = dateChooser.getDate();

        data.gender = male.isSelected() ? "Male"
                : female.isSelected() ? "Female"
                : other.isSelected() ? "Other" : null;

        data.email = emailtxt.getText().trim();

        data.maritalStatus = married.isSelected() ? "Married"
                : unmarried.isSelected() ? "Unmarried" : null;

        data.address = addresstxt.getText().trim();

        data.city = citytxt.getText().trim();

        data.district = districttxt.getText().trim();

        data.postalCode = pintxt.getText().trim();

        data.state = statetxt.getSelectedIndex() == 0
                ? null
                : statetxt.getSelectedItem().toString();
    }

    private void loadData() {

        nametxt.setText(data.name == null ? "" : data.name);

        fathernametxt.setText(
                data.fatherName == null ? "" : data.fatherName
        );

        dateChooser.setDate(data.dateOfBirth);

        if ("Male".equals(data.gender)) {
            male.setSelected(true);
        } else if ("Female".equals(data.gender)) {
            female.setSelected(true);
        } else if ("Other".equals(data.gender)) {
            other.setSelected(true);
        }

        emailtxt.setText(data.email == null ? "" : data.email);

        if ("Married".equals(data.maritalStatus)) {
            married.setSelected(true);
        } else if ("Unmarried".equals(data.maritalStatus)) {
            unmarried.setSelected(true);
        }

        addresstxt.setText(data.address == null ? "" : data.address);

        citytxt.setText(data.city == null ? "" : data.city);

        districttxt.setText(data.district == null ? "" : data.district);

        pintxt.setText(data.postalCode == null ? "" : data.postalCode);

        if (data.state != null) {
            statetxt.setSelectedItem(data.state);
        }
    }
    // Initialize First Page
    private void initializePage() {

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
        JLabel fromno = new JLabel("FORM NUMBER: " + formNumber);
        fromno.setFont(new Font("Times New Roman", Font.BOLD, 30));
        fromno.setBounds(135, 15, 450, 40);
        fromno.setForeground(Color.BLACK);
        add(fromno);

        // Page Heading
        JLabel personaldetails = new JLabel("Page 1:Personal Details");
        personaldetails.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        personaldetails.setBounds(155, 55, 400, 40);
        personaldetails.setForeground(Color.BLACK);
        add(personaldetails);

        // Name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        name.setBounds(80, 100, 150, 40);
        name.setForeground(Color.BLACK);
        add(name);

        nametxt = new JTextField();
        nametxt.setBounds(270, 105, 250, 25);
        nametxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(nametxt);

        // Father's Name
        JLabel fathername = new JLabel("Father's Name:");
        fathername.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        fathername.setBounds(80, 140, 150, 40);
        fathername.setForeground(Color.BLACK);
        add(fathername);

        fathernametxt = new JTextField();
        fathernametxt.setBounds(270, 145, 250, 25);
        fathernametxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(fathernametxt);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        dob.setBounds(80, 180, 150, 40);
        dob.setForeground(Color.BLACK);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(270, 185, 250, 25);
        dateChooser.setDateFormatString("dd-MM-yyyy");
        dateChooser.setMaxSelectableDate(new Date());
        add(dateChooser);

        // Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        gender.setBounds(80, 220, 150, 40);
        gender.setForeground(Color.BLACK);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(270, 225, 80, 25);
        male.setBackground(new Color(173, 216, 230));
        male.setFont(new Font("Arial", Font.PLAIN, 16));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(355, 225, 100, 25);
        female.setBackground(new Color(173, 216, 230));
        female.setFont(new Font("Arial", Font.PLAIN, 16));
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(455, 225, 80, 25);
        other.setBackground(new Color(173, 216, 230));
        other.setFont(new Font("Arial", Font.PLAIN, 16));
        add(other);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        // Email
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        email.setBounds(80, 260, 150, 40);
        email.setForeground(Color.BLACK);
        add(email);

        emailtxt = new JTextField();
        emailtxt.setBounds(270, 265, 250, 25);
        emailtxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(emailtxt);

        // Marital Status
        JLabel maritalstatus = new JLabel("Marital Status:");
        maritalstatus.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        maritalstatus.setBounds(80, 300, 150, 40);
        maritalstatus.setForeground(Color.BLACK);
        add(maritalstatus);

        married = new JRadioButton("Married");
        married.setBounds(270, 305, 100, 25);
        married.setBackground(new Color(173, 216, 230));
        married.setFont(new Font("Arial", Font.PLAIN, 16));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(380, 305, 120, 25);
        unmarried.setBackground(new Color(173, 216, 230));
        unmarried.setFont(new Font("Arial", Font.PLAIN, 16));
        add(unmarried);

        maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        // Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        address.setBounds(80, 340, 150, 40);
        address.setForeground(Color.BLACK);
        add(address);

        addresstxt = new JTextField();
        addresstxt.setBounds(270, 345, 250, 25);
        addresstxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(addresstxt);

        // City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        city.setBounds(80, 380, 150, 40);
        city.setForeground(Color.BLACK);
        add(city);

        citytxt = new JTextField();
        citytxt.setBounds(270, 385, 250, 25);
        citytxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(citytxt);

        // District
        JLabel district = new JLabel("District:");
        district.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        district.setBounds(80, 420, 150, 40);
        district.setForeground(Color.BLACK);
        add(district);

        districttxt = new JTextField();
        districttxt.setBounds(270, 425, 250, 25);
        districttxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(districttxt);

        // Postal Code
        JLabel pin = new JLabel("Postal Code:");
        pin.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        pin.setBounds(80, 460, 150, 40);
        pin.setForeground(Color.BLACK);
        add(pin);

        pintxt = new JTextField();
        pintxt.setBounds(270, 465, 250, 25);
        pintxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(pintxt);

        // State / UT
        JLabel state = new JLabel("State/UT:");
        state.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        state.setBounds(80, 500, 150, 40);
        state.setForeground(Color.BLACK);
        add(state);

        String states[] = {
                "Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chhattisgarh",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttar Pradesh",
                "Uttarakhand",
                "West Bengal",
                "Andaman and Nicobar Islands",
                "Chandigarh",
                "Dadra and Nagar Haveli and Daman and Diu",
                "Delhi (NCT)",
                "Jammu and Kashmir",
                "Ladakh",
                "Lakshadweep",
                "Puducherry"
        };

        statetxt = new JComboBox<>(states);
        statetxt.setBounds(270, 505, 250, 25);
        statetxt.setFont(new Font("Arial", Font.PLAIN, 16));
        statetxt.insertItemAt("Select State / UT", 0);
        statetxt.setSelectedIndex(0);
        add(statetxt);

        // NEXT Button
        next = new JButton("NEXT");
        next.setBounds(400, 570, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setFocusPainted(false);
        next.addActionListener(this);
        add(next);

        // CLEAR Button
        clear = new JButton("CLEAR");
        clear.setBounds(250, 570, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setFocusPainted(false);
        clear.addActionListener(this);
        add(clear);

        // EXIT Button
        exit = new JButton("BACK");
        exit.setBounds(100, 570, 100, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Arial", Font.BOLD, 14));
        exit.setFocusPainted(false);
        exit.addActionListener(this);
        add(exit);

        // Frame Settings
        getContentPane().setBackground(new Color(173, 216, 230));

        setSize(600, 700);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {

            nametxt.setText("");
            fathernametxt.setText("");
            emailtxt.setText("");
            addresstxt.setText("");
            citytxt.setText("");
            districttxt.setText("");
            pintxt.setText("");

            genderGroup.clearSelection();
            maritalGroup.clearSelection();

            statetxt.setSelectedIndex(0);
            dateChooser.setDate(null);
            saveData();

        } else if (e.getSource() == exit) {

            dispose();

            // Open Welcome Page
            new Welcome();

        } else if (e.getSource() == next) {
            saveData();
            new SecondPage(data);
            dispose();

        }
    }

    public static void main(String args[]) {
        new FirstPage();
    }
}
