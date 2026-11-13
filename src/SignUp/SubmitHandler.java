package SignUp;

import javax.swing.*;
import java.io.File;
import java.security.SecureRandom;

public class SubmitHandler {

    public static void handleSubmit(
            JFrame frame,
            long formNumber,
            File panFile,
            File aadhaarFile,
            File photoFile,
            File signatureFile,
            boolean declarationAccepted
    ) {

        // Validate uploaded documents
        if (panFile == null ||
                aadhaarFile == null ||
                photoFile == null ||
                signatureFile == null) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Please upload all four documents.",
                    "Missing Documents",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Validate Declaration
        if (!declarationAccepted) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Please accept the declaration before submitting.",
                    "Declaration Required",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Generate Customer ID and Account Number
        SecureRandom random = new SecureRandom();

        long customerId = 10000000L + random.nextInt(90000000);
        long accountNumber = 100000000000L + (Math.abs(random.nextLong()) % 900000000000L);

        // Display Success Message
        JOptionPane.showMessageDialog(
                frame,
                "Registration Submitted Successfully!\n\n"
                        + "Form Number: " + formNumber + "\n"
                        + "Customer ID: " + customerId + "\n"
                        + "Account Number: " + accountNumber,
                "Registration Successful",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Close Registration Window
        frame.dispose();

        // Login page navigation will be added here.
    }
}
