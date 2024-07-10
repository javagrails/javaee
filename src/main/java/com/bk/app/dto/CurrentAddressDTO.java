package com.bk.app.dto;

import jakarta.validation.constraints.NotBlank;

public class CurrentAddressDTO {

  @NotBlank(message = "House is mandatory")
  private String house;

  @NotBlank(message = "Road is mandatory")
  private String road;

  @NotBlank(message = "City is mandatory")
  private String city;

  // Getters and Setters

  public String getHouse() {
    return house;
  }

  public void setHouse(String house) {
    this.house = house;
  }

  public String getRoad() {
    return road;
  }

  public void setRoad(String road) {
    this.road = road;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "CurrentAddressDTO{" +
        "house='" + house + '\'' +
        ", road='" + road + '\'' +
        ", city='" + city + '\'' +
        '}';
  }
}
