

public class Operator {
//Aaralyn and Stuart
    // Required fields
    private String name;            // 25 characters
    private String number;          // 9 digits


    // List of service records

    public Operator(String name, String number) {

        this.name = name;
        this.number = number;
        
    }

    // ----------------------
    // Getters and Setters
    // ----------------------

    public String getName() { return name; }
    public String getNumber() { return number; }
    
    public void setName(String name) { this.name = name; }
    public void setNumber(String number) { this.number = number; }
    
    // --------------------------------
    // Add a service record to member
    // --------------------------------
    

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

