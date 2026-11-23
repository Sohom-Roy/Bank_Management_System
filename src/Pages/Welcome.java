package Pages;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SignUp.FirstPage;
import Pages.SignIn;

public class Welcome extends JFrame {

    private Image background;

    public Welcome() {

        // Load background image
        ImageIcon icon = new ImageIcon(
                ClassLoader.getSystemResource("icons/Welcome.png")
        );

        background = icon.getImage();

        // Background panel
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(background, 0, 0,
                        getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(null);

        // Sign In Button
        JButton signIn = new JButton();
        signIn.setBounds(163, 405, 275, 66);
        styleButton(signIn);

        signIn.addActionListener(e -> {
            new SignIn();
            dispose();
        });

        // Sign Up Button
        JButton signUp = new JButton();
        signUp.setBounds(163, 488, 275, 66);
        styleButton(signUp);

        signUp.addActionListener(e -> {
            new FirstPage();
            dispose();
        });

        panel.add(signIn);
        panel.add(signUp);

        // Frame settings
        setContentPane(panel);

        setSize(600, 720);
        setLocationRelativeTo(null);
        setResizable(false);

        // Image includes its own window title bar
        setUndecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Escape key to close window
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("ESCAPE"), "close");

        panel.getActionMap().put("close", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setLocation(350, 10);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Welcome();
        });
    }
}

