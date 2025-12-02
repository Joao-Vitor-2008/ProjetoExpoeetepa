package com.exemplo.ClassesAuxiliares;

public class STATUS {

  private String STATUS = ("");
  private static STATUS status = new STATUS();

  public static STATUS getInstance() {
    return status;
  }

  public void setStatus(String status) {
    STATUS = status;
  }

  public String getStatus() {
    return STATUS;
  }
}
