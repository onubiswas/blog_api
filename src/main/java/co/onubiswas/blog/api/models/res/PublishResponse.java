package co.onubiswas.blog.api.models.res;

public class PublishResponse {
    private String status;

    public PublishResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
