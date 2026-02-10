public abstract class Media {
    protected String title;
    protected String filePath;

    public Media(String title, String filePath) {
        this.title = title;
        this.filePath = filePath;
    }

    public abstract void displayInfo();

    public String getTitle() { return title; }
    public String getFilePath() { return filePath; }
}