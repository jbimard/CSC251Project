public class Policy {
    // Attributes
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

    /**
     * Default constructor with default values.
     */
    public Policy() {
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

    /**
     * Constructor with arguments to initialize all fields.
     *
     * @param policyNumber         The policy number.
     * @param providerName         The name of the insurance provider.
     * @param policyholderFirstName   The first name of the policyholder.
     * @param policyholderLastName    The last name of the policyholder.
     * @param policyholderAge        The age of the policyholder.
     * @param smokingStatus         The smoking status of the policyholder.
     * @param heightInches          The height of the policyholder in inches.
     * @param weightPounds          The weight of the policyholder in pounds.
     */
    public Policy(int policyNumber, String providerName, String policyholderFirstName, String policyholderLastName,
                  int policyholderAge, String smokingStatus, double heightInches, double weightPounds) {
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

    /**
     * Getter for policy number.
     *
     * @return The policy number.
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Setter for policy number.
     *
     * @param policyNumber The policy number.
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    // Similar documentation comments for other getters and setters...

    // Other Methods

    /**
     * Getter for BMI.
     *
     * @return The BMI (Body Mass Index) of the policyholder.
     */
    public double getBMI() {
        return bmi;
    }

    /**
     * Getter for policy price.
     *
     * @return The price of the policy.
     */
    public double getPolicyPrice() {
        return policyPrice;
    }

    // Similar documentation comments for other methods...

    /**
     * Calculates the BMI (Body Mass Index) of the policyholder.
     */
    private void calculateBMI() {
        bmi = (weightPounds * 703) / (heightInches * heightInches);
    }

    /**
     * Calculates the price of the policy based on various factors such as age, smoking status, and BMI.
     */
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
