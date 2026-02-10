import java.util.ArrayList;
import java.util.Scanner;

public class MediaLibrary {
    private static Scanner scanner = new Scanner(System.in);
    // create player object of type ThreadedPlayer using constructor
    private static MediaPlayer player = new MediaPlayer();
    // create library ArrayList to hold all songs and podcasts together
    public static ArrayList<Media> library = new ArrayList<>();

    public static void main(String[] args) {

        // TODO: Add songs & podcasts in library/ to the library ArrayList
        library.add(new Song("Leo/need", "Flower Knot", "library/hanamusubiLeoneed.mp3"));
        library.add(new Podcast(3,"John Oliver", "Late Night With John Oliver", "library/MysteryPersonPodcast.mp3"));
        library.add(new Podcast(1,"Elyssa, Tori, Summer", "How to Looksmaxx your Code", "library/30 E 92nd St 5.mp3"));

        // Initial song request
        requestAndPlay();
        boolean running = true;
        while (running) {
            System.out.println("Options: [n] Play New Song | [s] Stop Current | [a] Affirmation | [q] Quit");
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase().trim();
            switch (input) {
                case "n":
                    requestAndPlay();
                    break;
                case "s":
                    player.stop();
                    System.out.println("Playback stopped.");
                    break;
                case "q":
                    player.stop();
                    System.out.println("Quitting Media Player. Goodbye!");
                    running = false;
                    break;
                case "a":
                    System.out.println("You have such great taste!");
                    break;
                default:
                    System.out.println("Invalid input :(");
            }
        }
        System.exit(0);
    }

    private static void requestAndPlay() {
        System.out.println("Choose a song from my Media Library!!");
        for (int i = 0; i < library.size(); i++) {
            System.out.print((i + 1) + ". ");
            library.get(i).displayInfo();
        }
        System.out.println("0. Exit");
        System.out.print("Enter a number to play media: ");
        int choice = scanner.nextInt();

        if (choice == 0) {
            System.exit(0);
        }

        if (choice > 0 && choice <= library.size()) {
            player.play(library.get(choice - 1));
        } else {
            System.out.println("Invalid selection.");
        }
        scanner.nextLine();
    }
}