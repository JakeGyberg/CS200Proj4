public class Provider {
    private String number;
    private String name;

    public Provider(String num, String nm) {
        this.number = num;
        this.name = nm;
    }

    public String getValue() { return number; }
    public String getName() { return name; }

    public void setName(String name){
        this.name = name;
    }
}
