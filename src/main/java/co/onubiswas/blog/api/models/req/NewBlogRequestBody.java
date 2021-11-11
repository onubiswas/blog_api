package co.onubiswas.blog.api.models.req;


import co.onubiswas.blog.api.models.domain.Blog;

public class NewBlogRequestBody {
    private String title;
    private String image;
    private String description;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public Blog getBlog() {
        Blog b = new Blog();
        b.setTitle(title);
        b.setImage(image);
        b.setDescription(description);
        return b;
    }
}
