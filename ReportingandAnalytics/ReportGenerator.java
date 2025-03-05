import java.util.List;

public class ReportGenerator {
    public static void main(String[] args) {
        OwnerInfo owner1 = new OwnerInfo("John Doe", "City Center");
        OwnerInfo owner2 = new OwnerInfo("Jane Smith", "Suburb");
        OwnerInfo owner3 = new OwnerInfo("Bob Johnson", "Downtown");

        Property property1 = new Property("Apartment A", 1500.0, owner1);
        Property property2 = new Property("House B", 2000.0, owner2);
        Property property3 = new Property("Condo C", 1800.0, owner3);

        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary", List.of(property1, property2, property3));
        financialReport.generateReport();
    }
}
