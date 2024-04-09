public class Policy {
    // Attribute
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double heightInches;
    private double weightPounds;
    private double bmi;
    private double policyPrice;

    // Constructors
    public Policy() {
        // Default constructor with default values
        policyNumber = 0;
        providerName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        smokingStatus = "";
        heightInches = 0.0;
        weightPounds = 0.0;
        bmi = 0.0;
        policyPrice = 0.0;
    }

    public Policy(int policyNumber, String providerName, String policyholderFirstName, String policyholderLastName,
                  int policyholderAge, String smokingStatus, double heightInches, double weightPounds) {
        // Constructor with arguments to initialize all fields
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.smokingStatus = smokingStatus;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
        calculateBMI(); // Calculate BMI upon object creation
        calculatePolicyPrice(); // Calculate Policy Price upon object creation
    }

    // Getters and Setters
    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    public int getPolicyholderAge() {
        return policyholderAge;
    }

    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(double heightInches) {
        this.heightInches = heightInches;
    }

    public double getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(double weightPounds) {
        this.weightPounds = weightPounds;
    }

    public double getBMI() {
        return bmi;
    }

    public double getPolicyPrice() {
        return policyPrice;
    }

    // Other Methods
    private void calculateBMI() {
        bmi = (weightPounds * 703) / (heightInches * heightInches);
    }

    private void calculatePolicyPrice() {
        policyPrice = 600.0; // Base fee
        if (policyholderAge > 50) {
            policyPrice += 75.0; // Additional fee for age over 50
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            policyPrice += 100.0; // Additional fee for smoker
        }
        if (bmi > 35) {
            double additionalFee = (bmi - 35) * 20;
            policyPrice += additionalFee; // Additional fee for BMI over 35
        }
    }
}
