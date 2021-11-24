package co.onubiswas.blog.api.models.res;

public class DetailResponse {

    private String title;
    private String image;
    private String author;
    private String description;

    public DetailResponse(String title, String image, String author, String description) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.description = description;
    }

    public DetailResponse() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
