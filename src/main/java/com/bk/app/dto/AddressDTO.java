package com.bk.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JacksonXmlRootElement(localName = "MyAddress")
public class AddressDTO {

  @Valid
  @NotNull(message = "Current address is mandatory")
  private CurrentAddressDTO current;

  @Valid
  @NotNull(message = "Permanent address is mandatory")
  private PermanentAddressDTO permanent;

  // Getters and Setters


  public CurrentAddressDTO getCurrent() {
    return current;
  }

  public void setCurrent(CurrentAddressDTO current) {
    this.current = current;
  }

  public PermanentAddressDTO getPermanent() {
    return permanent;
  }

  public void setPermanent(PermanentAddressDTO permanent) {
    this.permanent = permanent;
  }

  @Override
  public String toString() {
    return "AddressDTO{" +
        "current=" + current +
        ", permanent=" + permanent +
        '}';
  }
}
