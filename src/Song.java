// TODO: extend the abstract media class to create a SONG class,
// TODO: with an additional attribute for the artist and an overridden
// TODO: method to display each song's info in the menu as:
// TODO: [SONG] Edge of 17 by Stevie Nicks

class Song extends Media{
    String artist;

     public Song(String artist, String title, String filePath){
         super(title, filePath);
         this.artist = artist;
    }
     @Override
     public void displayInfo() {
        System.out.println("[SONG] " + this.title + " by " + this.artist);
     }
 }