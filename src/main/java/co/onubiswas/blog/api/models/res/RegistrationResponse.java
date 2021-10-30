package co.onubiswas.blog.api.models.res;

public class RegistrationResponse {
    private String status;

    public RegistrationResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
