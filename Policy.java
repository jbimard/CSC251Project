public class Policy {
    // Static field to keep track of the number of Policy objects created
    private static int policyCount = 0;

    // Attributes related to the policy itself
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder; // Association with PolicyHolder
    private double policyPrice;

    /**
     * Constructor to create a new Policy object with the specified details.
     * 
     * @param policyNumber the unique number of the policy
     * @param providerName the name of the provider issuing the policy
     * @param policyHolder the PolicyHolder object containing the details of the person holding the policy
     */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        calculatePolicyPrice();
        policyCount++;
    }

    // Getters and Setters for Policy attributes
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

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    public double getPolicyPrice() {
        return policyPrice;
    }

    // Method to calculate the policy price based on PolicyHolder details
    private void calculatePolicyPrice() {
        policyPrice = 600.0; // Base fee
        if (policyHolder.getAge() > 50) {
            policyPrice += 75.0; // Additional fee for age over 50
        }
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            policyPrice += 100.0; // Additional fee for smoker
        }
        if (policyHolder.getBMI() > 35) {
            double additionalFee = (policyHolder.getBMI() - 35) * 20;
            policyPrice += additionalFee; // Additional fee for BMI over 35
        }
     }

      /**
     * Retrieves the total count of Policy objects created.
     * 
     * @return the total number of policies created
     */
    public static int getPolicyCount() {
        return policyCount;
    }

     // toString method
     @Override
     public String toString() {
         return "Policy Number: " + policyNumber + "\n" +
                "Provider Name: " + providerName + "\n" +
                "Policyholder's First Name: " + policyHolder.getFirstName() + "\n" +
                "Policyholder's Last Name: " + policyHolder.getLastName() + "\n" +
                "Policyholder's Age: " + policyHolder.getAge() + "\n" +
                "Policyholder's Smoking Status (Y/N): " + policyHolder.getSmokingStatus() + "\n" +
                "Policyholder's Height: " + policyHolder.getHeightInches() + " inches\n" +
                "Policyholder's Weight: " + policyHolder.getWeightPounds() + " pounds\n" +
                "Policyholder's BMI: " + String.format("%.2f", policyHolder.getBMI()) + "\n" +
                "Policy Price: $" + String.format("%.2f", policyPrice) + "\n\n";
     }
}