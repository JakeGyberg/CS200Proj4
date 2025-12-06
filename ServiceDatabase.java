import java.util.HashMap;
import java.util.Map;
//Gia Minh Do and Stuart
public class ServiceDatabase {
    private Map<String, Service> directory = new HashMap<>();

    public ServiceDatabase() {
        directory.put("598470", new Service("598470", "Dietitian Session", 80.00));
        directory.put("883948", new Service("883948", "Aerobics Exercise", 65.00));
    }

    public Service lookup(String code) {
        return directory.get(code);
    }

    public void printProviderDirectory() {
        System.out.println("\n=== Provider Directory ===");
        for (Service s : directory.values()) {
    System.out.println(s.getCode() + " - " + s.getName() + " - $" + s.getFee());}
    }
}
