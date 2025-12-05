import java.util.ArrayList;
import java.util.List;

public class Provider {
    private String name;            // 25 characters
    private String number;          // 9 digits
    private String streetAddress;   // 25 characters
    private String city;            // 14 characters
    private String state;           // 2 letters
    private String zipCode;         // 5 digits
    private List<ServiceRecord> weeklyRecords = new ArrayList<>();

    public Provider(String name, String number,
                  String streetAddress, String city,
                  String state, String zipCode) {
        this.name = name;
        this.number = number;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getName() { return name; }
    public String getNumber() { return number; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }

    public void setName(String name) { this.name = name; }
    public void setNumber(String number) { this.number = number; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    
    public List<ServiceRecord> getAllRecords() {
        return weeklyRecords;
    }

    public String toString () {
        return "Provider{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}'; 
    }
}
