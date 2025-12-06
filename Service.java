public class Service {
    private String code;
    private String name;
    private double fee;
    //Stuart and Gia Minh Do
    public Service(String code, String name, double fee) {
        this.code = code;
        this.name = name;
        this.fee = fee;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
    }
}
