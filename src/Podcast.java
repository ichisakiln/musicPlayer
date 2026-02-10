// TODO: extend the abstract media class to create a SONG class,
// TODO: with an additional attributes for episode number and host, and an overriden
// TODO: method to display each song's info in the menu as:
// TODO: [PODCAST] Mystery Person Podcast episode 1 with host(s) Emma & Maeve
class Podcast extends Media{
    int episodeNumber;
    String host;


    public Podcast(int episodeNumber, String host, String title, String filePath){
        super(title, filePath);
        this.episodeNumber = episodeNumber;
        this.host = host;
    }
    @Override
    public void displayInfo() {
        System.out.println("[PODCAST] " + this.title + " episode " + this.episodeNumber + " with host(s) " + this.host);
    }
}