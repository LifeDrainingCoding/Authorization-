import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class AuthorizationGUI extends JFrame implements ActionListener {
    private JLabel emailLabel, passwordLabel, messageLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    private HashMap<String, String> accounts;

    public AuthorizationGUI() {
        super("Authorization");
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        messageLabel = new JLabel("");

        emailField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);

        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);

        accounts = new HashMap<String, String>();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (accounts.containsKey(email) && accounts.get(email).equals(password)) {
                messageLabel.setText("Login successful!");
                openAccountPage(email);
            } else {
                messageLabel.setText("Invalid email or password.");
            }
        } else if (e.getSource() == registerButton) {
            if (accounts.size() >= 4) {
                messageLabel.setText("Maximum number of accounts reached.");
            } else {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (accounts.containsKey(email)) {
                    messageLabel.setText("Email already registered.");
                } else {
                    accounts.put(email, password);
                    messageLabel.setText("Registration successful!");
                    openAccountPage(email);
                }
            }
        }
    }

    private void openAccountPage(String email) {
        JFrame accountFrame = new JFrame(email + "'s Account");
        accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        accountFrame.setSize(500, 500);

        JLabel imageLabel = new JLabel();
        if (email.equals("1@gmail.com")) {
            ImageIcon image = new ImageIcon("image1.gif");
            imageLabel.setIcon(image);
        } else if (email.equals("2@gmail.com")) {
            ImageIcon image = new ImageIcon("image2.png");
            imageLabel.setIcon(image);
        } else if (email.equals("3@gmail.com")) {
            ImageIcon image = new ImageIcon("image3.png");
            imageLabel.setIcon(image);
        } else if (email.equals("4@gmail.com")) {
            ImageIcon image = new ImageIcon("image4.gif");
            imageLabel.setIcon(image);
        }
        accountFrame.add(imageLabel);

        accountFrame.setVisible(true);
    }

    public static void main(String[] args) {
        AuthorizationGUI gui = new AuthorizationGUI();
        gui.setSize(300, 150);
        gui.setVisible(true);
    }
}

