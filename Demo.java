import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // ArrayList to store Policy objects
        ArrayList<Policy> policies = new ArrayList<>();

        // Read from the text file
        try (Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"))) {
            while (fileScanner.hasNextLine()) {
                int policyNumber = Integer.parseInt(fileScanner.nextLine());
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());

                // Create Policy object and add it to the ArrayList
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        // Output
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder’s First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder’s Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder’s Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder’s Height: " + policy.getHeightInches() + " inches");
            System.out.println("Policyholder’s Weight: " + policy.getWeightPounds() + " pounds");
            System.out.printf("Policyholder’s BMI: %,.2f\n", policy.getBMI());
            System.out.printf("Policy Price: $%,.2f\n\n", policy.getPolicyPrice());
        }
    }
}
