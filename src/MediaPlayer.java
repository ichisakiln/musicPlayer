import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;

class MediaThread implements Runnable {
    private AdvancedPlayer player;

    public MediaThread(AdvancedPlayer player) {
        this.player = player;
    }

    @Override
    public void run() {
        try {
            player.play();
        } catch (Exception e) {
            System.out.println("Playback failed or was interrupted.");
        }
    }
}

public class MediaPlayer {
    private AdvancedPlayer player;
    private Thread playerThread;

    public void play(Media asset) {
        stop();

        try {
            FileInputStream fis = new FileInputStream(asset.getFilePath());
            player = new AdvancedPlayer(fis);

            MediaThread runnable = new MediaThread(player);
            playerThread = new Thread(runnable);

            playerThread.start();
            System.out.println(">>> Now playing: " + asset.getTitle());

        } catch (Exception e) {
            System.out.println("Error! Could not play media file: " + e.getMessage());
        }
    }

    public void stop() {
        if (player != null) {
            player.close();
            player = null;
        }

        if (playerThread != null && playerThread.isAlive()) {
            playerThread.interrupt();
            playerThread = null;
        }
    }
}