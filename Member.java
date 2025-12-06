import java.util.ArrayList;
import java.util.List;
//Stuart and Jake
public class Member {

    // Required fields
    private String name;            // 25 characters
    private String number;          // 9 digits
    private String streetAddress;   // 25 characters
    private String city;            // 14 characters
    private String state;           // 2 letters
    private String zipCode;         // 5 digits
    private boolean active;
    // List of service records
    private List<ServiceRecord> services;

    public Member(String name, String number,
                  String streetAddress, String city,
                  String state, String zipCode, boolean active) {

        this.name = name;
        this.number = number;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.active = active;

        this.services = new ArrayList<>();
    }

    // ----------------------
    // Getters and Setters
    // ----------------------

    


    public String getName() { return name; }
    public String getNumber() { return number; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public List<ServiceRecord> getServices() { return services; }
    public boolean getActive() {return active;}

    public void setName(String name) { this.name = name; }
    public void setNumber(String number) { this.number = number; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setActive(boolean active) {this.active = active;}

    // --------------------------------
    // Add a service record to member
    // --------------------------------
    public void addServiceRecord(ServiceRecord record) {
        this.services.add(record);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", streetAddress='"  + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", services=" + services +
                ", active=" + active + 
                '}';
    }
}
