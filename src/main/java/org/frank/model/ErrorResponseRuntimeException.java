package org.frank.model;

public class ErrorResponseRuntimeException extends RuntimeException{
  String path;
  String reason;

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
