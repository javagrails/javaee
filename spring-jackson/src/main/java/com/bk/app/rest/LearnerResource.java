package com.bk.app.rest;


import com.bk.app.dto.AddressDTO;
import com.bk.app.dto.CurrentAddressDTO;
import com.bk.app.dto.PermanentAddressDTO;
import com.bk.app.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@Validated
public class LearnerResource {

  @PostMapping(path = "/users",
      consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
    return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
  }

  @PostMapping(path = "/address",
      consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AddressDTO> createAddress(@Validated @RequestBody AddressDTO addressDTO) {
    return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
  }

  @PostMapping(path = "/address/current",
      consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CurrentAddressDTO> createCurrentAddress(
      @Validated @RequestBody CurrentAddressDTO currentAddressDTO) {
    return new ResponseEntity<>(currentAddressDTO, HttpStatus.CREATED);
  }

  @PostMapping(path = "/address/permanent",
      consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PermanentAddressDTO> createPermanentAddress(
      @Validated @RequestBody PermanentAddressDTO permanentAddressDTO) {
    return new ResponseEntity<>(permanentAddressDTO, HttpStatus.CREATED);
  }
}
