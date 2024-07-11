package com.bk.app.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.validation.constraints.NotBlank;

@JacksonXmlRootElement(localName = "Permanent")
public class PermanentAddressDTO {

  @NotBlank(message = "Village is mandatory")
  private String village;

  @NotBlank(message = "Union is mandatory")
  private String union;

  @NotBlank(message = "District is mandatory")
  private String district;

  public String getVillage() {
    return village;
  }

  public void setVillage(String village) {
    this.village = village;
  }

  public String getUnion() {
    return union;
  }

  public void setUnion(String union) {
    this.union = union;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  @Override
  public String toString() {
    return "PermanentAddressDTO{" +
        "village='" + village + '\'' +
        ", union='" + union + '\'' +
        ", district='" + district + '\'' +
        '}';
  }
}
