package SignUp;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class ReviewPage extends JFrame {

    SignupData data;

    Color bgColor = new Color(173, 216, 230);

    public ReviewPage(SignupData data) {

        this.data = data;

        setTitle("Review Application");
        setSize(700, 780);
        setLocation(300, 10);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // =========================================
        // MAIN PANEL
        // =========================================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(bgColor);

        // =========================================
        // HEADER PANEL
        // =========================================

        JPanel headerPanel = new JPanel(null);
        headerPanel.setPreferredSize(new Dimension(700, 115));
        headerPanel.setBackground(bgColor);

        // Logo
        ImageIcon I1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/logo.png")
        );

        Image I2 = I1.getImage().getScaledInstance(
                100, 100, Image.SCALE_DEFAULT
        );

        ImageIcon I3 = new ImageIcon(I2);

        JLabel logo = new JLabel(I3);
        logo.setBounds(10, 8, 100, 100);
        headerPanel.add(logo);

        // Form Number
        JLabel formno = new JLabel(
                "FORM NUMBER: " + data.formNumber
        );

        formno.setFont(
                new Font("Times New Roman", Font.BOLD, 30)
        );

        formno.setBounds(200, 15, 450, 40);
        formno.setForeground(Color.BLACK);

        headerPanel.add(formno);

        // Heading
        JLabel heading = new JLabel("Review Your Application");

        heading.setFont(
                new Font("Times New Roman", Font.PLAIN, 24)
        );

        heading.setBounds(230, 55, 430, 40);
        heading.setForeground(Color.BLACK);

        headerPanel.add(heading);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // =========================================
        // REVIEW CONTENT PANEL
        // =========================================

        JPanel reviewPanel = new JPanel();

        reviewPanel.setLayout(
                new BoxLayout(reviewPanel, BoxLayout.Y_AXIS)
        );

        reviewPanel.setBackground(bgColor);

        reviewPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 60, 20, 60)
        );

        // =========================================
        // PAGE 1: PERSONAL DETAILS
        // =========================================

        addSection(reviewPanel, "PAGE 1: PERSONAL DETAILS");

        addRow(reviewPanel, "Name", data.name);
        addRow(reviewPanel, "Father Name", data.fatherName);
        addRow(reviewPanel, "Date of Birth", formatDate(data.dateOfBirth));
        addRow(reviewPanel, "Gender", data.gender);
        addRow(reviewPanel, "Email", data.email);
        addRow(reviewPanel, "Marital Status", data.maritalStatus);

        addRow(reviewPanel, "Address", data.address);
        addRow(reviewPanel, "City", data.city);
        addRow(reviewPanel, "District", data.district);
        addRow(reviewPanel, "Postal Code", data.postalCode);
        addRow(reviewPanel, "State", data.state);

        // =========================================
        // PAGE 2: ADDITIONAL DETAILS
        // =========================================

        addSection(reviewPanel, "PAGE 2: ADDITIONAL DETAILS");

        addRow(reviewPanel, "Religion", data.religion);
        addRow(reviewPanel, "Category", data.category);
        addRow(reviewPanel, "Annual Income", data.annualIncome);
        addRow(reviewPanel, "Education", data.education);
        addRow(reviewPanel, "Occupation", data.occupation);

        addRow(reviewPanel, "PAN Number", data.panNumber);
        addRow(reviewPanel, "Aadhaar Number", data.aadhaarNumber);

        addRow(reviewPanel, "Senior Citizen",
                yesNo(data.seniorCitizen));

        // =========================================
        // PAGE 3: ACCOUNT DETAILS
        // =========================================

        addSection(reviewPanel, "PAGE 3: ACCOUNT DETAILS");

        addRow(reviewPanel, "Account Type", data.accountType);
        addRow(reviewPanel, "Initial Deposit", data.initialDeposit);

        addRow(reviewPanel, "ATM Card", yesNo(data.atmCard));
        addRow(reviewPanel, "Internet Banking",
                yesNo(data.internetBanking));
        addRow(reviewPanel, "Mobile Banking",
                yesNo(data.mobileBanking));
        addRow(reviewPanel, "SMS Alert", yesNo(data.smsAlert));
        addRow(reviewPanel, "Cheque Book", yesNo(data.chequeBook));

        // =========================================
        // NOMINEE DETAILS
        // =========================================

        addSection(reviewPanel, "NOMINEE DETAILS");

        addRow(reviewPanel, "Nominee Name", data.nomineeName);
        addRow(reviewPanel, "Nominee Relation", data.nomineeRelation);
        addRow(reviewPanel, "Nominee DOB", formatDate(data.nomineeDob));
        addRow(reviewPanel, "Nominee Address", data.nomineeAddress);

        // =========================================
        // PAGE 4: DOCUMENT DETAILS
        // =========================================

        addSection(reviewPanel, "PAGE 4: DOCUMENT DETAILS");

        addRow(reviewPanel, "PAN Document", fileName(data.panFile));
        addRow(reviewPanel, "Aadhaar Document", fileName(data.aadhaarFile));
        addRow(reviewPanel, "Photograph", fileName(data.photographFile));
        addRow(reviewPanel, "Signature", fileName(data.signatureFile));

        addRow(reviewPanel, "Declaration Accepted",
                yesNo(data.declarationAccepted));

        // =========================================
        // SCROLL PANE
        // =========================================

        JScrollPane scrollPane = new JScrollPane(reviewPanel);

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.setBorder(null);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // =========================================
        // BOTTOM BUTTON PANEL
        // =========================================

        JPanel buttonPanel = new JPanel();

        buttonPanel.setBackground(bgColor);

        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 0, 15, 0)
        );

        JButton submitButton = new JButton("SUBMIT APPLICATION");

        submitButton.setPreferredSize(
                new Dimension(220, 35)
        );

        styleButton(submitButton);

        submitButton.addActionListener(
                e -> submitApplication()
        );

        buttonPanel.add(submitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    // =========================================
    // SECTION HEADING
    // =========================================

    private void addSection(JPanel panel, String title) {

        JLabel sectionLabel = new JLabel(title);

        sectionLabel.setFont(
                new Font("Times New Roman", Font.BOLD, 22)
        );

        sectionLabel.setForeground(Color.BLACK);

        sectionLabel.setHorizontalAlignment(JLabel.CENTER);

        sectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        sectionLabel.setBorder(
                BorderFactory.createEmptyBorder(20, 0, 12, 0)
        );

        panel.add(sectionLabel);
    }

    // =========================================
    // DATA ROW - CENTER ALIGNED
    // =========================================

    private void addRow(JPanel panel, String label, String value) {

        JPanel row = new JPanel(new GridLayout(1, 2, 10, 0));

        row.setBackground(bgColor);

        row.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 35)
        );

        row.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Label
        JLabel nameLabel = new JLabel(label + ":");

        nameLabel.setFont(
                new Font("Times New Roman", Font.BOLD, 18)
        );

        nameLabel.setForeground(Color.BLACK);

        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        // Value
        JLabel valueLabel = new JLabel(
                value == null || value.trim().isEmpty()
                        ? "Not Provided"
                        : value
        );

        valueLabel.setFont(
                new Font("Times New Roman", Font.PLAIN, 18)
        );

        valueLabel.setForeground(Color.BLACK);

        valueLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add components
        row.add(nameLabel);
        row.add(valueLabel);

        panel.add(row);
    }

    // =========================================
    // BUTTON STYLING
    // =========================================

    private void styleButton(JButton button) {

        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);

        button.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
    }

    // =========================================
    // DATE FORMAT
    // =========================================

    private String formatDate(java.util.Date date) {

        if (date == null) {
            return "Not Provided";
        }

        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    // =========================================
    // BOOLEAN FORMAT
    // =========================================

    private String yesNo(boolean value) {

        return value ? "Yes" : "No";
    }

    // =========================================
    // FILE NAME
    // =========================================

    private String fileName(java.io.File file) {

        return file == null
                ? "Not Uploaded"
                : file.getName();
    }

    // =========================================
    // SUBMIT APPLICATION
    // =========================================

    private void submitApplication() {

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to submit your application?",
                "Confirm Submission",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            SubmitHandler.handleSubmit(this, data);
        }
    }
}