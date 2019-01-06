package dto;

public class Dvd extends LibraryItem {

    private String[] languages;
    private String[] subtitles;
    private String producer;
    private String[] actors;

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String[] subtitles) {
        this.subtitles = subtitles;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }
}
