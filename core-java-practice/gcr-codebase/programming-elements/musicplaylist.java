import java.util.LinkedList;
import java.util.Scanner;

public class musicplaylist {
    private final LinkedList<String> recentlyPlayed = new LinkedList<>();

    public void addSong(String songName) {
        if (songName == null || songName.trim().isEmpty()) {
            System.out.println("Song name cannot be empty.");
            return;
        }

        String trimmedSong = songName.trim();
        recentlyPlayed.addFirst(trimmedSong);

        if (recentlyPlayed.size() > 10) {
            recentlyPlayed.removeLast();
        }
    }

    public boolean searchSong(String songName) {
        if (songName == null || songName.trim().isEmpty()) {
            System.out.println("Please enter a valid song name.");
            return false;
        }

        return recentlyPlayed.contains(songName.trim());
    }

    public void displayPlaylist() {
        if (recentlyPlayed.isEmpty()) {
            System.out.println("Recently Played History is empty.");
            return;
        }

        System.out.println("Recently Played History:");
        int position = 1;
        for (String song : recentlyPlayed) {
            System.out.println(position + ". " + song);
            position++;
        }
    }

    public static void main(String[] args) {
        musicplaylist engine = new musicplaylist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMusic Playlist Recommendation Engine");
            System.out.println("1. Add a song");
            System.out.println("2. Search for a song");
            System.out.println("3. Display recently played history");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter song name: ");
                    String songName = scanner.nextLine();
                    engine.addSong(songName);
                }
                case 2 -> {
                    System.out.print("Enter song name to search: ");
                    String songName = scanner.nextLine();
                    if (engine.searchSong(songName)) {
                        System.out.println("Song found in recently played history.");
                    } else {
                        System.out.println("Song not found in recently played history.");
                    }
                }
                case 3 -> engine.displayPlaylist();
                case 4 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
