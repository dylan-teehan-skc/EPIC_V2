
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpListener implements ActionListener {
    // this method is triggered when the "Sign Up" button is clicked.
    public void actionPerformed(ActionEvent e) {
        // Create text fields for new user information.
        JTextField newUserTextField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();
        Object[] message = {
                "Enter New Email (Username):", newUserTextField,
                "Enter New Password:", newPasswordField
        };

        // Shows a dialog to get user input for email and password.
        int option = JOptionPane.showConfirmDialog(null, message, "User Registration", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            // Retrieve the new username and validate it as an email address.
            String newUsername = newUserTextField.getText().trim();
            String newEmailRegex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
            Pattern pattern = Pattern.compile(newEmailRegex);
            Matcher matcher = pattern.matcher(newUsername);

            if (!matcher.matches()) {
                // If the email is invalid, show an error message.
                JOptionPane.showMessageDialog(null, "Invalid Email Address, Please Retry.");
            } else {
                // Retrieve and register the new username and password.
                char[] newPasswordChars = newPasswordField.getPassword();
                String newPassword = new String(newPasswordChars);
                registerUser(newUsername, newPassword);
            }
        }
    }

    // writes persons username and password to a CSV file.
    private void registerUser(String username, String password) {
        try (FileWriter writer = new FileWriter("user_data.csv", true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bw)) {
            // append the new user's information to the CSV file.
            out.println(username + "," + password);
            JOptionPane.showMessageDialog(null, "User Registered Successfully. Please Login.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
