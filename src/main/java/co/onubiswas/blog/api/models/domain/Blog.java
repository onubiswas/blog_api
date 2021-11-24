package co.onubiswas.blog.api.models.domain;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("blogs")
@Data
public class Blog {
    @Id
    private Integer id;

    private String email; // foreign key soft
    private String title;
    private String image; // url
    private String description;
    private Integer draft = 1;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
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

    public Integer getDraft() {
        return draft;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDraft(Integer draft) {
        this.draft = draft;
    }
}


