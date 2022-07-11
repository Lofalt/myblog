package cn.lofalt.myblog.utils;


public class ResultInfo {

    private Boolean success;
    private String message;
    private String token;

    @Override
    public String toString() {
        return "ResultInfo{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
