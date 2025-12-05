import java.util.Date;

public class ServiceRecord {
    private Date timestamp;
    private String serviceDate;
    private String providerNum;
    private String memberNum;
    private String serviceCode;
    private String comments;

    public ServiceRecord(Date timestamp, String serviceDate, String providerNum,
                         String memberNum, String serviceCode, String comments) {
        this.timestamp = timestamp;
        this.serviceDate = serviceDate;
        this.providerNum = providerNum;
        this.memberNum = memberNum;
        this.serviceCode = serviceCode;
        this.comments = comments;
    }

    public String getProviderNum() { return providerNum; }
    public String getMemberNum() { return memberNum; }
    public String getServiceCode() { return serviceCode; }
    public String getServiceDate() { return serviceDate; }
    public String getComments() { return comments; }
}




// public class ServiceRecord {
//     private String dateOfService;   // MM-DD-YYYY
//     private String providerName;    // 25 chars
//     private String serviceName;     // 20 chars

//     public ServiceRecord(String dateOfService, String providerName, String serviceName) {
//         this.dateOfService = dateOfService;
//         this.providerName = providerName;
//         this.serviceName = serviceName;
//     }

//     public String getDateOfService() { return dateOfService; }
//     public String getProviderName() { return providerName; }
//     public String getServiceName() { return serviceName; }

//     public void setDateOfService(String s) { this.dateOfService = s; }
//     public void setProviderName(String s) { this.providerName = s; }
//     public void setServiceName(String s) { this.serviceName = s; }

//     @Override
//     public String toString() {
//         return "ServiceRecord{" +
//                 "date='" + dateOfService + '\'' +
//                 ", provider='" + providerName + '\'' +
//                 ", service='" + serviceName + '\'' +
//                 '}';
//     }
// }
