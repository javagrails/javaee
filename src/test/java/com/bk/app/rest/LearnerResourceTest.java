package com.bk.app.rest;

import com.bk.app.dto.AddressDTO;
import com.bk.app.dto.CurrentAddressDTO;
import com.bk.app.dto.PermanentAddressDTO;
import com.bk.app.dto.UserDTO;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@AutoConfigureMockMvc
public class LearnerResourceTest {

  public static final Long ID = 5000l;
  public static final String FULLNAME = "Salman";
  public static final String EMAIL = "salman@example.com";
  public static final Date DATE_OF_BIRTH = new Date();
  public static final String HOUSE_NUMBER = "99";
  public static final String ROAD_NUMBER = "100";
  public static final String CITY_NAME = "Dhaka";
  public static final String VILLAGE_NAME = "Bilashpur";
  public static final String UNION_NAME = "Dhanbari";
  public static final String DISTRICT_NAME = "Tangail";

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;


  public static UserDTO createUserDTO() {
    UserDTO user = new UserDTO();
    user.setId(ID);
    user.setFullName(FULLNAME);
    user.setEmail(EMAIL);
    user.setDateOfBirth(DATE_OF_BIRTH);
    user.setAddress(createAddressDTO());
    return user;
  }

  public static AddressDTO createAddressDTO() {
    AddressDTO address = new AddressDTO();
    address.setCurrent(createCurrentAddressDTO());
    address.setPermanent(createPermanentAddressDTO());
    return address;
  }

  public static PermanentAddressDTO createPermanentAddressDTO() {
    PermanentAddressDTO permanentAddress = new PermanentAddressDTO();
    permanentAddress.setVillage(VILLAGE_NAME);
    permanentAddress.setUnion(UNION_NAME);
    permanentAddress.setDistrict(DISTRICT_NAME);
    return permanentAddress;
  }

  private static CurrentAddressDTO createCurrentAddressDTO() {
    CurrentAddressDTO current = new CurrentAddressDTO();
    current.setHouse(HOUSE_NUMBER);
    current.setRoad(ROAD_NUMBER);
    current.setCity(CITY_NAME);
    return current;
  }

  @Test
  public void createUser() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    final UserDTO userDTO = createUserDTO();
    XmlMapper xmlMapper = new XmlMapper();
    String xmlContent = xmlMapper.writeValueAsString(userDTO);
    printXmlAsString(xmlContent);

    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_XML)
            .content(xmlContent)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.id").value(ID))
        .andExpect(jsonPath("$.fullName").value(FULLNAME))
        .andExpect(jsonPath("$.email").value(EMAIL))
        .andExpect(jsonPath("$.address.current.house").value(HOUSE_NUMBER))
        .andExpect(jsonPath("$.address.current.road").value(ROAD_NUMBER))
        .andExpect(jsonPath("$.address.current.city").value(CITY_NAME))
        .andExpect(jsonPath("$.address.permanent.village").value(VILLAGE_NAME))
        .andExpect(jsonPath("$.address.permanent.union").value(UNION_NAME))
        .andExpect(jsonPath("$.address.permanent.district").value(DISTRICT_NAME));
  }

  @Test
  public void createAddress() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    AddressDTO addressDTO = createAddressDTO();
    XmlMapper xmlMapper = new XmlMapper();
    String xmlContent = xmlMapper.writeValueAsString(addressDTO);
    printXmlAsString(xmlContent);

    mockMvc.perform(post("/api/address")
            .contentType(MediaType.APPLICATION_XML)
            .content(xmlContent)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.current").exists());
  }

  @Test
  public void createCurrentAddress() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    CurrentAddressDTO currentAddressDTO = createCurrentAddressDTO();
    XmlMapper xmlMapper = new XmlMapper();
    String xmlContent = xmlMapper.writeValueAsString(currentAddressDTO);
    printXmlAsString(xmlContent);

    mockMvc.perform(post("/api/address/current")
            .contentType(MediaType.APPLICATION_XML)
            .content(xmlContent)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.house").value(HOUSE_NUMBER));
  }

  @Test
  public void createPermanentAddress() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    PermanentAddressDTO permanentAddressDTO = createPermanentAddressDTO();
    XmlMapper xmlMapper = new XmlMapper();
    String xmlContent = xmlMapper.writeValueAsString(permanentAddressDTO);
    printXmlAsString(xmlContent);

    mockMvc.perform(post("/api/address/permanent")
            .contentType(MediaType.APPLICATION_XML)
            .content(xmlContent)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.village").value(VILLAGE_NAME));
  }

  @Test
  public void createPermanentAddress_ByReadXmlFile() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    // Load the XML file from the test resources folder
    ClassPathResource resource = new ClassPathResource("test-xml/permanent-address.xml");
    // Read the XML content as a string
    byte[] fileData = resource.getInputStream().readAllBytes();
    String xmlContent = new String(fileData);
    printXmlAsString(xmlContent);

    mockMvc.perform(post("/api/address/permanent")
            .contentType(MediaType.APPLICATION_XML)
            .content(xmlContent)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.village").value(VILLAGE_NAME))
        .andExpect(jsonPath("$.union").value(UNION_NAME))
        .andExpect(jsonPath("$.district").value(DISTRICT_NAME));
  }

  private static void printXmlAsString(String xmlContent) {
    System.out.println("=====================");
    System.out.println(xmlContent);
    System.out.println("=====================");
  }
}
