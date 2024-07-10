package com.bk.app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class AddressDTO {

  @Valid
  @NotNull(message = "Current address is mandatory")
  private CurrentAddressDTO currentAddress;

  @Valid
  @NotNull(message = "Permanent address is mandatory")
  private PermanentAddressDTO permanentAddress;

  // Getters and Setters


  public CurrentAddressDTO getCurrentAddress() {
    return currentAddress;
  }

  public void setCurrentAddress(CurrentAddressDTO currentAddress) {
    this.currentAddress = currentAddress;
  }

  public PermanentAddressDTO getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(PermanentAddressDTO permanentAddress) {
    this.permanentAddress = permanentAddress;
  }

  @Override
  public String toString() {
    return "AddressDTO{" +
        "currentAddress=" + currentAddress +
        ", permanentAddress=" + permanentAddress +
        '}';
  }
}
