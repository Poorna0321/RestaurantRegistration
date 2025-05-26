import javax.swing.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {
    private JTextField tfUsername, tfPhone, tfDob, tfEmail;
    private JPasswordField pfPassword;
    private JButton btnRegister;

    public RegistrationForm() {
        setTitle("Restaurant Registration Form");
        setSize(400, 400);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 30, 100, 30);
        tfUsername = new JTextField();
        tfUsername.setBounds(150, 30, 150, 30);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(50, 70, 100, 30);
        tfPhone = new JTextField();
        tfPhone.setBounds(150, 70, 150, 30);

        JLabel lblDob = new JLabel("DOB:");
        lblDob.setBounds(50, 110, 100, 30);
        tfDob = new JTextField();
        tfDob.setBounds(150, 110, 150, 30);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 150, 100, 30);
        tfEmail = new JTextField();
        tfEmail.setBounds(150, 150, 150, 30);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 190, 100, 30);
        pfPassword = new JPasswordField();
        pfPassword.setBounds(150, 190, 150, 30);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(100, 250, 150, 30);

        add(lblUsername);
        add(tfUsername);
        add(lblPhone);
        add(tfPhone);
        add(lblDob);
        add(tfDob);
        add(lblEmail);
        add(tfEmail);
        add(lblPassword);
        add(pfPassword);
        add(btnRegister);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Action Listener for Register
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String username = tfUsername.getText();
        String phone = tfPhone.getText();
        String dob = tfDob.getText();
        String email = tfEmail.getText();
        String password = new String(pfPassword.getPassword());

        // Basic validation
        if (username.isEmpty() || phone.isEmpty() || dob.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return;
        }

        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone number must be 10 digits.");
            return;
        }

        User user = new User(username, email, phone, dob, password);
        boolean saved = Database.saveUser(user);
        if (saved) {
            JOptionPane.showMessageDialog(this, "Registration successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Error saving user.");
        }
    }
}
