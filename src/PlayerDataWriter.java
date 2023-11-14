
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PlayerDataWriter {
    private File csvFile;

    public PlayerDataWriter(String username) {
        // Create a CSV file with the provided username.
        csvFile = new File(username + ".csv");

        // Check if the file already exists; if not, create a new one.
        if (!csvFile.exists()) {
            try {
                csvFile.createNewFile();
                System.out.println("New CSV file created: " + csvFile.getName());
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1); // Exit the program with an error code if an exception occurs.
            }
        }
    }

    public void writeScore(String username, int score, long seconds) {
        try {
            // Create a FileWriter to append data to the existing CSV file.
            FileWriter writer = new FileWriter(username + ".csv", true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw);

            // Write the score and seconds as a new line in the CSV file.
            out.println(score + "," + seconds);

            // Close the resources in reverse order (PrintWriter, BufferedWriter, FileWriter).
            out.close();
            bw.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace(); // Print the exception details if an error occurs.
        }
    }

    public File getCSVFile() {
        return csvFile;
    }
}
