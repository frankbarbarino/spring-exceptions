package api.challenge.model;

public class ErrorResponseBody {

  String path;
  String reason;

  public ErrorResponseBody() {
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
