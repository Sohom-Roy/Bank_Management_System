package SignUp;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FourthPage extends JFrame implements ActionListener {

    long formNumber;

    SignupData data;

    JLabel panStatus, aadhaarStatus, photoStatus, signatureStatus;

    JButton panUpload, aadhaarUpload, photoUpload, signatureUpload;
    JButton previous, clear, submit;

    JCheckBox declaration;

    File panFile, aadhaarFile, photoFile, signatureFile;

    // Constructor using shared SignupData
    FourthPage(SignupData data) {

        this.data = data;
        this.formNumber = data.formNumber;

        initializePage();
        loadData();

        setVisible(true);
    }

    // Constructor for testing with only form number
    FourthPage(long formNumber) {
        this(new SignupData(formNumber));
    }

    // Initialize all UI components
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
        JLabel heading = new JLabel("Page 4: Documents & Declaration");
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        heading.setBounds(135, 55, 430, 40);
        heading.setForeground(Color.BLACK);
        add(heading);

        // PAN Card
        JLabel pan = new JLabel("PAN Card:");
        pan.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        pan.setBounds(80, 130, 180, 30);
        pan.setForeground(Color.BLACK);
        add(pan);

        panStatus = new JLabel("No file selected");
        panStatus.setFont(new Font("Arial", Font.PLAIN, 13));
        panStatus.setBounds(240, 130, 180, 30);
        panStatus.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(panStatus);

        panUpload = new JButton("UPLOAD");
        panUpload.setBounds(450, 130, 100, 30);
        styleButton(panUpload);
        panUpload.addActionListener(this);
        add(panUpload);

        // Aadhaar Card
        JLabel aadhaar = new JLabel("Aadhaar Card:");
        aadhaar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        aadhaar.setBounds(80, 200, 180, 30);
        aadhaar.setForeground(Color.BLACK);
        add(aadhaar);

        aadhaarStatus = new JLabel("No file selected");
        aadhaarStatus.setFont(new Font("Arial", Font.PLAIN, 13));
        aadhaarStatus.setBounds(240, 200, 180, 30);
        aadhaarStatus.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(aadhaarStatus);

        aadhaarUpload = new JButton("UPLOAD");
        aadhaarUpload.setBounds(450, 200, 100, 30);
        styleButton(aadhaarUpload);
        aadhaarUpload.addActionListener(this);
        add(aadhaarUpload);

        // Photograph
        JLabel photo = new JLabel("Photograph:");
        photo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        photo.setBounds(80, 270, 180, 30);
        photo.setForeground(Color.BLACK);
        add(photo);

        photoStatus = new JLabel("No file selected");
        photoStatus.setFont(new Font("Arial", Font.PLAIN, 13));
        photoStatus.setBounds(240, 270, 180, 30);
        photoStatus.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(photoStatus);

        photoUpload = new JButton("UPLOAD");
        photoUpload.setBounds(450, 270, 100, 30);
        styleButton(photoUpload);
        photoUpload.addActionListener(this);
        add(photoUpload);

        // Signature
        JLabel signature = new JLabel("Signature:");
        signature.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        signature.setBounds(80, 340, 180, 30);
        signature.setForeground(Color.BLACK);
        add(signature);

        signatureStatus = new JLabel("No file selected");
        signatureStatus.setFont(new Font("Arial", Font.PLAIN, 13));
        signatureStatus.setBounds(240, 340, 180, 30);
        signatureStatus.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(signatureStatus);

        signatureUpload = new JButton("UPLOAD");
        signatureUpload.setBounds(450, 340, 100, 30);
        styleButton(signatureUpload);
        signatureUpload.addActionListener(this);
        add(signatureUpload);

        // Declaration Heading
        JLabel declarationHeading = new JLabel("Declaration");
        declarationHeading.setFont(new Font("Times New Roman", Font.BOLD, 22));
        declarationHeading.setBounds(80, 410, 200, 30);
        declarationHeading.setForeground(Color.BLACK);
        add(declarationHeading);

        // Declaration Checkbox
        declaration = new JCheckBox(
                "<html>I hereby declare that the information provided by me "
                        + "is true and correct to the best of my knowledge. "
                        + "I agree to the terms and conditions of the bank.</html>"
        );

        declaration.setFont(new Font("Arial", Font.PLAIN, 14));
        declaration.setBounds(80, 450, 450, 70);
        declaration.setBackground(new Color(173, 216, 230));
        declaration.setFocusPainted(false);
        add(declaration);

        // PREVIOUS Button
        previous = new JButton("PREVIOUS");
        previous.setBounds(70, 570, 120, 30);
        styleButton(previous);
        previous.addActionListener(this);
        add(previous);

        // CLEAR Button
        clear = new JButton("CLEAR");
        clear.setBounds(225, 570, 100, 30);
        styleButton(clear);
        clear.addActionListener(this);
        add(clear);

        // SUBMIT Button
        submit = new JButton("REVIEW");
        submit.setBounds(370, 570, 120, 30);
        styleButton(submit);
        submit.addActionListener(this);
        add(submit);

        // Frame Settings
        getContentPane().setBackground(new Color(173, 216, 230));

        setSize(600, 680);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Common Button Styling
    private void styleButton(JButton button) {

        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
    }

    // Save Page 4 data into shared SignupData object
    private void saveData() {

        data.panFile = panFile;
        data.aadhaarFile = aadhaarFile;
        data.photographFile = photoFile;
        data.signatureFile = signatureFile;

        data.declarationAccepted = declaration.isSelected();
    }

    // Restore previously saved Page 4 data
    private void loadData() {

        panFile = data.panFile;
        aadhaarFile = data.aadhaarFile;
        photoFile = data.photographFile;
        signatureFile = data.signatureFile;

        panStatus.setText(
                panFile != null ? panFile.getName() : "No file selected"
        );

        aadhaarStatus.setText(
                aadhaarFile != null ? aadhaarFile.getName() : "No file selected"
        );

        photoStatus.setText(
                photoFile != null ? photoFile.getName() : "No file selected"
        );

        signatureStatus.setText(
                signatureFile != null ? signatureFile.getName() : "No file selected"
        );

        declaration.setSelected(data.declarationAccepted);
    }

    // File Selection Method
    private File chooseFile() {

        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Documents and Images (PDF, JPG, JPEG, PNG)",
                "pdf", "jpg", "jpeg", "png"
        );

        chooser.setFileFilter(filter);

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == panUpload) {

            File selectedFile = chooseFile();

            if (selectedFile != null) {
                panFile = selectedFile;
                panStatus.setText(panFile.getName());
            }

        } else if (e.getSource() == aadhaarUpload) {

            File selectedFile = chooseFile();

            if (selectedFile != null) {
                aadhaarFile = selectedFile;
                aadhaarStatus.setText(aadhaarFile.getName());
            }

        } else if (e.getSource() == photoUpload) {

            File selectedFile = chooseFile();

            if (selectedFile != null) {
                photoFile = selectedFile;
                photoStatus.setText(photoFile.getName());
            }

        } else if (e.getSource() == signatureUpload) {

            File selectedFile = chooseFile();

            if (selectedFile != null) {
                signatureFile = selectedFile;
                signatureStatus.setText(signatureFile.getName());
            }

        } else if (e.getSource() == clear) {

            panFile = null;
            aadhaarFile = null;
            photoFile = null;
            signatureFile = null;

            panStatus.setText("No file selected");
            aadhaarStatus.setText("No file selected");
            photoStatus.setText("No file selected");
            signatureStatus.setText("No file selected");

            declaration.setSelected(false);

            saveData();

        } else if (e.getSource() == previous) {

            saveData();

            new ThirdPage(data);

            dispose();

        } else if (e.getSource() == submit) {

            saveData();
            if (!data.declarationAccepted) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please accept the declaration before proceeding.",
                        "Declaration Required",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Open Review Page with SignupData
            new ReviewPage(data);

            // Close FourthPage
            dispose();

        }
    }

    public static void main(String args[]) {
        new FourthPage(1001);
    }
}
