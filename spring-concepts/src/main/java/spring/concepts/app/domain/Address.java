package spring.concepts.app.domain;

public class Address {

    private String street;
    private String postcode;

    public Address() {
    }


    public void init() {
        System.out.println("Address created " + this);
    }

    public void destroy() {
        System.out.println("Address destroyed");
    }

    public Address(String street, String postcode) {
        this.street = street;
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address [street=" + street + ", postcode=" + postcode + "]";
    }



}
