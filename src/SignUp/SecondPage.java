
package SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPage extends JFrame implements ActionListener {

    long formNumber;

    JTextField pantxt, aadhaartxt;

    JComboBox<String> religiontxt, categorytxt, incometxt,
            educationtxt, occupationtxt;

    JRadioButton yes, no;
    ButtonGroup seniorGroup;

    JButton previous, clear, next;

    SignupData data;

    // Constructor for shared SignupData
    SecondPage(SignupData data) {

        this.data = data;
        this.formNumber = data.formNumber;

        initializePage();

        loadData();

        setVisible(true);
    }

    // Constructor for testing with a form number
    SecondPage(long formNumber) {
        this(new SignupData(formNumber));
    }

    // Save Page 2 data
    private void saveData() {

        data.religion = religiontxt.getSelectedIndex() == 0
                ? null : religiontxt.getSelectedItem().toString();

        data.category = categorytxt.getSelectedIndex() == 0
                ? null : categorytxt.getSelectedItem().toString();

        data.annualIncome = incometxt.getSelectedIndex() == 0
                ? null : incometxt.getSelectedItem().toString();

        data.education = educationtxt.getSelectedIndex() == 0
                ? null : educationtxt.getSelectedItem().toString();

        data.occupation = occupationtxt.getSelectedIndex() == 0
                ? null : occupationtxt.getSelectedItem().toString();

        data.panNumber = pantxt.getText().trim();

        data.aadhaarNumber = aadhaartxt.getText().trim();

        data.seniorCitizen = yes.isSelected();
    }

    // Restore previously saved Page 2 data
    private void loadData() {

        if (data.religion != null)
            religiontxt.setSelectedItem(data.religion);

        if (data.category != null)
            categorytxt.setSelectedItem(data.category);

        if (data.annualIncome != null)
            incometxt.setSelectedItem(data.annualIncome);

        if (data.education != null)
            educationtxt.setSelectedItem(data.education);

        if (data.occupation != null)
            occupationtxt.setSelectedItem(data.occupation);

        pantxt.setText(
                data.panNumber == null ? "" : data.panNumber
        );

        aadhaartxt.setText(
                data.aadhaarNumber == null ? "" : data.aadhaarNumber
        );

        if (data.seniorCitizen)
            yes.setSelected(true);
        else
            no.setSelected(true);
    }

    // Initialize Page 2 UI
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
        JLabel formno = new JLabel("FORM NUMBER: " + formNumber);
        formno.setFont(new Font("Times New Roman", Font.BOLD, 30));
        formno.setBounds(135, 15, 450, 40);
        formno.setForeground(Color.BLACK);
        add(formno);

        // Page Heading
        JLabel heading = new JLabel("Page 2: Additional Details");
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        heading.setBounds(155, 55, 400, 40);
        heading.setForeground(Color.BLACK);
        add(heading);

        // Religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        religion.setBounds(80, 120, 180, 40);
        religion.setForeground(Color.BLACK);
        add(religion);

        String religions[] = {
                "Select Religion",
                "Hindu",
                "Muslim",
                "Christian",
                "Sikh",
                "Buddhist",
                "Jain",
                "Other"
        };

        religiontxt = new JComboBox<>(religions);
        religiontxt.setBounds(270, 125, 250, 25);
        religiontxt.setFont(new Font("Arial", Font.PLAIN, 16));
        add(religiontxt);

        // Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        category.setBounds(80, 180, 180, 40);
        category.setForeground(Color.BLACK);
        add(category);

        String categories[] = {
                "Select Category",
                "General",
                "OBC",
                "SC",
                "ST",
                "Other"
        };

        categorytxt = new JComboBox<>(categories);
        categorytxt.setBounds(270, 185, 250, 25);
        categorytxt.setFont(new Font("Arial", Font.PLAIN, 16));
        add(categorytxt);

        // Annual Income
        JLabel income = new JLabel("Annual Income:");
        income.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        income.setBounds(80, 240, 180, 40);
        income.setForeground(Color.BLACK);
        add(income);

        String incomes[] = {
                "Select Income",
                "Below 1 Lakh",
                "1 - 3 Lakh",
                "3 - 5 Lakh",
                "5 - 10 Lakh",
                "Above 10 Lakh"
        };

        incometxt = new JComboBox<>(incomes);
        incometxt.setBounds(270, 245, 250, 25);
        incometxt.setFont(new Font("Arial", Font.PLAIN, 16));
        add(incometxt);

        // Educational Qualification
        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        education.setBounds(80, 300, 180, 40);
        education.setForeground(Color.BLACK);
        add(education);

        String educations[] = {
                "Select Education",
                "Below 10th",
                "10th Pass",
                "12th Pass",
                "Graduate",
                "Postgraduate",
                "Doctorate",
                "Other"
        };

        educationtxt = new JComboBox<>(educations);
        educationtxt.setBounds(270, 305, 250, 25);
        educationtxt.setFont(new Font("Arial", Font.PLAIN, 16));
        add(educationtxt);

        // Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        occupation.setBounds(80, 360, 180, 40);
        occupation.setForeground(Color.BLACK);
        add(occupation);

        String occupations[] = {
                "Select Occupation",
                "Student",
                "Salaried",
                "Self Employed",
                "Business",
                "Government Employee",
                "Retired",
                "Unemployed",
                "Other"
        };

        occupationtxt = new JComboBox<>(occupations);
        occupationtxt.setBounds(270, 365, 250, 25);
        occupationtxt.setFont(new Font("Arial", Font.PLAIN, 16));
        add(occupationtxt);

        // PAN Number
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        pan.setBounds(80, 420, 180, 40);
        pan.setForeground(Color.BLACK);
        add(pan);

        pantxt = new JTextField();
        pantxt.setBounds(270, 425, 250, 25);
        pantxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(pantxt);

        // Aadhaar Number
        JLabel aadhaar = new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        aadhaar.setBounds(80, 480, 180, 40);
        aadhaar.setForeground(Color.BLACK);
        add(aadhaar);

        aadhaartxt = new JTextField();
        aadhaartxt.setBounds(270, 485, 250, 25);
        aadhaartxt.setFont(new Font("Arial", Font.PLAIN, 18));
        add(aadhaartxt);

        // Senior Citizen
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        senior.setBounds(80, 540, 180, 40);
        senior.setForeground(Color.BLACK);
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setBounds(270, 545, 70, 25);
        yes.setBackground(new Color(173, 216, 230));
        yes.setFont(new Font("Arial", Font.PLAIN, 16));
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(350, 545, 70, 25);
        no.setBackground(new Color(173, 216, 230));
        no.setFont(new Font("Arial", Font.PLAIN, 16));
        add(no);

        seniorGroup = new ButtonGroup();
        seniorGroup.add(yes);
        seniorGroup.add(no);

        // NEXT Button
        next = new JButton("NEXT");
        next.setBounds(400, 610, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setFocusPainted(false);
        next.addActionListener(this);
        add(next);

        // CLEAR Button
        clear = new JButton("CLEAR");
        clear.setBounds(250, 610, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setFocusPainted(false);
        clear.addActionListener(this);
        add(clear);

        // PREVIOUS Button
        previous = new JButton("PREVIOUS");
        previous.setBounds(100, 610, 120, 30);
        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.WHITE);
        previous.setFont(new Font("Arial", Font.BOLD, 14));
        previous.setFocusPainted(false);
        previous.addActionListener(this);
        add(previous);

        // Frame Settings
        getContentPane().setBackground(new Color(173, 216, 230));

        setSize(600, 700);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {

            religiontxt.setSelectedIndex(0);
            categorytxt.setSelectedIndex(0);
            incometxt.setSelectedIndex(0);
            educationtxt.setSelectedIndex(0);
            occupationtxt.setSelectedIndex(0);

            pantxt.setText("");
            aadhaartxt.setText("");

            seniorGroup.clearSelection();
            saveData();

        } else if (e.getSource() == previous) {

            saveData();

            new FirstPage(data);

            dispose();

        } else if (e.getSource() == next) {

            saveData();

            new ThirdPage(data);

            dispose();
        }
    }

    public static void main(String args[]) {
        new SecondPage(1001);
    }
}
