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

                // Skip the blank line
                if(fileScanner.hasNextLine()) {
                    fileScanner.nextLine(); // Skip the blank line
                }
                
                // Create PolicyHolder and Policy objects
                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                Policy policy = new Policy(policyNumber, providerName, policyHolder);
                policies.add(policy);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        // Output
        for (Policy policy : policies) {
            System.out.println(policy); // This will call the toString() method of Policy class
        }

        // Display the number of policies created
        System.out.println("Total number of policies: " + Policy.getPolicyCount());
    }
}
