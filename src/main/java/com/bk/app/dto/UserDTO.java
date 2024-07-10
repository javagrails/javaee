package com.bk.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@JacksonXmlRootElement(localName = "user")
public class UserDTO {

  @JacksonXmlProperty(isAttribute = true)
  @NotNull(message = "ID is mandatory")
  private Long id;


  @NotBlank(message = "Full name is mandatory")
  private String fullName;

  @Email(message = "Email should be valid")
  @NotBlank(message = "Email is mandatory")
  private String email;

  @NotNull(message = "Date of birth is mandatory")
  private Date dateOfBirth;

  @Valid
  @NotNull(message = "Address is mandatory")
  //@JacksonXmlProperty(localName = "MyAddress")
  private AddressDTO address;

  // Getters and Setters


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "UserDTO{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        ", address=" + address +
        '}';
  }
}
