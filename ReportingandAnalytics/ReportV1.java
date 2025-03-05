import java.util.List;


class OwnerInfo {
    private String ownerName;
    private String location;

    public OwnerInfo(String ownerName, String location) {
        this.ownerName = ownerName;
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLocation() {
        return location;
    }
}

class Property {
    private String name;
    private double rentAmount;
    private OwnerInfo ownerInfo;

    public Property(String name, double rentAmount, OwnerInfo ownerInfo) {
        this.name = name;
        this.rentAmount = rentAmount;
        this.ownerInfo = ownerInfo;
    }

    public String getName() { return name; }
    public double getRentAmount() { return rentAmount; }
    public OwnerInfo getOwnerInfo() { return ownerInfo; }
}

class FinancialReport {
    private String reportTitle;
    private List<Property> properties;
    private static final double PREMIUM_THRESHOLD = 2000.0;

    public FinancialReport(String reportTitle, List<Property> properties) {
        this.reportTitle = reportTitle;
        this.properties = properties;
    }

    public void printPropertyDetails(Property property) {
        System.out.println("Property: " + property.getName());
        System.out.println("Rent Amount: $" + property.getRentAmount());
        System.out.println("Owner: " + property.getOwnerInfo().getOwnerName());
        System.out.println("Location: " + property.getOwnerInfo().getLocation());
    }

    public void generateReport() {
        double totalRent = 0; 
        System.out.println("Financial Report: " + reportTitle);
        System.out.println("----------------------------");
        for (Property property : properties) {
            printPropertyDetails(property);
            totalRent += property.getRentAmount();

            if (property.getRentAmount() > PREMIUM_THRESHOLD) {
                System.out.println("This is a premium property.");
            } else {
                System.out.println("This is a standard property.");
            }

            double yearlyRent = property.getRentAmount() * 12; 
            System.out.println("Yearly Rent: $" + yearlyRent);
            System.out.println("--------------------");
        }
        System.out.println("Total Rent Amount: $" + totalRent);
    }
}


