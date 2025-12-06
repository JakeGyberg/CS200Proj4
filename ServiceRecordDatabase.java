import java.util.ArrayList;
import java.util.List;
//Stuart and Zachary
public class ServiceRecordDatabase {
    private List<ServiceRecord> records = new ArrayList<>();

    public void addRecord(ServiceRecord r) {
        records.add(r);
        System.out.println("Record saved.");
    }

    public void printAllRecords() {
        System.out.println("\n=== Billing History ===");
        if (records.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (ServiceRecord r : records) {
            System.out.println("Date of Service: " + r.getServiceDate() +
                               ", Provider: " + r.getProviderNum() +
                               ", Member: " + r.getMemberNum() +
                               ", Service Code: " + r.getServiceCode() +
                               ", Comments: " + r.getComments());
        }
    }

    public void printRecordsByProvider(String providerNum) {
        System.out.println("\n=== Billing History for Provider " + providerNum + " ===");
        boolean found = false;
        for (ServiceRecord r : records) {
            if (r.getProviderNum().equals(providerNum)) {
                found = true;
                System.out.println("Date of Service: " + r.getServiceDate() +
                                   ", Member: " + r.getMemberNum() +
                                   ", Service Code: " + r.getServiceCode() +
                                   ", Comments: " + r.getComments());
            }
        }
        if (!found) System.out.println("No records found for this provider.");
    }

    public List<ServiceRecord> getAllRecords() { return records; }
}
