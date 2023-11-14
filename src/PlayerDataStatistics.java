import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PlayerDataStatistics  {
    public static void PlayerData(String user, int score, long second) {
        // Create an instance of PlayerDataWriter to handle the user's CSV file
        PlayerDataWriter userDataWriter = new PlayerDataWriter(user);
        File csvFile = userDataWriter.getCSVFile();

        // Calculate and display statistics
        int[] statistics = calculateStatistics(csvFile);

        // Print and display statistics using the StatisticsGUI class
        System.out.println("Mean Score: " + statistics[0]);
        System.out.println("Standard Deviation of Score: " + statistics[1]);
        System.out.println("Mean Time in Seconds: " + statistics[2]);
        StatisticsGUI.ShowStatistics(score, second, statistics[0], statistics[1], statistics[2]);
        Leaderboard.WriteToLeaderboard(user, statistics[0], statistics[2]);
        LeaderboardGUI gui = new LeaderboardGUI();
        LeaderboardGUI.createLeaderboardWindow() ;
    }

    private static int[] calculateStatistics(File csvFile) {
        List<Integer> scores = new ArrayList<>();
        List<Integer> seconds = new ArrayList<>();

        // Read data from the user's CSV file and populate lists
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    // Extract score and seconds from the CSV file
                    int score = Integer.parseInt(parts[0]);
                    int second = Integer.parseInt(parts[1]);

                    // Add score and seconds to respective lists
                    scores.add(score);
                    seconds.add(second);
                }
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        if (scores.isEmpty()) {
            // If there are no scores available, return a message
            System.out.println("No scores available to calculate statistics.");
            return new int[]{0, 0, 0}; // Default values
        } else {
            // Calculate mean score, standard deviation of score, and mean seconds
            int meanScore = calculateMean(scores);
            int standardDeviationScore = calculateStandardDeviation(scores, meanScore);
            int meanSeconds = calculateMean(seconds);

            // Return the statistics as an array of integers
            return new int[]{meanScore, standardDeviationScore, meanSeconds};
        }
    }

    // Calculate the mean of a list of integers
    private static int calculateMean(List<Integer> data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum / data.size();
    }

    // Calculate the standard deviation of a list of integers
    private static int calculateStandardDeviation(List<Integer> data, int mean) {
        double squaredDifferencesSum = 0.0;
        for (int value : data) {
            squaredDifferencesSum += Math.pow(value - mean, 2);
        }
        double variance = squaredDifferencesSum / data.size();
        return (int) Math.sqrt(variance);
    }
}

