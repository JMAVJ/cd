import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class Lyrics {
    public static void getAllLyrics(HashMap<String, String> trackList) {
        Set<String> tracks = trackList.keySet();
        for (String track : tracks) {
            System.out.println(trackList.get(track));
        }
    }

    public static void getLyricById(String id, HashMap<String, String> trackList) {
            System.out.println(trackList.get(id));
    }

    public static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Get lyrics by track id");
        System.out.println("2. Get all lyrics");
        System.out.println("99. Exit");
    }

    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("song 1", "song 1 lyrics");
        trackList.put("song 2", "song 2 lyrics");
        trackList.put("song 3", "song 3 lyrics");
        trackList.put("song 4", "song 4 lyrics");
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            int option = Integer.valueOf(sc.nextLine());
            if (option == 1) {
                String id = sc.nextLine();
                getLyricById(id, trackList);
            } else if (option == 2) {
                getAllLyrics(trackList);
            } else if (option == 99) {
                sc.close();
                System.exit(0);
            }
        }
    }
}