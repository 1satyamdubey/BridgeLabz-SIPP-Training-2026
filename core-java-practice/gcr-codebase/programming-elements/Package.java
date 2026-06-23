// Base Class: Package
class Package {
    // Encapsulation: Private attributes to hide them from direct external modification
    private final String trackingId; // final ensures read-only after initialization
    private double weight;

    // Constructor to initialize both fields
    public Package(String trackingId, double weight) {
        this.trackingId = trackingId;
        // Apply validation during initialization as well
        if (weight > 0.0) {
            this.weight = weight;
        } else {
            System.out.println("Error: Initial weight must be greater than 0.0. Defaulting to 1.0.");
            this.weight = 1.0; // Fallback default value
        }
    }

    // Getter for trackingId (Read-only)
    public String getTrackingId() {
        return trackingId;
    }

    // Getter for weight
    public double getWeight() {
        return weight;
    }

    // Setter for weight with validation rules
    public void setWeight(double weight) {
        if (weight <= 0.0) {
            System.out.println("Error: Invalid weight update (" + weight + "). Weight must be greater than 0.0. Value unchanged.");
        } else {
            this.weight = weight;
        }
    }
}

// Subclass: ExpressPackage
class ExpressPackage extends Package {
    private final String priorityLevel; // e.g., "High", "Critical"

    // Constructor passing data to the parent (super) class
    public ExpressPackage(String trackingId, double weight, String priorityLevel) {
        super(trackingId, weight); // Explicit inheritance requirement
        this.priorityLevel = priorityLevel;
    }

    // Getter for priorityLevel
    public String getPriorityLevel() {
        return priorityLevel;
    }

    // Formatted shipping label display method
    public void printShippingLabel() {
        System.out.println("========= SHIPPING LABEL =========");
        System.out.println("Tracking ID   : " + getTrackingId());
        System.out.println("Weight        : " + getWeight() + " kg");
        System.out.println("Priority Level: " + getPriorityLevel());
        System.out.println("==================================");
    }
}

// Main class to demonstrate scenarios
class Main {
    public static void main(String[] args) {
        System.out.println("--- Scenario A: Valid Input ---");
        ExpressPackage validPkg = new ExpressPackage("101", 2.5, "Critical");
        validPkg.printShippingLabel();

        System.out.println("\n--- Scenario B: Invalid Input Handling ---");
        System.out.println("Attempting to change weight to -1.5...");
        validPkg.setWeight(-1.5);

        System.out.println("\nAttempting to change weight to 0.0...");
        validPkg.setWeight(0.0);

        System.out.println("\nPrinting label again to verify weight remained unchanged:");
        validPkg.printShippingLabel();
    }
}

