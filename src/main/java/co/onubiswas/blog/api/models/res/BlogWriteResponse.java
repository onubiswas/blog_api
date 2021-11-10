package co.onubiswas.blog.api.models.res;


public class BlogWriteResponse {
    private Integer id;

    public BlogWriteResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
