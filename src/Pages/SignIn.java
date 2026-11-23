package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignIn extends JFrame implements ActionListener {

    JTextField accountField;
    JPasswordField pinField;

    JButton signIn, clear, back;

    Image background;

    public SignIn() {

        setTitle("Aurevant Bank - Sign In");

        // Load Background Image
        ImageIcon I1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/SignIn.png")
        );

        background = I1.getImage();

        // Background Panel
        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(background, 0, 0,
                        getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(null);

        // Account Number Field
        accountField = new JTextField();
        accountField.setBounds(80, 340, 440, 36);
        styleTextField(accountField);
        accountField.setBorder(null);
        panel.add(accountField);

        // PIN Field
        pinField = new JPasswordField();
        pinField.setBounds(80, 429, 440, 36);
        styleTextField(pinField);
        pinField.setBorder(null);
        panel.add(pinField);

        // Clear Button
        clear = new JButton();
        clear.setBounds(49, 508, 160, 55);
        styleButton(clear);
        clear.addActionListener(this);
        panel.add(clear);

        // Back Button
        back = new JButton();
        back.setBounds(226, 508, 152, 55);
        styleButton(back);
        back.addActionListener(this);
        panel.add(back);

        // Sign In Button
        signIn = new JButton();
        signIn.setBounds(394, 508, 162, 55);
        styleButton(signIn);
        signIn.addActionListener(this);
        panel.add(signIn);

        // Frame Settings
        setContentPane(panel);

        setSize(600, 720);
        setLocationRelativeTo(null);
        setResizable(false);

        // Background image contains its own title bar
        setUndecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350, 10);
        setVisible(true);
    }

    // Text Field Styling
    private void styleTextField(JTextField field) {

        field.setFont(new Font("Arial", Font.PLAIN, 18));
        field.setForeground(new Color(10, 35, 80));
        field.setBackground(Color.WHITE);

        field.setBorder(
                BorderFactory.createLineBorder(
                        new Color(10, 35, 80), 2
                )
        );

        field.setMargin(new Insets(5, 12, 5, 12));
    }

    // Transparent Button Styling
    private void styleButton(JButton button) {

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // CLEAR BUTTON
        if (e.getSource() == clear) {

            accountField.setText("");
            pinField.setText("");

        }

        // BACK BUTTON
        else if (e.getSource() == back) {

            dispose();

            // Open Welcome Page
            new Welcome();
        }

        // SIGN IN BUTTON
        else if (e.getSource() == signIn) {

            String account = accountField.getText().trim();

            String pin = new String(pinField.getPassword());

            // Check Empty Fields
            if (account.isEmpty() || pin.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your Account Number and PIN.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // Validate Account Number
            if (!account.matches("\\d{12}")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Account Number must contain exactly 12 digits.",
                        "Invalid Account Number",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Validate PIN
            if (!pin.matches("\\d{4}")) {

                JOptionPane.showMessageDialog(
                        this,
                        "PIN must contain exactly 4 digits.",
                        "Invalid PIN",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Successful Input Validation
            JOptionPane.showMessageDialog(
                    this,
                    "Details entered successfully!\n" +
                            "Database authentication is not connected yet.",
                    "Aurevant Bank",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new SignIn());

    }
}
