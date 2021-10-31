package co.onubiswas.blog.api.models.domain;

import lombok.Data;

import org.springframework.data.annotation.Id;


@Data
public class Blog {
    @Id
    private Integer id;

    private String title;
    private String image; // url
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


