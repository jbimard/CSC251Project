public class Policy {
    // Attributes related to the policy itself
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder; // Association with PolicyHolder
    private double policyPrice;

    // Constructor
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        calculatePolicyPrice();
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
}