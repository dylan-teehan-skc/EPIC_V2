
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leaderboard {
    private File csvFile;

    public static void WriteToLeaderboard(String user, int MeanScore, int MeanTime) {
        File csvFile = new File("Leaderboard.csv");

        try {
            // Read existing data from the CSV file.
            List<LeaderboardEntry> entries = readLeaderboardData(csvFile);

            // Add the new entry to the list.
            entries.add(new LeaderboardEntry(user, MeanScore, MeanTime));

            // Sort the list based on your criteria (highest score and lowest time).
            Collections.sort(entries, new LeaderboardComparator());

            // Write the sorted data back to the CSV file.
            writeLeaderboardData(csvFile, entries);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static List<LeaderboardEntry> readLeaderboardData(File csvFile) throws IOException {
        List<LeaderboardEntry> entries = new ArrayList<>();
        if (csvFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String user = parts[0];
                    int meanScore = Integer.parseInt(parts[1]);
                    int meanTime = Integer.parseInt(parts[2]);
                    entries.add(new LeaderboardEntry(user, meanScore, meanTime));
                }
            }
            reader.close();
        }
        return entries;
    }

    private static void writeLeaderboardData(File csvFile, List<LeaderboardEntry> entries) throws IOException {
        FileWriter writer = new FileWriter(csvFile, false);
        PrintWriter out = new PrintWriter(new BufferedWriter(writer));
        for (LeaderboardEntry entry : entries) {
            out.println(entry.getUser() + "," + entry.getMeanScore() + "," + entry.getMeanTime());
        }
        out.close();
    }

    public File getCSVFile() {
        return csvFile;
    }

    public static void main(String[] args) {
        //WriteToLeaderboard("James", 15, 33);
    }
}

class LeaderboardEntry {
    private String user;
    private int meanScore;
    private int meanTime;

    public LeaderboardEntry(String user, int meanScore, int meanTime) {
        this.user = user;
        this.meanScore = meanScore;
        this.meanTime = meanTime;
    }

    public String getUser() {
        return user;
    }

    public int getMeanScore() {
        return meanScore;
    }

    public int getMeanTime() {
        return meanTime;
    }
}

class LeaderboardComparator implements Comparator<LeaderboardEntry> {
    @Override
    public int compare(LeaderboardEntry entry1, LeaderboardEntry entry2) {
        // Sort by highest score, and in case of a tie, by lowest time.
        if (entry1.getMeanScore() == entry2.getMeanScore()) {
            return entry1.getMeanTime() - entry2.getMeanTime();
        }
        return entry2.getMeanScore() - entry1.getMeanScore();
    }
}
