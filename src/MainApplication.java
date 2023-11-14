import javax.swing.SwingUtilities;

public class MainApplication {

    public static void main(String[] args) {

        // Start the GUI application

        //QuestionBank bank = new QuestionBank();


        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                // Create and show the login window.

                new LoginWindow().createLoginWindow();

            }

        });

    }

}